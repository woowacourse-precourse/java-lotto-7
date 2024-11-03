package lotto;

public class WinningStatics {
    public static final int FIRST_PLACE_PRIZE = 2_000_000_000;
    public static final int SECOND_PLACE_PRIZE = 30_000_000;
    public static final int THIRD_PLACE_PRIZE = 1_500_000;
    public static final int FOURTH_PLACE_PRIZE = 50_000;
    public static final int FIFTH_PLACE_PRIZE = 5_000;
    public static final int PERCENTAGE_MULTIPLIER = 100;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private double winnings;

    void winFirst() {
        this.first++;
        this.winnings += FIRST_PLACE_PRIZE;
    }

    void winSecond() {
        this.second++;
        this.winnings += SECOND_PLACE_PRIZE;
    }

    void winThird() {
        this.third++;
        this.winnings += THIRD_PLACE_PRIZE;
    }

    void winFourth() {
        this.fourth++;
        this.winnings += FOURTH_PLACE_PRIZE;
    }

    void winFifth() {
        this.fifth++;
        this.winnings += FIFTH_PLACE_PRIZE;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void recordMatch(MatchResult result) {
        result.win(this);
    }

    public double getRateOfReturn(int count) {
        int principal = count * Lotto.LOTTO_PRICE;
        return (winnings / principal) * PERCENTAGE_MULTIPLIER;
    }
}
