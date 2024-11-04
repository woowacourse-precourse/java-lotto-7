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
        firstPrize += 1;
    }

    void addThird() {
        firstPrize += 1;
    }

    void addFourth() {
        firstPrize += 1;
    }

    void addFifth() {
        firstPrize += 1;
    }

    void addLost() {
        lostPrize += 1;
    }

    PrizeHistory getPrizeHistory() {
        return this;
    }
}
