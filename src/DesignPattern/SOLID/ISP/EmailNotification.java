package DesignPattern.SOLID.ISP;

import DesignPattern.SOLID.OCP.Member;

// Interface Segregation Principle (ISP)
// The Interface Segregation Principle states that no client should be forced to depend on methods it does not use.
// This means creating smaller, more specific interfaces
public interface EmailNotification {
    void sendEmail(Member member);
}

class EmailNotifier implements EmailNotification {

    @Override
    public void sendEmail(Member member) {
        // send email notification
    }
}
