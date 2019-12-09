package cn.edu.buu.yykj.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @ClassName VoiceService
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/12 11:09 下午
 **/
public interface VoiceService {
    boolean sendVoiceMsg(String msg) throws JsonProcessingException;
    boolean sendChatMsg(String msg) throws JsonProcessingException;
}
