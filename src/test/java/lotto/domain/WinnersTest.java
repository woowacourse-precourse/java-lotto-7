package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    private WinnerResult winnerResult;

    @Test
    @DisplayName("일치하는 숫자의 개수에 따라 당첨된 로또의 개수를 증가할 수 있다.")
    void 일치하는_숫자의_개수에_따라_당첨된_로또의_개수를_증가할_수_있다() {
        //given
        //when
        Winners threeMatchedWinners = Winners.THREE_MATCHED;

        winnerResult = new WinnerResult();

        winnerResult.addMatchedAmount(threeMatchedWinners);

        //then
        assertEquals(1, winnerResult.getAmount(threeMatchedWinners));
    }

    @Test
    @DisplayName("당첨 금액을 문자열에서 정수로 변환할 수 있다.")
    void 당첨_금액을_문자열에서_정수로_변환할_수_있다() {
        //given
        Winners winners = Winners.THREE_MATCHED;

        //when
        int prizeMoney = winners.convertPrizeMoneyToInt();

        //then
        assertEquals(5000, prizeMoney);
    }

}