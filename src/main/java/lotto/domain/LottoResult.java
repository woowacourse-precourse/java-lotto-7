package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int getRank(List<Integer> lottoNumbers) {
        int matchCount = getMatchCount(lottoNumbers);

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && hasBonusNumber(lottoNumbers)) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    public int getPrize(List<Integer> lottoNumbers) {
        return LottoPrize.getPrize(getRank(lottoNumbers));
    }
}