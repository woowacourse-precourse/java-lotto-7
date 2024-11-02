package lotto;

public class LottoTicketFactory {

    public static int getLottoTicketCount(String money) {
        int moneyInt= Integer.parseInt(money);
        return moneyInt / 1000;
    }
}
