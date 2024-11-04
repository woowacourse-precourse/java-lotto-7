package lotto;

import java.util.List;
import java.util.ArrayList;

public class Data {
    private int amount;
    private int ticketNumber;
    private ArrayList<Lotto> lottoTickets;
    private UserPick userPick;
    private ArrayList<Result> results;

    public Data() {
        lottoTickets = new ArrayList<Lotto>();
        results = new ArrayList<Result>();
        initResults();
    }

    public int getAmount() { return amount; }
    public int getTicketNumber() { return ticketNumber; }
    public ArrayList<Lotto> getLottoTickets() { return lottoTickets; }
    public UserPick getUserPick() { return userPick; }
    public ArrayList<Result> getResults() { return results; }
    public Result getResultAt(int idx) { return results.get(idx); }

    public void setAmountAndTicketNumber(int amount) {
        this.amount = amount;
        this.ticketNumber = this.amount / 1000;
    }

    public void addLottoTicket(Lotto lotto) { lottoTickets.add(lotto); }
    public void setUserPick(UserPick userPick) { this.userPick = userPick; }

    private void initResults() {
        for (Rank rank : Rank.values()) {
            results.add(new Result(rank));
        }
    }
}
