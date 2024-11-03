package lotto;

public enum Rank {
    THREE(false, 3),       // 3개 맞추고 보너스가 없는 경우
    TWO_WITH_BONUS(true, 2), // 2개 맞추고 보너스가 있는 경우
    FOUR(false, 4),        // 4개 맞추고 보너스가 없는 경우
    THREE_WITH_BONUS(true, 3), // 3개 맞추고 보너스가 있는 경우
    FOUR_WITH_BONUS(true, 4),  // 4개 맞추고 보너스가 있는 경우
    FIVE(false, 5),        // 5개 맞추고 보너스가 없는 경우
    FIVE_WITH_BONUS(true, 5),  // 5개 맞추고 보너스가 있는 경우
    SIX(false, 6),         // 6개 맞추고 보너스가 없는 경우
    SIX_WITH_BONUS(true, 6);

    private final boolean bonus;
    private final int number;

    // 생성자
    Rank(boolean bonus, int number) {
        this.bonus = bonus;
        this.number = number;
    }

    // number와 bonus 조건에 맞는 Rank를 반환하는 정적 메서드
    public static Rank getRank(int number, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.number == number && rank.bonus == bonus) {
                return rank;
            }
        }
        return null; // 조건에 맞는 Rank가 없을 때
    }
}