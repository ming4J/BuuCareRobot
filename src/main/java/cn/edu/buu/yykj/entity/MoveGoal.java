package cn.edu.buu.yykj.entity;


import edu.wpi.rail.jrosbridge.messages.geometry.Point;
import edu.wpi.rail.jrosbridge.messages.geometry.Pose;
import edu.wpi.rail.jrosbridge.messages.geometry.PoseStamped;
import edu.wpi.rail.jrosbridge.messages.geometry.Quaternion;
import edu.wpi.rail.jrosbridge.messages.std.Header;
import edu.wpi.rail.jrosbridge.primitives.Time;


import java.util.Date;

/**
 * @ClassName MoveGoal
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/12 1:22 下午
 **/

public class MoveGoal {

    private MoveGoal(){

    }
    public static PoseStamped getMoveGoal(Header header, Pose pose){
        return new PoseStamped(header,pose);
    }
    public static Header getHeader(){
        return new Header(0,Time.fromDate(new Date()),"map");
    }
    public static Pose getPose(double px, double py, double pz,double ox,double oy, double oz, double ow){
            return new Pose(new Point(px,py,pz),new Quaternion(ox,oy,oz,ow));
    }
}
