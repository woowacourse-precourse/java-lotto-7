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
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto getValidWinningLotto() {
        List<Integer> validWinningNumbers = getValidWinningNumbers();
        int validBonusNumbers = getValidBonusNumber(validWinningNumbers);
        return new WinningLotto(validWinningNumbers, validBonusNumbers);
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                Lotto lotto = new Lotto(InputView.getWinningNumbers());
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(final List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(final int bonusNumber, final List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45사이의 당첨번호와 중복되지 않는 번호여야 합니다.");
        }
    }

    private void validateMoney(final int money) {
        if (money <= 0) throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0이나 음수가 될 수 없습니다.");
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int calculateNumberOfLottos(final int money) {
        return money / LOTTO_PRICE;
    }

    private double calculateRateOfReturn(final LottoResult result, final int money) {
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
