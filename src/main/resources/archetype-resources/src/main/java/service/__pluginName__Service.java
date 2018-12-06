#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package}.service;

/**
 * 业务接口
 *
 * @author Terwer
 * @version 1.0
 * $date
 **/
public interface ${pluginName}Service {
    /**
     * 获取插件信息
     * @return 插件信息
     */
    String get${pluginName}Info();
}
