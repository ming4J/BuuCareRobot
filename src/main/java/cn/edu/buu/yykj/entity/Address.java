package cn.edu.buu.yykj.entity;

import lombok.Data;

/**
 * @ClassName Address
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:40 下午
 **/
@Data
public class Address {
    private String roomId;
    private String roomName;
    private Double pX;
    private Double pY;
    private Double pZ;
    private Double oX;
    private Double oY;
    private Double oZ;
    private Double oW;
}
