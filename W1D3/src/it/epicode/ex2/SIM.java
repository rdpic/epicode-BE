package it.epicode.ex2;

public class SIM {

    private String phoneNumber;
    private double credit;
    private Call[] callHistory;
    private int callCount;

    public SIM(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.credit = 0;
        this.callHistory = new Call[5];
        this.callCount = 0;
    }

    public void addCall(Call call) {
        if (callCount < 5) {
            callHistory[callCount] = call;
            callCount++;
        } else {
            System.arraycopy(callHistory, 1, callHistory, 0, callHistory.length - 1);
            callHistory[callHistory.length - 1] = call;
        }
    }

    public void printSIMData() {
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Credit: €" + credit);
        System.out.println("Call History:");
        for (Call call : callHistory) {
            if (call != null) {
                System.out.println(call);
            }
        }
    }


}
