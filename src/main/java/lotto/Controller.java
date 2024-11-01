package lotto;

import static lotto.User.LOTTO_PRICE;

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
    }

    public void buying() {
        user.buyLotto();

        System.out.println("\n" + user.getMoneyAmount() / LOTTO_PRICE + "개를 구매했습니다.");
        for (Lotto lotto : user.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void drawLotto() {
        DrawLotto lotto = new DrawLotto(InputUI.winningNumber(), InputUI.bonusNumber());
        lotto.getWinningNumbers();
    }
}
