package DesignPattern.SOLID.ISP;

import DesignPattern.SOLID.OCP.Member;

public interface SMSNotification {
    void sendSMS(Member member);
}

class SMSNotifier implements SMSNotification {

    @Override
    public void sendSMS(Member member) {
        // send sms notification
    }
}