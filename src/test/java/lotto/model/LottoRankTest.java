package lotto.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("당첨되지 않았다면 상금은 0원이다.")
    void should_ReturnZero_When_NotWinning() {
        // given
        LottoRank rank = LottoRank.NONE;

        // when
        BigInteger prize = rank.calculatePrizeByCount(1);

        // then
        assertEquals(prize, BigInteger.ZERO);
    }

    @Test
    @DisplayName("당첨 순위의 개수에 따라 상금을 반환한다.")
    void should_ReturnPrizeByRankCount() {
        // given
        LottoRank rank = LottoRank.FIRST;

        // when
        BigInteger prize = rank.calculatePrizeByCount(2);

        // then
        assertEquals(prize, BigInteger.valueOf(4000000000L));
    }

    @Test
    @DisplayName("당첨 순위에 따른 메시지를 반환한다.")
    void should_ReturnResultMessageByLottoRank() {
        // given
        LottoRank first = LottoRank.FIRST;
        LottoRank second = LottoRank.SECOND;

        // when
        String firstRankMessage = first.getResultMessage();
        String secondRankMessage = second.getResultMessage();

        // then
        assertAll(
                () -> assertEquals(firstRankMessage, "6개 일치 (2,000,000,000원)"),
                () -> assertEquals(secondRankMessage, "5개 일치, 보너스 볼 일치 (30,000,000원)")
        );
    }
}
