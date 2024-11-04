package lotto;

public enum Rank {
    PLACE_1ST(6, false, 200000000, 1),
    PLACE_2ST(5, true, 30000000, 2),
    PLACE_3ST(5, false, 1500000, 3),
    PLACE_4ST(4, false, 50000, 4),
    PLACE_5ST(3, false, 5000, 5),
    PLACE_NO(0, false, 0, 6);

    private final int match;
    private final boolean bonus;
    private final int reward;
    private final int place;

    Rank(int match, boolean bonus, int reward, int place) {
        this.match = match;
        this.bonus = bonus;
        this.reward = reward;
        this.place = place;
    }

    public static Rank of(int match, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.match == match && rank.bonus == bonus) {
                return rank;
            }
        }

        return PLACE_NO;
    }

    public int getReward() {
        return reward;
    }

    public int getPlace() {
        return place;
    }
}
