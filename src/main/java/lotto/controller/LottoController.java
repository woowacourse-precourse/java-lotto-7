package lotto.controller;

import lotto.model.LottoGame;
import lotto.view.LottoView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoGame lottoGame;
    private final LottoView view;

    public LottoController() {
        this.lottoGame = new LottoGame();
        this.view = new LottoView();
    }

    public void run() {
        try {
            // 구입 금액 입력 및 처리
            int purchaseAmount = view.inputPurchaseAmount();
            int count = lottoGame.calculateLottoCount(purchaseAmount);

            // 로또 구입 및 출력
            lottoGame.purchaseLottos(count);
            view.printPurchasedLottos(lottoGame.getPurchasedLottos());

            // 당첨 번호 입력 및 처리
            List<Integer> winningNumbers = view.inputWinningNumbers();
            int bonusNumber = view.inputBonusNumber();
            lottoGame.setWinningNumbers(winningNumbers, bonusNumber);

            // 당첨 결과 계산 및 출력
            Map<String, Integer> results = lottoGame.calculateResults();
            view.printResults(results);

            // 수익률 계산
            double profitRate = lottoGame.calculateProfitRate(purchaseAmount, results);

            // 출력
            //view.printPurchasedLottos(lottoGame.getPurchasedLottos());
            System.out.printf("수익률은 %.1f%%입니다.%n", profitRate);

        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        }
    }
}
