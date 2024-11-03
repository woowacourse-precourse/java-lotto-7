package lotto.Service;

import lotto.Domain.GameInfo;
import lotto.Domain.LottoResult;
import lotto.Lotto;
import java.util.List;

public class LottoResultService {
    private final LottoResult lottoResult;

    public LottoResultService() {
        this.lottoResult = new LottoResult();
    }

    public void checkAllResult(GameInfo gameInfo) {
        Lotto winningLotto = gameInfo.getWinningLotto();
        int bonusNumber = gameInfo.getBonusNumber();

        for (Lotto purchasedLotto : gameInfo.getPurchasedLottos()) {
            checkLottoResult(winningLotto, purchasedLotto, bonusNumber);
        }
    }

    public void checkLottoResult(Lotto winningLotto, Lotto generatedLotto, int bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> generatedNumbers = generatedLotto.getNumbers();

        int numMatches = (int) LottoResultService.getMatchingCount(winningNumbers, generatedNumbers);
        boolean hasBonusNumber = generatedNumbers.contains(bonusNumber);

        evaluateResult(numMatches, hasBonusNumber);
    }

    public void evaluateResult(int numMatches, boolean hasBonusNumber) {
        if (numMatches == 6) {
            lottoResult.addFirstPrizeCnt();
        } else if (numMatches == 5 && hasBonusNumber) {
            lottoResult.addSecondPrizeCnt();
        } else if (numMatches == 5) {
            lottoResult.addThirdPrizeCnt();
        } else if (numMatches == 4) {
            lottoResult.addFourthPrizeCnt();
        } else if (numMatches == 3) {
            lottoResult.addFifthPrizeCnt();
        }
    }

    public static long getMatchingCount(List<Integer> winningLotto, List<Integer> generatedLotto) {
        return winningLotto.stream()
            .filter(generatedLotto::contains)
            .count();
    }

    public double calculateProfitRate(int purchaseAmount) {
        if (purchaseAmount <= 0)
            throw new IllegalArgumentException();
        long totalPrize = lottoResult.calculateTotalPrize();
        return (double) totalPrize / purchaseAmount;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

}
