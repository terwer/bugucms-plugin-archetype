#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package};

import ${groupId}.plugins.BugucmsPlugin;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插件
 *
 * @author Terwer
 * @version 1.0
 * ${date}
 **/
public class ${pluginName}Plugin extends BugucmsPlugin {
    private static final Logger logger = LoggerFactory.getLogger(${pluginName}Plugin.class);

    public ${pluginName}Plugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() throws PluginException {
        super.start();
        logger.info("${pluginName}Plugin started");
    }

    @Override
    public void stop() {
        super.stop();
        logger.info("${pluginName}Plugin stoped");
    }
}
