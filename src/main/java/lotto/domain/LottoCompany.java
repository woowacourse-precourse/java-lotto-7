package lotto.domain;

import java.util.List;

public class LottoCompany {
    private final WinningLotto winningLotto;
    private final Money money;

    public LottoCompany(WinningLotto winningLotto, Money money) {
        this.winningLotto = winningLotto;
        this.money = money;
    }

    public PrizeResult getWinningResults(List<Lotto> lottos) {
        PrizeResult prizeResult = new PrizeResult();
        for (final Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            int correctNumberCount = checkLottoNumbers(lottoNumbers);
            boolean isCorrectBonusNumber = isBonusNumberMatched(lottoNumbers);
            checkPrize(prizeResult, correctNumberCount, isCorrectBonusNumber);
        }
        return prizeResult;
    }

    private void checkPrize(PrizeResult prizeResult, int correctNumberCount, boolean isCorrectBonusNumber) {
        if (correctNumberCount == 6) { // 6개 일치 = 1등
            prizeResult.winPrize(Prize.FIRST);
            money.addMoney(Prize.FIRST.getPrizeMoneyValue());
            return;
        }
        if (correctNumberCount == 5 && isCorrectBonusNumber) { // 5개 일치 + 보너스 번호 = 2등
            prizeResult.winPrize(Prize.SECOND);
            money.addMoney(Prize.SECOND.getPrizeMoneyValue());
            return;
        }
        if (correctNumberCount == 5) {
            prizeResult.winPrize(Prize.THIRD);
            money.addMoney(Prize.THIRD.getPrizeMoneyValue());
            return;
        }
        if (correctNumberCount == 4) {
            prizeResult.winPrize(Prize.FOURTH);
            money.addMoney(Prize.FOURTH.getPrizeMoneyValue());
            return;
        }
        if (correctNumberCount == 3) {
            prizeResult.winPrize(Prize.FIFTH);
            money.addMoney(Prize.FIFTH.getPrizeMoneyValue());
        }
    }

    private int checkLottoNumbers(List<Integer> lottoNumbers) {
        int correctNumberCount = 0;
        for (final int currentNumber : lottoNumbers) {
            if (isContainWinningNumber(currentNumber)) {
                correctNumberCount += 1;
            }
        }
        return correctNumberCount;
    }

    private boolean isContainWinningNumber(int currentNumber) {
        // 당첨 로또 번호에 매개변수의 번호가 포함되어 있는지 확인
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getLottoNumbers();
        return winningLottoNumbers.stream().anyMatch(winningNumber -> winningNumber == currentNumber);
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers) {
        // 현재 로또 번호에 보너스 번호가 포함되어 있는지 확인
        int bonusNumber = winningLotto.getBonusNumber();
        return lottoNumbers.stream().anyMatch(number -> number == bonusNumber);
    }
}
