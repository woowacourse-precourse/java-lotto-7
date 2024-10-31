package lotto;

public class Data {
    private int amount;
    private int ticketNum;

    public void setAmountAndTicketNum(int _amount) {
        amount = _amount;
        ticketNum = amount / 1000;
    }

    public int getAmount() { return amount; }
    public int getTicketNum() { return ticketNum; }
}