package lotto;

public enum MatchType {
    THREE_MATCHES(5),
    FOUR_MATCHES(50),
    FIVE_MATCHES(1500),
    FIVE_BONUS(2000),
    SIX_MATCHES(2000000);


    private final int weight;

    MatchType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
