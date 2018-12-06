#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package};

import ${groupId}.plugins.PluginInterface;
import ${package}.front.${pluginName}Api;
import ${package}.front.${pluginName}Controller;
import ${package}.service.impl.${pluginName}ServiceImpl;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展点
 *
 * @author Terwer
 * @version 1.0
 * $date
 **/
@Extension
public class ${pluginName}PluginExtension implements PluginInterface {
    private static final Logger logger = LoggerFactory.getLogger(${pluginName}PluginExtension.class);
    private GenericApplicationContext applicationContext;

    public ${pluginName}PluginExtension(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("${pluginName}PluginExtension contructor");
        // 注册插件依赖
        registerBeans();
    }

    private void registerBeans() {
        applicationContext.registerBean(${pluginName}Controller.class);
        logger.info("${pluginName}PluginExtension registerBean " + ${pluginName}Controller.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(${pluginName}Api.class);
        logger.info("${pluginName}PluginExtension registerBean " + ${pluginName}Api.class + " in applicationContext " + applicationContext);
        applicationContext.registerBean(${pluginName}ServiceImpl.class);
        logger.info("${pluginName}PluginExtension registerBean " + ${pluginName}ServiceImpl.class + " in applicationContext " + applicationContext);
    }

    @Override
    public String identify() {
        return "${pluginName}Plugin identify in plugin";
    }

    @Override
    public List<?> reactiveRoutes() {
        return new ArrayList<RouterFunction<?>>() {{
        }};
    }

    @Override
    public Map data() {
        Map dataMap = new HashMap();
        dataMap.put("${pluginShortName}", "${pluginName}");
        return dataMap;
    }
}
