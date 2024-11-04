package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.utils.ConstantMessage.GuideMessage;
import lotto.utils.ConstantValue;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int price;
        outputView.printGuide(GuideMessage.INPUT_PRICE);
        price = inputView.inputPrice();

        List<Lotto> purchasedLotto = lottoService.getSeveralLotto(
                price / ConstantValue.LOTTO_PRICE
        );

        outputView.printBlank();
        outputView.printPurchasedAmount(price / ConstantValue.LOTTO_PRICE);
        purchasedLotto.forEach(lotto -> outputView.printLottoNumber(lotto));
        outputView.printBlank();

        List<Integer> winningNumber;
        outputView.printGuide(GuideMessage.INPUT_LOTTO);
        winningNumber = inputView.inputWinningNumbers();
        outputView.printBlank();

        int bonusNumber;
        outputView.printGuide(GuideMessage.INPUT_BONUS);
        bonusNumber = inputView.inputLottoNumber(winningNumber);
        outputView.printBlank();

        Map<String, Integer> countPrize = lottoService.countPrize(purchasedLotto, winningNumber, bonusNumber);
        float returnRate = lottoService.getReturnRate(countPrize, price);
        outputView.printGuide(GuideMessage.RESULT_STAT);
        outputView.printCountResult(countPrize);
        outputView.printReturnResult(returnRate);
    }
}
