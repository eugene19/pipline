package by.epam.pipeline;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class PipelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PipelineApplication.class, args);
    }

    @Value("${spring.hdfs.url}")
    private String HDFS_URL;

    @Bean
    public FileSystem hdfs() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", HDFS_URL);
        configuration.set("dfs.client.block.write.replace-datanode-on-failure.enable", "true");
        configuration.set("dfs.client.block.write.replace-datanode-on-failure.policy", "ALWAYS");
        configuration.set("dfs.client.block.write.replace-datanode-on-failure.best-effort", "true");

        try {
            return FileSystem.get(configuration);
        } catch (IOException e) {
            System.err.println("Error while create HDFS bean: " + e);
            return null;
        }
    }
}
