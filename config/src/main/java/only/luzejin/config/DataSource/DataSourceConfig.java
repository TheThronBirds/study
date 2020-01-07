package only.luzejin.config.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 包名称：only.luzejin.config.DataSource
 * 类名称：DataSourceConfig
 * 类描述：动态数据源配置类
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 18:08
 */
@Configuration
public class DataSourceConfig {

    @Value("only.study.profile: company")
    private String profile;

    @Bean("homeDataSource")
    @ConfigurationProperties("only.study.homeDataSource")
    public DataSource getHomeDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(20);
        return dataSource;
    }

    @Bean("companyDataSource")
    @ConfigurationProperties("only.study.companyDataSource")
    public DataSource getCompanyDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setMinimumIdle(10);
        dataSource.setMaximumPoolSize(20);
        return dataSource;
    }


    @Bean("dynamicDataSource")
    public DataSource getDynamicDatSource(@Qualifier("homeDataSource") DataSource homeDataSource,@Qualifier("companyDataSource") DataSource companyDataSource){
        Map<Object,Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put(DataSourceType.DataBaseType.Home,homeDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.Company,companyDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        if(profile.equals("company")){
            dataSource.setDefaultTargetDataSource(companyDataSource);
        }else{
            dataSource.setDefaultTargetDataSource(homeDataSource);
        }
        return dataSource;
    }



}
