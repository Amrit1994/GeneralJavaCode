package DesignPattern.SOLID.OCP;

import java.util.List;

// Open closed principle
// Software entities should be open for extension but closed for modification.
public interface Notification {
    public void send(Member member);
}

class EmailNotification implements Notification {

    @Override
    public void send(Member member) {
        System.out.println("Send email notification");
    }
}

class SMSNotification implements Notification {

    @Override
    public void send(Member member) {
        System.out.println("Send email notification");
    }
}

class NotificationService {
    private final List<Notification> notifications;

    public NotificationService(List<Notification> notifications) {
        this.notifications = notifications;
    }
    public void sendOverdueNotification(Member member) {
        for (Notification notification : notifications) {
            notification.send(member);
        }
    }
}

