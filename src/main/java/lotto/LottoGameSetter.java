package lotto;

import lotto.console.ConsoleInput;
import lotto.domain.*;
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
        return BonusNumber.of(ConsoleInput.getBonusNumberInput(), winningNumbers);
    }

    private static Lotto setWinningNumbers() {
        return Lotto.from(ConsoleInput.getWinningNumbers());
    }

    private static LottoPrice setTotalPrice() {
        return LottoPrice.valueOf(ConsoleInput.getTotalPrice());
    }
}
