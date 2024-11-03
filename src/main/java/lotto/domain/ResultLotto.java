package lotto.domain;

import java.util.Arrays;

public enum ResultLotto {
    당첨5위(5_000, 3, 0, 0),
    당첨4위(50_000, 4, 0, 0),
    당첨3위(1_500_000, 5, 0, 0),
    당첨2위(30_000_000, 5, 1, 0),
    당첨1위(2_000_000_000, 6, 0, 0);

    private final Integer lottoAmount;
    private final Integer winLottoNumberCount;
    private final Integer bonusNumber;
    private int count;

    ResultLotto(Integer lottoAmount, Integer winLottoNumberCount, Integer bonusNumber, int count) {
        this.lottoAmount = lottoAmount;
        this.winLottoNumberCount = winLottoNumberCount;
        this.bonusNumber = bonusNumber;
        this.count = count;
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
