package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import lotto.common.InputParser;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoRound;
import lotto.domain.Money;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final RandomLottoGenerator generator = new RandomLottoGenerator();

    public void play() {
        Money money = inputMoney();
        List<Lotto> lottos = generateLottos(money.getLottoCount());
        OutputView.printLottos(lottos);

        Lotto lotto = inputWinningLotto();
        WinningLotto winningLotto = createWinningLotto(lotto);
        LottoResult lottoResult = playLottoRound(lottos, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }

    private Money inputMoney() {
        return retryOnException(() -> {
            String purchaseMoneyText = InputView.readLottoPurchaseMoney();
            Integer purchaseAmount = InputParser.parseInteger(purchaseMoneyText);
            return new Money(purchaseAmount);
        }, Boolean.TRUE);
    }

    private Lotto inputWinningLotto() {
        return retryOnException(() -> {
            String winningNumberText = InputView.readLottoWinningNumber();
            List<Integer> lottoNumbers = InputParser.parseIntegers(winningNumberText);
            return new Lotto(lottoNumbers);
        });
    }

    private WinningLotto createWinningLotto(final Lotto lotto) {
        return retryOnException(() -> {
            String lottoBonusNumberText = InputView.readLottoBonusNumber();
            int bonusNumber = InputParser.parseInteger(lottoBonusNumberText);
            LottoNumber lottoNumber = new LottoNumber(bonusNumber);
            return new WinningLotto(lotto, lottoNumber);
        });
    }

    private List<Lotto> generateLottos(final Integer lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generator.generate())
                .toList();
    }

    private LottoResult playLottoRound(final List<Lotto> lottos, final WinningLotto winningLotto) {
        LottoRound lottoRound = new LottoRound(lottos, winningLotto);
        return lottoRound.play();
    }

    private <T> T retryOnException(final Supplier<T> action, final Boolean isPrintEmptyMessage) {
        while (true) {
            try {
                return action.get();
            } catch (LottoException e) {
                OutputView.print(e.getMessage());
                printEmptyMessageIfTrue(isPrintEmptyMessage);
            }
        }
    }

    private <T> T retryOnException(final Supplier<T> action) {
        return retryOnException(action, Boolean.FALSE);
    }

    private void printEmptyMessageIfTrue(final Boolean printEmptyMessage) {
        if (Boolean.TRUE.equals(printEmptyMessage)) {
            OutputView.printEmptyLine();
        }
    }
}
