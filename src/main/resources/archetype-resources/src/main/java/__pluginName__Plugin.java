#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${groupId}.plugins.BugucmsPlugin;
import org.pf4j.PluginException;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Terwer
 * @Date 2018/11/27 16:03
 * @Version 1.0
 * @Description Hello World
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
