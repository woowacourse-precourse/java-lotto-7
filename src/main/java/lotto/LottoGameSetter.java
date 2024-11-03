package lotto;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.domain.*;

public class LottoGameSetter {

    public LottoGame set() {

        LottoPrice totalPrice = setTotalPrice();
        Lottos lottos = LottoNumberGenerator.generate(totalPrice.getTotalLottoCount());

        printDrawingResult(lottos);

        LottoNumbers lottoNumbers = setLottoNumbers();
        BonusNumber bonusNumber = setBonusNumber(lottoNumbers);

        return LottoGame.of(totalPrice, lottos, lottoNumbers, bonusNumber);
    }

    private BonusNumber setBonusNumber(LottoNumbers winningNumbers) {
        return BonusNumber.of(ConsoleInput.getBonusNumberInput(), winningNumbers);
    }

    private LottoNumbers setLottoNumbers() {
        return LottoNumbers.from(ConsoleInput.getWinningNumbers());
    }

    private void printDrawingResult(Lottos lottos) {
        ConsoleOutput.print(lottos.toString());
    }

    private LottoPrice setTotalPrice() {
        return LottoPrice.valueOf(ConsoleInput.getTotalPrice());
    }
}
