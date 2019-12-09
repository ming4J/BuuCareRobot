package cn.edu.buu.yykj.entity;

import lombok.Data;

/**
 * @ClassName State
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:28 下午
 **/
@Data
public class State {
    private Integer code;
    private String message;
    public State(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
