package lotto.domain.factory;

import java.util.Arrays;
import java.util.List;
import lotto.domain.model.RankInfo;

import static lotto.constants.LottoConstants.DESCRIPTION;
import static lotto.constants.LottoConstants.SECOND_RANK_DESCRIPTION;

public class RankInfoFactory {
    private static final RankInfo FIRST_RANK = new RankInfo(1, 6, 2000000000, DESCRIPTION, false);
    private static final RankInfo SECOND_RANK = new RankInfo(2, 5, 30000000, SECOND_RANK_DESCRIPTION, true);
    private static final RankInfo THIRD_RANK = new RankInfo(3, 5, 1500000, DESCRIPTION, false);
    private static final RankInfo FOURTH_RANK = new RankInfo(4, 4, 50000, DESCRIPTION, false);
    private static final RankInfo FIFTH_RANK = new RankInfo(5, 3, 5000, DESCRIPTION, false);

    public static RankInfo getFirstRank() {
        return FIRST_RANK;
    }

    public static RankInfo getSecondRank() {
        return SECOND_RANK;
    }

    public static RankInfo getThirdRank() {
        return THIRD_RANK;
    }

    public static RankInfo getFourthRank() {
        return FOURTH_RANK;
    }

    public static RankInfo getFifthRank() {
        return FIFTH_RANK;
    }

    public static List<RankInfo> getAllRanks() {
        return Arrays.asList(FIFTH_RANK, FOURTH_RANK, THIRD_RANK, SECOND_RANK, FIRST_RANK);
    }
}
