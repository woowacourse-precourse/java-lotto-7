package lotto;

import lotto.console.ConsoleInput;
import lotto.domain.*;
import lotto.enums.InputType;
import lotto.util.LottoPrinter;

public class LottoGameSetter {

    public static LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();
        Lottos purchasedLottos = LottoNumberGenerator.generate(totalPrice.getTotalLottoCount());

        LottoPrinter.print(purchasedLottos);

        Lotto winningNumbers = setWinningNumbers();
        BonusNumber bonusNumber = setBonusNumber(winningNumbers);

        return LottoGame.of(totalPrice, purchasedLottos, winningNumbers, bonusNumber);
    }

    private static BonusNumber setBonusNumber(Lotto winningNumbers) {
        BonusNumber bonusNumber;

        while(true) {
            try {
                bonusNumber = BonusNumber.of(ConsoleInput.getInput(InputType.BONUS_NUMBER), winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                LottoPrinter.printError(e);
            }
        }

        return bonusNumber;
    }

    private static Lotto setWinningNumbers() {
        Lotto lotto;

        while(true) {
            try{
                lotto = Lotto.from(ConsoleInput.getInput(InputType.WINNING_NUMBERS));
                break;
            } catch (IllegalArgumentException e) {
                LottoPrinter.printError(e);
            }
        }

        return lotto;
    }

    private static LottoPrice setTotalPrice() {
        LottoPrice lottoPrice;

        while(true) {
            try {
                lottoPrice = LottoPrice.valueOf(ConsoleInput.getInput(InputType.TOTAL_PRICE));
                break;
            } catch (IllegalArgumentException e) {
                LottoPrinter.printError(e);
            }
        }

        return lottoPrice;
    }
}
