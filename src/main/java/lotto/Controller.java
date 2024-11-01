package lotto;

import static lotto.User.LOTTO_PRICE;

import lotto.validator.BonusNumber;
import lotto.validator.Money;
import lotto.validator.WinningNumber;

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
        String inputWinningNumber = InputUI.winningNumber();
        WinningNumber winningNumber = new WinningNumber(inputWinningNumber);
        while (true) {
            try {
                winningNumber.isDelimitedByComma();
                winningNumber.isNaturalNumber();
                winningNumber.isSameNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumber = new WinningNumber(InputUI.winningNumber());
            }
        }

        String inputBonusNumber = InputUI.bonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        while (true) {
            try {
                bonusNumber.isNaturalNumber();
                bonusNumber.isExistedNumber(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonusNumber = new BonusNumber(InputUI.bonusNumber());
            }
        }

        DrawLotto lotto = new DrawLotto(inputWinningNumber, inputBonusNumber);
        lotto.showResult(user);
    }
}
