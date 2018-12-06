#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $ldt = $package.getClass().forName("java.time.LocalDateTime").getMethod("now").invoke(null) )
#set( $dtf = $package.getClass().forName("java.time.format.DateTimeFormatter").getMethod("ofPattern", $package.getClass()).invoke(null, "yyyy/MM/dd HH:mm:ss") )
#set( $date = $ldt.format($dtf) )
package ${package}.service.impl;

import com.alibaba.fastjson.JSON;
import ${groupId}.core.CommonDAO;
import ${package}.service.${pluginName}Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务实现
 *
 * @author Terwer
 * @version 1.0
 * $date
 **/
@Service
public class ${pluginName}ServiceImpl implements ${pluginName}Service {
    private static final Logger log = LoggerFactory.getLogger(${pluginName}ServiceImpl.class);

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public String get${pluginName}Info() {
        List list = null;
        try {
            Map paramMap = new HashMap();
            paramMap.put("optionGroup", "siteConfig");
            list = commonDAO.queryListByMap("getOptionByGroup", paramMap);
        } catch (Exception e) {
            log.error("获取配置项异常", e);
            return "current version:BuguCMS 2.0.0";
        }
        //多个结果返回List，只有一个结果的时候直接返回
        if (!CollectionUtils.isEmpty(list)) {
            return JSON.toJSONString(list);
        }
        return "no data";
    }
}
