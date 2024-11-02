package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRevenueCalculator;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
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

        Lottos purchasedLottos = Lottos.purchase(purchaseCount);
        outputView.showPurchasedLottos(purchaseCount, purchasedLottos);

        Lotto lottoWinningNumbers = getLottoWinningNumbers();
        int lottoBonusNumber = getLottoBonusNumber();

        WinningLotto winningLotto = createWinningLottoNumbers(lottoWinningNumbers, lottoBonusNumber);

        Map<LottoRank, Integer> lottoResult = purchasedLottos.lottoResultFrom(winningLotto);
        outputView.showLottoResult(lottoResult);

        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, money);
        double revenue = lottoRevenueCalculator.calculateRevenue();
        outputView.showLottoRevenue(revenue);
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


    private WinningLotto createWinningLottoNumbers(Lotto lottoWinningNumbers, int lottoBonusNumber) {
        while (true) {
            try {
                return new WinningLotto(lottoWinningNumbers, lottoBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoBonusNumber = getLottoBonusNumber();
            }
        }
    }
}
