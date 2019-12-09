package cn.edu.buu.yykj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AppConfig
 * @Description //TODO
 * @Author shellming
 * @Date 2019/11/11 7:36 下午
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("cn.edu.buu.*")
public class AppConfig {
}
