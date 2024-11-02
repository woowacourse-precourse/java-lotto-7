package lotto.domain;

import java.util.Arrays;

public enum ResultLotto {
    당첨1위(1, 2_000_000_000, 6, 0, 0),
    당첨2위(2, 30_000_000, 5, 1, 0),
    당첨3위(3, 1_500_000, 5, 0, 0),
    당첨4위(4, 50_000, 4, 0, 0),
    당첨5위(5, 5_000, 3, 0, 0);

    private final Integer rank;
    private final Integer lottoAmount;
    private final Integer winLottoNumberCount;
    private final Integer bonusNumber;
    private int count;

    ResultLotto(Integer rank, Integer lottoAmount, Integer winLottoNumberCount, Integer bonusNumber, int count) {
        this.rank = rank;
        this.lottoAmount = lottoAmount;
        this.winLottoNumberCount = winLottoNumberCount;
        this.bonusNumber = bonusNumber;
        this.count = count;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getLottoAmount() {
        return lottoAmount;
    }

    public Integer getWinLottoNumberCount() {
        return winLottoNumberCount;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public int getCount() {
        return count;
    }

    public static void winLotto(Integer winLottoNumberCount, Integer bonusNumber) {
        Arrays.stream(ResultLotto.values())
                .filter(result -> result.winLottoNumberCount.equals(winLottoNumberCount) && result.bonusNumber.equals(bonusNumber))
                .findFirst()
                .ifPresent(result -> result.count++);
    }
}
