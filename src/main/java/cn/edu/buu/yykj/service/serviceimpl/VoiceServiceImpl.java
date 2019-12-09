package cn.edu.buu.yykj.service.serviceimpl;

import cn.edu.buu.yykj.entity.StringMessage;
import cn.edu.buu.yykj.service.VoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName VoiceServiceImpl
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/12 11:11 下午
 **/
@Service
public class VoiceServiceImpl implements VoiceService {
    @Autowired
    private Ros ros;
    public VoiceServiceImpl(Ros ros){
        this.ros = ros;
    }
    @Override
    public boolean sendVoiceMsg(String msg) throws JsonProcessingException {

            if (ros.connect()){
                Topic topic = new Topic(ros, "/voice_system/tts_topic", "std_msgs/String");
                StringMessage stringMessage = new StringMessage(msg);
                ObjectMapper objectMapper = new ObjectMapper();
                synchronized (topic){
                    Message message = new Message(objectMapper.writeValueAsString(stringMessage));
                    topic.publish(message);
                    ros.disconnect();
                    return true;
                }
            }else {
                return false;
            }
        }

    @Override
    public boolean sendChatMsg(String msg) throws JsonProcessingException {

        if (ros.connect()){
            Topic topic = new Topic(ros, "/voice_system/nlu_topic", "std_msgs/String");
            StringMessage stringMessage = new StringMessage(msg);
            ObjectMapper objectMapper = new ObjectMapper();
            synchronized (topic){
                Message message = new Message(objectMapper.writeValueAsString(stringMessage));
                topic.publish(message);
                ros.disconnect();
                return true;
            }
        }else {
            return false;
        }
    }

}
