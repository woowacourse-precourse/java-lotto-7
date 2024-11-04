package lotto.user;

public class PrizeHistory {

    private Integer firstPrize;
    private Integer secondPrize;
    private Integer thirdPrize;
    private Integer fourthPrize;
    private Integer fifthPrize;
    private Integer lostPrize;

    void clean() {
        firstPrize = 0;
        secondPrize = 0;
        thirdPrize = 0;
        fourthPrize = 0;
        fifthPrize = 0;
        lostPrize = 0;
    }

    void addFirst() {
        firstPrize += 1;
    }

    void addSecond() {
        secondPrize += 1;
    }

    void addThird() {
        thirdPrize += 1;
    }

    void addFourth() {
        fourthPrize += 1;
    }

    void addFifth() {
        fifthPrize += 1;
    }

    void addLost() {
        lostPrize += 1;
    }

    Integer getFirst() {
        return firstPrize;
    }

    Integer getSecond() {
        return secondPrize;
    }

    Integer getThird() {
        return thirdPrize;
    }

    Integer getFourth() {
        return fourthPrize;
    }

    Integer getFifth() {
        return fifthPrize;
    }

    Integer getLost() {
        return lostPrize;
    }

    PrizeHistory getPrizeHistory() {
        return this;
    }
}
