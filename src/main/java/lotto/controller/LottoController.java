package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.io.InputReader;
import lotto.io.view.View;
import lotto.utils.NumberInputConverter;

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
        LottoMachine lottoMachine = new LottoMachine(RandomLottoGenerator.getInstance());
        LottoMoney money = requestMoney();
        List<Lotto> lottos = lottoMachine.purchaseLottoWith(money);
        showPurchaseInfo(lottos);
        List<Integer> userInputWinningNumbers = requestWinningNumbers();
        int bonusNumberValue = requestBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(userInputWinningNumbers), LottoNumber.of(bonusNumberValue));
    }

    private void showPurchaseInfo(List<Lotto> lottos) {
        LottosDto lottosDto = toDto(lottos);
        view.getLottoBuyView().showBuyInfo(lottosDto);
    }

    private int requestBonusNumber() {
        view.getInputView().showBonusNumberExplanation();
        return numberInputConverter.toInt(reader.read());
    }

    private List<Integer> requestWinningNumbers() {
        view.getInputView().showWinningNumberExplanation();
        return numberInputConverter.toList(reader.read());
    }

    private LottoMoney requestMoney() {
        view.getInputView().showMoneyInputExplanation();
        int userInputMoney = numberInputConverter.toInt(reader.read());
        return LottoMoney.of(userInputMoney);
    }

    private LottosDto toDto(List<Lotto> lottos) {
        List<LottoDto> lottoDtos = lottos.stream()
                .map(Lotto::getNumbers)
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::getNumber)
                        .toList())
                .map(LottoDto::new)
                .toList();
        return new LottosDto(lottoDtos);
    }
}
