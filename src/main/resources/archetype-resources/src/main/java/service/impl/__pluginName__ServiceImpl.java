#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package}.service.impl;

import com.alibaba.fastjson.JSON;
import com.terwergreen.core.CommonService;
import ${package}.service.${pluginName}Service;
import com.terwergreen.pojo.SiteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务实现
 *
 * @author Terwer
 * @version 1.0
 * $date
 **/
@Service
public class ${pluginName}ServiceImpl implements ${pluginName}Service {
    private static final Logger logger = LoggerFactory.getLogger(${pluginName}ServiceImpl.class);

    @Autowired
    private CommonService commonService;

    @Override
    public String get${pluginName}Info() {
        SiteConfig siteConfig = commonService.getSiteConfig();
        if (null != siteConfig) {
        return JSON.toJSONString(siteConfig);
        }
        return "no data";
        }
    }
