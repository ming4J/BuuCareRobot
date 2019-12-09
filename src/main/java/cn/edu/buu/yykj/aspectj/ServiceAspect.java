package cn.edu.buu.yykj.aspectj;

import cn.edu.buu.yykj.service.QueryService;
import cn.edu.buu.yykj.service.VoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ServiceAspect
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:07 下午
 **/
@Aspect
@Component
public class ServiceAspect {

    private QueryService queryService;

    private VoiceService voiceService;

    @Autowired
    public ServiceAspect(QueryService queryService,VoiceService voiceService) {
        this.voiceService = voiceService;
        this.queryService = queryService;
    }

    @Pointcut("execution(* cn.edu.buu.yykj.controller.RobotControllerImpl.service(..))")
    public void service(){ }

    @Before("service()")
    public void beforeTask() throws JsonProcessingException {
        queryService.updateUseLock(1);
        voiceService.sendVoiceMsg("我来了");
    }

    @After("service()")
    public void afterTask() throws JsonProcessingException {
        queryService.updateUseLock(0);
        voiceService.sendVoiceMsg("我到了");
    }

    @AfterThrowing("service()")
    public void taskException() throws JsonProcessingException {
        voiceService.sendVoiceMsg("我遇到问题了，救救孩子吧！");
    }
}
