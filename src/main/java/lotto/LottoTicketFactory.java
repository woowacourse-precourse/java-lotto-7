package lotto;

public class LottoTicketFactory {
    private static final int TICKET_PRICE = 1000;

    public static int getLottoTicketCount(String money) {

        int moneyInt = isNumeric(money);

        if (moneyInt % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이 아닙니다.");
        }
        return moneyInt / TICKET_PRICE;
    }

    public static int isNumeric(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 감지되었습니다.");
        }
    }
}
