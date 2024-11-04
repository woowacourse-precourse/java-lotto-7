package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoOption;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.converter.StringToIntegerListConverter;
import lotto.util.validator.StringValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.OutputviewFormatter;

public class LottoController {
    public static void run() {
        final LottoService lottoService = new LottoService();
        final Money money = requestPurchaseMoneyAmount();

        final Lottos lottos = lottoService.generateLottos(money.getPurchasableLottoCount());
        OutputView.printPurchasedLottos(money.getPurchasableLottoCount(),
                OutputviewFormatter.formatLottoNumbers(lottos));

        final Lotto lotto = requestWinningLottoNumbers();
        final WinningLotto winningLotto = requestBonusNumber(lotto);


    }

    private static Money requestPurchaseMoneyAmount() {
        try {
            OutputView.printRequestPurchaseMoneyAmount();
            int purchaseMoneyAmount = InputView.readNumber();
            return new Money(purchaseMoneyAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestPurchaseMoneyAmount();
        }
    }

    private static Lotto requestWinningLottoNumbers() {
        try {
            OutputView.printRequestWinningLottoNumbers();
            String winningNumbers = InputView.readNumbers();
            StringValidator.valiateNumbersFormat(winningNumbers);
            return new Lotto(StringToIntegerListConverter.convert(winningNumbers));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestWinningLottoNumbers();
        }
    }

    private static WinningLotto requestBonusNumber(Lotto lotto) {
        try {
            OutputView.printRequestBonusNumber();
            int number = InputView.readNumber();
            return new WinningLotto(lotto, new BonusNumber(number));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return requestBonusNumber(lotto);
        }
    }
}
