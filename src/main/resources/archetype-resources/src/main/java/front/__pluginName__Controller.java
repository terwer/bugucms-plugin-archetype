#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package}.front;

import ${package}.service.${pluginName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author Terwer
 * @version 1.0
 * 2018/11/29 1:23
 **/
@Controller
@RequestMapping("${pluginShortName}")
public class ${pluginName}Controller {
    @Autowired
    private ${pluginName}Service ${pluginShortName}Service;

    @RequestMapping(produces = {"text/plain;charset=utf-8"})
    @ResponseBody
    public String ${pluginShortName}() {
        return ${pluginShortName}Service.get${pluginName}Info();
    }
}
