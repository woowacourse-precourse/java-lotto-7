package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.io.InputReader;
import lotto.io.view.View;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final NumberInputConverter numberInputConverter = NumberInputConverter.getInstance();
    private final InputReader reader;
    private final View view;

    public LottoController(InputReader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    public void run() {
        view.getInputView().showMoneyInputExplanation();
        int userInputMoney = numberInputConverter.toInt(reader.read());
        LottoMoney money = LottoMoney.of(userInputMoney);
        view.getInputView().showWinningNumberExplanation();
        List<Integer> userInputWinningNumbers = numberInputConverter.toList(reader.read());
        view.getInputView().showBonusNumberExplanation();
        int bonusNumberValue = numberInputConverter.toInt(reader.read());
        WinningLotto winningLotto = new WinningLotto(new Lotto(userInputWinningNumbers), LottoNumber.of(bonusNumberValue));
    }
}
