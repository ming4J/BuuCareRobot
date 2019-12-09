package cn.edu.buu.yykj.service;
import cn.edu.buu.yykj.entity.Command;


/**
 * @ClassName QueryService
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:44 下午
 **/

public interface QueryService {

    Integer queryLock();
    Integer updateUseLock(Integer code);
    Integer doService(Command command);
}
