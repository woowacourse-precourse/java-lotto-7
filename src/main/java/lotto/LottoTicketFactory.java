package lotto;

public class LottoTicketFactory {
    private static final int TICKET_PRICE = 1000;

    public static int getLottoTicketCount(String money) {
        int moneyInt = Integer.parseInt(money);

        if (moneyInt % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이 아닙니다.");
        }
        return moneyInt / TICKET_PRICE;
    }
}
