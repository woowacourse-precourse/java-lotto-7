package lotto;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.domain.*;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();
        Lottos lottos = LottoNumberGenerator.generate(totalPrice.getTotalLottoCount());

        printDrawingResult(lottos);

        Lotto lotto = setLottoNumbers();
        BonusNumber bonusNumber = setBonusNumber(lotto);

        return LottoGame.of(totalPrice, lottos, lotto, bonusNumber);
    }

    private BonusNumber setBonusNumber(Lotto winningNumbers) {
        return BonusNumber.of(ConsoleInput.getBonusNumberInput(), winningNumbers);
    }

    private Lotto setLottoNumbers() {
        return Lotto.from(ConsoleInput.getWinningNumbers());
    }

    private void printDrawingResult(Lottos lottos) {
        ConsoleOutput.print(lottos.toString());
    }

    private LottoPrice setTotalPrice() {
        return LottoPrice.valueOf(ConsoleInput.getTotalPrice());
    }
}
