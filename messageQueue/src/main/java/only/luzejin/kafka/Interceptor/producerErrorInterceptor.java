package only.luzejin.kafka.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * 包名称：only.luzejin.rabbitmq
 * 类名称：producerErrorInterceptor
 * 类描述：kafka发送消息错误日志
 * 创建人：@author luzejin
 * 创建时间：2020-1-3 11:35
 */
@Slf4j
public class producerErrorInterceptor implements ProducerInterceptor<String,String> {
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return null;
    }

    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e == null){
            log.info("发送主题{},分区{}",recordMetadata.topic(),recordMetadata.partition());
        }else{
            log.error("消息发送失败{}",e.getMessage());
        }
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}
