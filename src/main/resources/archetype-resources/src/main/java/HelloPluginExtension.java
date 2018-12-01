#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${groupId}.core.CommonService;
import ${groupId}.plugins.PluginInterface;
import ${package}.front.HelloApi;
import ${package}.front.HelloController;
import ${package}.service.impl.HelloServiceImpl;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Terwer
 * @Date 2018/11/27 16:03
 * @Version 1.0
 * @Description 扩展点
 **/
@Extension
public class HelloPluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(HelloPluginExtension.class);
    private GenericApplicationContext applicationContext;

    @Autowired
    private HelloApi helloApi;

    @Autowired
    private CommonService commonService;

    public HelloPluginExtension(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("HelloPluginExtension contructor");
        // 注册插件依赖
        registerBeans();
    }

    private void registerBeans() {
        applicationContext.registerBean(HelloController.class);
        logger.info("HelloPluginExtension registerBean " + HelloController.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(HelloApi.class);
        logger.info("HelloPluginExtension registerBean " + HelloApi.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(HelloServiceImpl.class);
        logger.info("HelloPluginExtension registerBean " + HelloServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "HelloPlugin identify in plugin,theme is:" + commonService.getSiteConfig("webtheme");
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
            add(helloApi.coreApi());
            add(helloApi.coreInfoApi());
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("securityOn", 1);
        dataMap.put("loginPath", "login");
        // 查询后台地址
        String adminPath = (String) commonService.getSiteConfig("adminPath");
        dataMap.put("adminPath", adminPath);
        return dataMap;
    }
}
