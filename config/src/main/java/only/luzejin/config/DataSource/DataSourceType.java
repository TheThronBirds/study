package only.luzejin.config.DataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * 包名称：only.luzejin.config.DataSource
 * 类名称：DataSourceType
 * 类描述：动态数据源类型
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 17:46
 */
@Slf4j
public class DataSourceType {


    public enum DataBaseType {
        Company,
        Home;
    }

    private static final ThreadLocal<DataBaseType> DATA_BASE_TYPE_THREAD_LOCAL = new ThreadLocal<DataBaseType>();

    /**
     * 设置数据源
     * @param dataBaseType
     */
    public static void setDataBaseType(DataBaseType dataBaseType){
        if(dataBaseType == null){
            throw new NullPointerException("动态数据源不可设置为null");
        }
        log.info("当前数据源{}",dataBaseType.name());
        DATA_BASE_TYPE_THREAD_LOCAL.set(dataBaseType);
    }

    /**
     * 获取当前数据源
     * @return
     */
    public static DataBaseType getDataBaseType(){
        DataBaseType dataBaseType =  DATA_BASE_TYPE_THREAD_LOCAL.get() == null ? DataBaseType.Company : DATA_BASE_TYPE_THREAD_LOCAL.get();
        log.info("当前数据源{}",DATA_BASE_TYPE_THREAD_LOCAL.get().name());
        return dataBaseType;
    }

    /**
     * 清理数据源
     */
    public void clearDataBaseType(){
        DATA_BASE_TYPE_THREAD_LOCAL.remove();
    }

}
