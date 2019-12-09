package cn.edu.buu.yykj.service.serviceimpl;

import cn.edu.buu.yykj.dao.AddressDao;
import cn.edu.buu.yykj.entity.Address;
import cn.edu.buu.yykj.entity.Command;
import cn.edu.buu.yykj.entity.MoveGoal;
import cn.edu.buu.yykj.service.QueryService;
import com.alibaba.fastjson.JSONObject;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.messages.geometry.PoseStamped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName QueryServiceImpl
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:45 下午
 **/
@Service
public class QueryServiceImpl implements QueryService {

    private AddressDao addressDao;

    private Integer code;

    private String msg;

    private volatile boolean flag = true;

    private Ros ros;
    @Autowired
    public QueryServiceImpl(AddressDao addressDao,Ros ros) {
        this.addressDao = addressDao;
        this.ros = ros;
    }

    @Override
    public Integer queryLock() {
        if(ros.connect()){
            return addressDao.queryLock();
        }else {
            return -1;
        }

    }

    @Override
    public Integer updateUseLock(Integer code) {
        return addressDao.updateUseLock(code);
    }

    @Override
    public Integer doService(Command command) {
        if (ros.connect() && queryLock() == 1) {
            Address address = addressDao.queryAddress(command.getRoomId());
            PoseStamped poseStamped = MoveGoal.getMoveGoal(
                    MoveGoal.getHeader(),
                    MoveGoal.getPose(
                            address.getPX(),
                            address.getPY(),
                            address.getPZ(),
                            address.getOX(),
                            address.getOY(),
                            address.getOZ(),
                            address.getOW()));
            Topic topic = new Topic(ros, "/move_base_simple/goal", "geometry_msgs/PointStamped");
            topic.publish(new Message(poseStamped.toJsonObject(), "geometry_msgs/PointStamped"));
            Topic back = new Topic(ros, "/move_base/result", "move_base_msgs/MoveBaseActionResult");
            back.subscribe(new TopicCallback() {
                @Override
                public void handleMessage(Message message) {
                    msg = message.toString();
                    flag = false;
                }
            });
            while (flag || StringUtils.isEmpty(msg)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            JSONObject jsonObject = JSONObject.parseObject(msg);
            jsonObject = jsonObject.getJSONObject("status");
            code = Integer.valueOf(jsonObject.get("status").toString());
            ros.disconnect();
            back.unsubscribe();
            return code != 3 ? -1 : code;
        }else {
            return -1;
        }
    }
}
