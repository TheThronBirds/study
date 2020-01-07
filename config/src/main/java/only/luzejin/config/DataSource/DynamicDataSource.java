package only.luzejin.config.DataSource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 包名称：only.luzejin.config.DataSource
 * 类名称：DynamicDataSource
 * 类描述：动态数据源类
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 18:02
 */
@Getter
@Setter
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceType.getDataBaseType();
    }
}
