package lotto.model;

public enum Rule {
    FIFTH("3개 일치 (5,000원)"),
    FOURTH("4개 일치 (50,000원)"),
    THIRD("5개 일치 (1,500,000원)"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST("6개 일치 (2,000,000,000원)");

    private final String description;

    Rule(String description) {
        this.description = description;
    }

    public static Rule valueOf(int matchCount, boolean hasBonusMatch) {
        if (matchCount == 3) {
            return FIFTH;
        }
        else if (matchCount == 4) {
            return FOURTH;
        }
        else if (matchCount == 5 && !hasBonusMatch) {
            return THIRD;
        }
        else if (matchCount == 5) {
            return SECOND;
        }
        else if (matchCount == 6) {
            return FIRST;
        }
        return null;
    }

    public String getDescription() {
        return description;
    }
}
