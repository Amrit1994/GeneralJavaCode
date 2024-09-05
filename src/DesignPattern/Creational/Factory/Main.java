package DesignPattern.Creational.Factory;


public class Main {
    public static void main(String[] args) {
        NotificationFactory factory1 = new EmailNotificationFactory();
        Notification notification1 = factory1.createNotification();
        notification1.notifyUser();

        NotificationFactory factory2 = new SMSNotificationFactory();
        Notification notification2 = factory2.createNotification();
        notification2.notifyUser();

        NotificationFactory factory3 = new PushNotificationFactory();
        Notification notification3 = factory3.createNotification();
        notification3.notifyUser();
    }
}
