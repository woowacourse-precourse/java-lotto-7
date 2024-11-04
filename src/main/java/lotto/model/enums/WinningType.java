package lotto.model.enums;

public enum WinningType {
    NOTHING(0L), THREE(5000L), FOUR(50000L), FIVE(1500000L), FIVE_BOUNS(30000000L), SIX(2000000000L);

    private Long prize;

    WinningType(Long prize) {
        this.prize = prize;
    }
}
