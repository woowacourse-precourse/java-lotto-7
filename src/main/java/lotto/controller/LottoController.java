package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.RandomLottoGenerator;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = getMoney();
        int purchaseCount = money / 1000;

        Lottos purchasedLottos = purchaseLottos(purchaseCount);

        outputView.showPurchasedLottos(purchaseCount, purchasedLottos);

        Lotto lottoWinningNumbers = getLottoWinningNumbers();
        int lottoBonusNumber = getLottoBonusNumber();

        WinningLottoNumbers winningLottoNumbers = createWinningLottoNumbers(lottoWinningNumbers, lottoBonusNumber);

    }

    private Lottos purchaseLottos(int purchaseCount) {
        List<Lotto> purchasedLottos = getPurchasedLottos(purchaseCount);
        return Lottos.of(purchasedLottos);
    }

    private List<Lotto> getPurchasedLottos(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> purchaseLotto())
                .toList();
    }

    private Lotto purchaseLotto() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoGenerator.generateLotto();
    }

    private int getMoney() {
        while (true) {
            try {
                outputView.showMoneyInputComments();
                return inputView.getMoneyFromUser();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getLottoWinningNumbers() {
        while (true) {
            try {
                outputView.showLottoWinningNumbersInputComments();
                return inputView.getLottoWinningNumbersFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getLottoBonusNumber() {
        while (true) {
            try {
                outputView.showLottoBonusNumberInputComments();
                return inputView.getLottoBonusNumberFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private WinningLottoNumbers createWinningLottoNumbers(Lotto lottoWinningNumbers, int lottoBonusNumber) {
        while (true) {
            try {
                return new WinningLottoNumbers(lottoWinningNumbers, lottoBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoBonusNumber = getLottoBonusNumber();
            }
        }
    }
}
