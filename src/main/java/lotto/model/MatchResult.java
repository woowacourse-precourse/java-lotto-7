package lotto.model;

import lotto.dto.WinningResultDTO;

public enum MatchResult {
    THREE(3),
    FOUR(4),
    FIVE(5),
    FIVE_WITH_BONUS(5, true),
    SIX(6);

    private final int matchCount;
    private final boolean hasBonus;

    MatchResult(int matchCount) {
        this(matchCount, false);
    }

    MatchResult(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public static MatchResult getMatchResult(int matchCount, boolean hasBonus) {
        if (matchCount == 3) return THREE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 5 && hasBonus) return FIVE_WITH_BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 6) return SIX;
        return null;  // 아무 매칭 결과도 없는 경우
    }

    public void applyResult(WinningResultDTO resultDTO) {
        if (this == THREE) {
            resultDTO.addPointToCorrect3();
        } else if (this == FOUR) {
            resultDTO.addPointToCorrect4();
        } else if (this == FIVE) {
            resultDTO.addPointToCorrect5();
        } else if (this == FIVE_WITH_BONUS) {
            resultDTO.addPointToCorrect5withBonus();
        } else if (this == SIX) {
            resultDTO.addPointToCorrect6();
        }
    }
}
