package RestfulWebServer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        Thread t = new Thread(new Mock.Daemon());
        t.setDaemon(true);
        t.start();
        SpringApplication.run(Application.class, args);
    }
}