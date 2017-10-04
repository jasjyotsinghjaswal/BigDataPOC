package org.practice;
import java.util.*;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducer {
	
	public static void main(String args[])
	{
		Properties properties = new Properties();

        // kafka bootstrap server
        properties.setProperty("bootstrap.servers", "192.168.187.149:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // producer acks
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<String, String>("first_topic",args[0]);
        producer.send(producerRecord);
        producer.close();

}
}