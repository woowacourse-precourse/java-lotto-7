package lotto.model;

public class Money {
    public static final Long TICKET_PRICE = 1000L;
    public static final String MONEY_INPUT_MINIMUM_ERROR_MESSAGE = "로또 1장가격보다 큰 수이어야 합니다";
    public static final String CANNOT_BUY_TICKET_ERROR_MESSAGE = "로또 가격 배수로 입력해주세요, 로또 1장은 1000원입니다.";
    private Long money;

    public Money(Long money) {
        this.money = money;
        validate();
    }

    private void validate() {
        numberValidate();
        makeToTicketValidate();
    }

    private void numberValidate() {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException(MONEY_INPUT_MINIMUM_ERROR_MESSAGE);
        }
    }

    private void makeToTicketValidate() {
        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(CANNOT_BUY_TICKET_ERROR_MESSAGE);
        }
    }

    public Long getMoney() {
        return money;
    }

    public Long getTickets() {
        return money / TICKET_PRICE;
    }

}
