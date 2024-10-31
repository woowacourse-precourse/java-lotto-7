package lotto;

import lotto.validator.Money;

public class Controller {
    private User user;

    public void start() {
        Money money = new Money(InputUI.moneyAmount());
        while (true) {
            try {
                money.isNaturalNumber();
                money.isMultipleOfLottoPrice();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                money = new Money(InputUI.moneyAmount());
            }
        }

        this.user = new User(money.getAmount());
        System.out.println("구입금액 : " + user.getMoneyAmount());
    }
}
