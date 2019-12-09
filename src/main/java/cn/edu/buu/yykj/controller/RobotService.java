package cn.edu.buu.yykj.controller;

import cn.edu.buu.yykj.entity.Command;
import cn.edu.buu.yykj.entity.State;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @ClassName RobotService
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:26 下午
 **/
public interface RobotService {
    State service (Command command) throws JsonProcessingException;
}
