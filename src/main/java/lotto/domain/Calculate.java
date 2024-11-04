package lotto.domain;

import java.util.List;

public class Calculate {
    private final DrawNumbers winningDrawNumbers;
    private final DrawNumbers randomDrawNumbers;

    public Calculate(DrawNumbers winningDrawNumbers, DrawNumbers randomDrawNumbers) {
        this.winningDrawNumbers = winningDrawNumbers;
        this.randomDrawNumbers = randomDrawNumbers;
    }

    public int calculatePrizeMoney() {
        List<Integer> winningLottoNumbers = winningDrawNumbers.getLottoNumbers();
        List<Integer> randomLottoNumbers = randomDrawNumbers.getLottoNumbers();

        int lottoNumberMatchCount = checkLottoMatchCount(winningLottoNumbers, randomLottoNumbers);
        boolean isBonusNumberMatch = randomDrawNumbers.getBonusNumber() == winningDrawNumbers.getBonusNumber();

        return matchPrizeMoney(lottoNumberMatchCount, isBonusNumberMatch);
    }

    private int checkLottoMatchCount(List<Integer> winningNumbers, List<Integer> randomNumbers) {
        int lottoNumberMatchCount = 0;
        for (Integer number : winningNumbers) {
            if (randomNumbers.contains(number)) {
                lottoNumberMatchCount++;
            }
        }
        return lottoNumberMatchCount;
    }

    private int matchPrizeMoney(int matchCount, boolean isBonusNumberMatch) {
        if (matchCount == 3) {
            return 5000;
        }
        if (matchCount == 4) {
            return 50000;
        }
        if (matchCount == 5 && !isBonusNumberMatch) {
            return 1500000;
        }
        if (matchCount == 5) {
            return 30000000;
        }
        if (matchCount == 6) {
            return 2000000000;
        }
        return 0;
    }
}
