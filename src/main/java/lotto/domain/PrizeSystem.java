package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PrizeSystem {

    private static final int MATCH_FIRST = 6;
    private static final int MATCH_SECOND_THIRD = 5;
    private static final int MATCH_FOURTH = 4;
    private static final int MATCH_FIFTH = 3;

    private final List<Integer> prizeNumbers;
    private final int bonusNumber;

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public PrizeSystem(List<Integer> prizeNumbers, int bonusNumber) {
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;

        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

}
