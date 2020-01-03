package only.luzejin.common.topic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 包名称：only.luzejin.common.topic
 * 类名称：KafkaTopic
 * 类描述：kafka主题
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 17:34
 */
@ConfigurationProperties("common.topic")
@Getter
@Setter
public class KafkaTopic {

    private String testTopic;
}
