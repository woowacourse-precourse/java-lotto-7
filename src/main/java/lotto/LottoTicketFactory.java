package lotto;

public class LottoTicketFactory {

    public static int getLottoTicketCount(String money) {
        int moneyInt = Integer.parseInt(money);

        if (moneyInt % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이 아닙니다.");
        }
        return moneyInt / 1000;
    }
}
