package cn.edu.buu.yykj.dao;

import cn.edu.buu.yykj.entity.Address;
import org.springframework.stereotype.Repository;


/**
 * @ClassName AddressQuery
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:51 下午
 **/
@Repository
public interface AddressDao {
    Address queryAddress (String roomId);

    Integer queryLock();

    Integer updateUseLock(Integer code);
}
