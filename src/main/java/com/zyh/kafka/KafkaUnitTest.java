package com.zyh.kafka;

import info.batey.kafka.unit.KafkaUnit;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author zhangyinghui  Date: 2020/8/23 Time: 9:26 PM
 */
public class KafkaUnitTest {
    public static void main(String[] args) {
        try {
            //kafka server start
            KafkaUnit kafkaUnitServer = new KafkaUnit(5000, 5001);
            kafkaUnitServer.startup();


            //create topic
            kafkaUnitServer.createTopic("zyh-test");

            //send msg
            kafkaUnitServer.sendMessages(new ProducerRecord<String, String>("zyh-test", "aaa"));

            //

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
