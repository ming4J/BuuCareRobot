package cn.edu.buu.yykj.entity;

import lombok.Data;


/**
 * @ClassName StringMessage
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 9:02 上午
 **/
@Data
public class StringMessage {
    private String data;
    public StringMessage(){

    }
    public StringMessage(String msg){
        this.data = msg;
    }

}
