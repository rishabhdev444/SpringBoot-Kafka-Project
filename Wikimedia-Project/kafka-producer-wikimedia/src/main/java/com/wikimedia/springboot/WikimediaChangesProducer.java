package com.wikimedia.springboot;

import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import okhttp3.HttpUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws StreamException, InterruptedException, URISyntaxException {
        String topic="wikimedia_recent_change";

        //to read realtime stream data from wikimedia ,we use event source
        BackgroundEventHandler eventHandler=new WIkimediaChangesHandler(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource.Builder builder=new BackgroundEventSource.Builder(eventHandler,new EventSource.Builder(URI.create(url)));
        BackgroundEventSource eventSource=builder.build();
        eventSource.start();

//        EventSource.Builder builder=new EventSource.Builder(HttpUrl.get(new URI(url)));
//        EventSource eventSource=builder.build();
//        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
