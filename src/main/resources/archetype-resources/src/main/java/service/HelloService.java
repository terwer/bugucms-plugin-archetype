#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

/**
 * @Author Terwer
 * @Date 2018/11/23 15:53
 * @Version 1.0
 * @Description 业务接口
 **/
public interface HelloService {
    /**
     * 获取系统信息
     * @return
     */
    String getSystemInfo();
}
