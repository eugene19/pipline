package by.epam.pipeline;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;

@EnableBinding({Sink.class, KafkaProcessor.class})
public class Consumer {

    @Autowired
    private FileSystem hdfs;

    @StreamListener(Sink.INPUT)
    @SendTo(KafkaProcessor.OUTPUT)
    public String streamFromRabbitToKafka(String str) {
        System.out.println("Receive message: " + str);
        return str;
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void streamFromKafkaToHdfs(String str) {
        System.out.println("Received from kafka: " + str);
        try {
            writeToHdfs(str);
        } catch (IOException e) {
            System.out.println("Error while writing to HDFS");
        }
    }

    @Value("${spring.hdfs.directory}")
    private String DIR_NAME;
    @Value("${spring.hdfs.filename}")
    private String FILE_NAME;

    private void writeToHdfs(String str) throws IOException {
        Path dir = new Path(Path.SEPARATOR + DIR_NAME);
        Path file = new Path(Path.SEPARATOR + DIR_NAME + Path.SEPARATOR + FILE_NAME);
        if (!hdfs.exists(dir)) {
            System.out.println("Creating dir and file");
            hdfs.mkdirs(dir);
            hdfs.create(file).close();
        }

        FSDataOutputStream output = hdfs.append(file);
        output.writeUTF(str);
        output.flush();
        output.close();
    }
}
