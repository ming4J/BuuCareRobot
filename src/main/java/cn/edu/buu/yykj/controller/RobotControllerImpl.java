package cn.edu.buu.yykj.controller;

import cn.edu.buu.yykj.entity.Command;
import cn.edu.buu.yykj.entity.State;
import cn.edu.buu.yykj.entity.StringMessage;
import cn.edu.buu.yykj.service.QueryService;
import cn.edu.buu.yykj.service.VoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AddressController
 * @Description //TODO
 * @Author shellming
 * @Date 2019/10/15 3:01 上午
 **/
@RestController
@RequestMapping("/ros")
public class RobotControllerImpl implements RobotService {

    private QueryService queryService;

    private VoiceService voiceService;

    @Autowired
    public RobotControllerImpl(QueryService queryService,VoiceService voiceService) {
        this.queryService = queryService;
        this.voiceService = voiceService;
    }
    @RequestMapping(value = "/state",method = RequestMethod.GET)
    public State state(){
        Integer integer = queryService.queryLock();
        if ( integer == 1){
            return new State(100,"正在忙....");
        }else if(integer == 0){
            return new State(200,"可用");
        }else {
            return new State(400,"连接异常");
        }

    }
    @RequestMapping(value = "/service",method = RequestMethod.POST)
    @Override
    public State service(@RequestBody Command command) throws JsonProcessingException {
        System.out.println(command.toString());
        int code = queryService.doService(command);
        if (code == 3){
            return new State(300,"成功到达");
        }else {
            return new State(500,"遇到错误");
        }
    }

    @RequestMapping(value = "/chat",method = RequestMethod.POST)
    public State chat(@RequestBody StringMessage stringMessage) throws JsonProcessingException {
        if (voiceService.sendChatMsg(stringMessage.getData())){
            return new State(200,"成功");
        }else {
            return new State(400,"错误");
        }

    }

    @RequestMapping(value = "/asr",method = RequestMethod.POST)
    public State asr(@RequestBody StringMessage stringMessage) throws JsonProcessingException {
        System.out.println(stringMessage);
        if (voiceService.sendVoiceMsg(stringMessage.getData())){
            return new State(200,"成功");
        }else {
            return new State(400,"错误");
        }

    }
}
