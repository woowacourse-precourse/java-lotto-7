package lotto.constant;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinInfo {
    FIFTH(5, 3, false, 5000),
    FOURTH(4, 4, false, 50000),
    THIRD(3, 5, false, 1500000),
    SECOND(2, 5, true, 30000000),
    FIRST(1, 6, false, 2000000000);

    private final int rank;
    private final int numberMatchCount;
    private final boolean hasBonusNumber;
    private final int prize;

    LottoWinInfo(final int rank, final int numberMatchCount, final boolean hasBonusNumber, final int prize) {
        this.rank = rank;
        this.numberMatchCount = numberMatchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Optional<LottoWinInfo> getLottoWinInfo(final int numberMatchCount, final boolean hasBonusNumber) {
        return Arrays.stream(LottoWinInfo.values())
                .filter(lottoWinInfo -> lottoWinInfo.numberMatchCount == numberMatchCount)
                .filter(lottoWinInfo -> lottoWinInfo.hasBonusNumber == hasBonusNumber)
                .findAny();
    }

    public int getRank() {
        return rank;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
