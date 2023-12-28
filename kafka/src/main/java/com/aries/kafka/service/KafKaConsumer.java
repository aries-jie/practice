package com.aries.kafka.service;

import com.aries.kafka.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    // 重试 5 次，重试间隔 100 毫秒,最大间隔 1 秒
    @RetryableTopic(
            attempts = "5",
            backoff = @Backoff(delay = 100, maxDelay = 1000)
    )
    @KafkaListener(topics = AppConstants.TOPIC_NAME,
                    groupId = AppConstants.GROUP_ID)
    public void consume1(String message){
        LOGGER.info(String.format("Group1 Message received -> %s", message));
        if (message.contains("ERROR")) {
            throw new RuntimeException("Group1 error");
        }
    }


//    @KafkaListener(topics = AppConstants.TOPIC_NAME,
//            groupId = AppConstants.GROUP_ID_2)
//    public void consume2(String message){
//        LOGGER.info(String.format("Group2 Message received -> %s", message));
//    }


}