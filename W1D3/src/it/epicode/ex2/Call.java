package it.epicode.ex2;

public class Call {

    private int duration;
    private String phoneNumber;

    public Call(int duration, String phoneNumber) {
        this.duration = duration;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return duration + " minutes to " + phoneNumber;
    }

}
