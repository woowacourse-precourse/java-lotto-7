package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchCalculatorTest {

    MatchCalculator matchCalculator = new MatchCalculator();
    @Test
    void calculateMatchCount() {
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto ticket = new Lotto(List.of(2,3,4,5,6,7));
        int bonusNumber = 3;

        MatchCount matchCount = matchCalculator.calculateMatchCount(winningLotto, ticket, bonusNumber);
        assertEquals(MatchCount.FIVE_MATCH_WITH_BONUS_NUMBER, matchCount);
    }

    @Test
    void calculateYield() {
        int purchasePrice = 8000;
        int winningMoney = 5000;
        double result = matchCalculator.calculateYield(purchasePrice, winningMoney);
        assertEquals(62.5, result);
    }
}