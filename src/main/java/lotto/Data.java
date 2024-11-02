package lotto;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private int amount;
    private int ticketNum;
    private ArrayList<Lotto> lottoTickets;

    public Data() {
        lottoTickets = new ArrayList<Lotto>();
    }

    public int getAmount() { return amount; }
    public int getTicketNum() { return ticketNum; }
    public ArrayList<Lotto> getLottoTickets() { return lottoTickets; }

    public void setAmountAndTicketNum(int amount) {
        this.amount = amount;
        this.ticketNum = this.amount / 1000;
    }

    public void addLottoTicket(Lotto lotto) { lottoTickets.add(lotto); }
}
