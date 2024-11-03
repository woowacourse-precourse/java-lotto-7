package lotto;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private int amount;
    private int ticketNumber;
    private ArrayList<Lotto> lottoTickets;
    private UserPick userPick;

    public Data() {
        lottoTickets = new ArrayList<Lotto>();
    }

    public int getAmount() { return amount; }
    public int getTicketNumber() { return ticketNumber; }
    public ArrayList<Lotto> getLottoTickets() { return lottoTickets; }
    public UserPick getUserPick() { return userPick; }

    public void setAmountAndTicketNumber(int amount) {
        this.amount = amount;
        this.ticketNumber = this.amount / 1000;
    }

    public void addLottoTicket(Lotto lotto) { lottoTickets.add(lotto); }
    public void setUserPick(UserPick userPick) { this.userPick = userPick; }
}
