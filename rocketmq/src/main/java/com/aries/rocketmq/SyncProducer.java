package com.aries.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {
  public static void main(String[] args) throws Exception {
    // Instantiate with a producer group name
    DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
    // Specify name server addresses
    producer.setNamesrvAddr("localhost:9876");
    // Launch the producer instance
    producer.start();
    for (int i = 0; i < 100; i++) {
      // Create a message instance with specifying topic, tag and message body
      Message msg = new Message("TopicTest" /* Topic */,
        "TagA" /* Tag */,
        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
      // Send message to one of brokers
      SendResult sendResult = producer.send(msg);
      // Check whether the message has been delivered by the callback of sendResult
      System.out.printf("%s%n", sendResult);
    }
    // Shut down once the producer instance is not longer in use
    producer.shutdown();
  }
}