package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoType {
    OUT_OF_THE_RANKING("", 0, 0, 0),
    FIFTH_PLACE("3개 일치 (5,000원) -", 5, 5_000, 3),
    FOURTH_PLACE("4개 일치 (50,000원) -", 4, 50_000, 4),
    THIRD_PLACE("5개 일치 (1,500,000원) -", 3, 1_500_000, 5),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) -", 2, 30_000_000, 5),
    FIRST_PLACE("6개 일치 (2,000,000,000원) -", 1, 2_000_000_000, 6);

    LottoType(String information, int ranking, int winnings, int matchCount) {
        this.information = information;
        this.ranking = ranking;
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

    private String information;
    private int winnings;
    private int matchCount;
    private int ranking;

    public int getWinnings() {
        return winnings;
    }

    public String getInformation() {
        return information;
    }

    public boolean isOutOfTheRanking() {
        if(this == OUT_OF_THE_RANKING) {
            return true;
        }

        return false;
    }

    public static LottoType countToLottoType(int matchCount) {
        Optional<LottoType> optionalLottoType = Arrays.stream(values())
                .filter(l -> l.matchCount == matchCount)
                .findAny();

        if (optionalLottoType.isPresent()) {
            return optionalLottoType.get();
        }

        return OUT_OF_THE_RANKING;
    }
}
