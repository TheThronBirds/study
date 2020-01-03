package only.luzejin.config;

import only.luzejin.common.topic.KafkaTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 包名称：only.luzejin.config
 * 类名称：KafkaTopicConfig
 * 类描述：kafka主题
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 17:14
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    @ConditionalOnMissingBean
    public KafkaTopic getKafkaTopic(){
        return new KafkaTopic();
    }

}
