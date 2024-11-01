package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1_000;

    public void run() {
        int money = getValidMoney();
        int numberOfLottos = calculateNumberOfLottos(money);
        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(numberOfLottos);
        OutputView.printPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = getValidWinningLotto();
        LottoResult result = new LottoResult(winningLotto, purchasedLottos);
        OutputView.printLottoResult(result.getResultCountMap());
        OutputView.printRateOfReturn(calculateRateOfReturn(result, money));
    }

    private int getValidMoney() {
        while (true) {
            try {
                int money = InputView.getMoney();
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                //todo 에러 메세지 출력 (OutputView class 이용)
            }
        }
    }

    private WinningLotto getValidWinningLotto() {
        while (true) {
            try {
                return new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());
            } catch (IllegalArgumentException e) {
                //todo 에러 메세지 출력 (OutputView class 이용)
            }
        }
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int calculateNumberOfLottos(int money) {
        return money / LOTTO_PRICE;
    }

    private double calculateRateOfReturn(LottoResult result, int money) {
        Map<Rank, Integer> resultMap = result.getResultCountMap();
        double totalPrize = 0;

        for (Rank rank : resultMap.keySet()) {
            int count = resultMap.get(rank);
            totalPrize += rank.getPrize() * count;
        }

        double rateOfReturn = (totalPrize / money) * 100;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0; // 소수점 둘째 자리에서 반올림

        return rateOfReturn;
    }
}
