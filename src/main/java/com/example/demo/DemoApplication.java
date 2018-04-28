package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.*;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    @Autowired
    UserMBean user;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        //User user = new User();
        //user.setUserName("Kns");

        ObjectName name = new ObjectName("test:type=User");

        mBeanServer.registerMBean(user, name);

    }

}
