package lotto.controller;

import lotto.domain.play.RandomLottoGenerator;
import lotto.domain.play.Result;
import lotto.domain.purchase.LottoMoney;
import lotto.domain.purchase.LottoShop;
import lotto.domain.play.WinCriteria;
import lotto.domain.ticket.Lotto;
import lotto.domain.play.LottoInventory;
import lotto.domain.ticket.LottoNumber;
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
        LottoShop lottoShop = new LottoShop(RandomLottoGenerator.getInstance());
        LottoMoney money = requestMoney();
        List<Lotto> lottos = lottoShop.purchaseLottoWith(money);
        LottoInventory lottoInventory = new LottoInventory(lottos);
        showPurchaseInfo(lottos);
        List<Integer> userInputWinningNumbers = requestWinningNumbers();
        int bonusNumberValue = requestBonusNumber();
        WinCriteria winCriteria = new WinCriteria(new Lotto(userInputWinningNumbers), LottoNumber.of(bonusNumberValue));
        Result result = lottoInventory.calculateResult(winCriteria);
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
                .map(Lotto::peekAll)
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::getNumber)
                        .toList())
                .map(LottoDto::new)
                .toList();
        return new LottosDto(lottoDtos);
    }
}
