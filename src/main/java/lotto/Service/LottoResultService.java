package lotto.Service;

import lotto.Domain.LottoResult;
import lotto.Lotto;
import java.util.List;

public class LottoResultService {
    private LottoResult lottoResult;

    public LottoResultService() {
        this.lottoResult = new LottoResult();
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
            lottoResult.addFirstPrize();
        } else if (numMatches == 5 && hasBonusNumber) {
            lottoResult.addSecondPrize();
        } else if (numMatches == 5) {
            lottoResult.addThirdPrize();
        } else if (numMatches == 4) {
            lottoResult.addFourthPrize();
        } else if (numMatches == 3) {
            lottoResult.addFifthPrize();
        }
    }

    public static long getMatchingCount(List<Integer> winningLotto, List<Integer> generatedLotto) {
        return winningLotto.stream()
            .filter(generatedLotto::contains)
            .count();
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
