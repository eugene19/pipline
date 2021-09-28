package by.epam.pipeline;

import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import java.util.Date;

@EnableBinding(Source.class)
public class Generator {

    @Autowired
    private Source source;

    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public String generateTestMessage() {
        return "Yauhen [" + DateUtils.formatDate(new Date(), "dd MMM yyyy HH:mm:ss") + "]";
    }
}
