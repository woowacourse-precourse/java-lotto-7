package lotto;

public class LottoStore {
    private final int money;
    private int tickets;

    public LottoStore(String money) {
        this.money = Integer.parseInt(money);
    }

    public void changeTickets() {
        this.tickets = money/1000;
    }

    public int getTickets() {
        return tickets;
    }

}
