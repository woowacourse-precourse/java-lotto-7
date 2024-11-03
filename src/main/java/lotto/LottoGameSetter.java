package lotto;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.domain.*;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();
        Lottos purchasedLottos = LottoNumberGenerator.generate(totalPrice.getTotalLottoCount());

        printDrawingResult(purchasedLottos);

        Lotto winningNumbers = setWinningNumbers();
        BonusNumber bonusNumber = setBonusNumber(winningNumbers);

        return LottoGame.of(totalPrice, purchasedLottos, winningNumbers, bonusNumber);
    }

    private BonusNumber setBonusNumber(Lotto winningNumbers) {
        return BonusNumber.of(ConsoleInput.getBonusNumberInput(), winningNumbers);
    }

    private Lotto setWinningNumbers() {
        return Lotto.from(ConsoleInput.getWinningNumbers());
    }

    private void printDrawingResult(Lottos lottos) {
        ConsoleOutput.print(lottos.toString());
    }

    private LottoPrice setTotalPrice() {
        return LottoPrice.valueOf(ConsoleInput.getTotalPrice());
    }
}
