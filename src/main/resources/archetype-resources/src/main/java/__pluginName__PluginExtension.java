#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${groupId}.core.CommonService;
import ${groupId}.plugins.PluginInterface;
import ${package}.front.${pluginName}Api;
import ${package}.front.${pluginName}Controller;
import ${package}.service.impl.${pluginName}ServiceImpl;
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
public class ${pluginName}PluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(${pluginName}PluginExtension.class);
    private GenericApplicationContext applicationContext;

    @Autowired
    private ${pluginName}Api ${pluginShortName}Api;

    @Autowired
    private CommonService commonService;

    public HelloPluginExtension(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("${pluginName}PluginExtension contructor");
        // 注册插件依赖
        registerBeans();
    }

    private void registerBeans() {
        applicationContext.registerBean(${pluginName}Controller.class);
        logger.info("HelloPluginExtension registerBean " + ${pluginName}Controller.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(${pluginName}Api.class);
        logger.info("HelloPluginExtension registerBean " + ${pluginName}Api.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(${pluginName}ServiceImpl.class);
        logger.info("HelloPluginExtension registerBean " + ${pluginName}ServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "${pluginName}Plugin identify in plugin,theme is:" + commonService.getSiteConfig("webtheme");
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
            add(${pluginShortName}Api.coreApi());
            add(${pluginShortName}Api.coreInfoApi());
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
