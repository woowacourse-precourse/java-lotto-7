package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public enum LottoRank {
    FIRST(6, List.of(Boolean.FALSE), 2_000_000_000L),
    SECOND(5, List.of(Boolean.TRUE), 30_000_000L),
    THIRD(5, List.of(Boolean.FALSE), 1_500_000L),
    FOURTH(4, List.of(Boolean.TRUE, Boolean.FALSE), 50_000L),
    FIFTH(3, List.of(Boolean.TRUE, Boolean.FALSE), 5_000L),
    NONE(null, null, 0L);

    private final Integer containsCount;
    private final List<Boolean> containBonusNumber;
    private final Long prizeMoney;
    private static final DecimalFormat df = new DecimalFormat("###,###");

    LottoRank(Integer containsCount, List<Boolean> containBonusNumber, Long prizeMoney) {
        this.containsCount = containsCount;
        this.containBonusNumber = containBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(Lotto lotto, Lotto winner, Integer bonusNumber) {
        return LottoRank.matchCondition(lotto.containsCount(winner), lotto.contains(bonusNumber));
    }

    private static LottoRank matchCondition(Integer containsCount, Boolean containBonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            if (Objects.equals(rank.containsCount, containsCount) &&
                    rank.containBonusNumber.contains(containBonusNumber)) {
                return rank;
            }
        }
        return NONE;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    private String prizeMoneyToString() {
        return df.format(prizeMoney);
    }

    private String getConditionToString() {
        String condition = String.format("%d개 일치", containsCount);
        if (this.equals(SECOND)) {
            condition += ", 보너스 볼 일치";
        }
        return condition;
    }

    public String getConditionInstruction() {
        if (this.equals(NONE)) {
            return null;
        }
        return String.format("%s (%s원)", getConditionToString(), prizeMoneyToString());
    }
}
