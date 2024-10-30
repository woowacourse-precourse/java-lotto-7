package lotto.enums;

public enum BonusStatus {
    BONUS_EXCLUDED (false),
    BONUS_INCLUDED (true);

    private final boolean isBonus;

    BonusStatus(boolean isBonus) {
        this.isBonus = isBonus;
    }

    public boolean getIsBonus() {
        return isBonus;
    }
}
