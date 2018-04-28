package com.example.demo;


import org.springframework.stereotype.Component;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

@Component
public class User extends NotificationBroadcasterSupport implements UserMBean {


    private Long id;
    private String userName = "Ksn1";
    private String password;




    private long sequenceNumber = 1;

    @Override
    public void setUserName(String userName) {
        Notification n = new AttributeChangeNotification(
                this,
                sequenceNumber++,
                System.currentTimeMillis(),
                "Username has changed",
                "Username",
                "String",
                this.userName,
                userName
        );
        sendNotification(n);
        this.userName = userName;
    }



    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {

        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "Username of this Bean has changed";

        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);

        return new MBeanNotificationInfo[]{info};
    }




    @Override
    public void printUserInfo() {
        System.out.println("This is user with username: " + userName);
    }



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}