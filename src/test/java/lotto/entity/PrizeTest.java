package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.configuration.Prize;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void 성공__등수_찾기_테스트_1등() {
        // given
        int matchCount = 6;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.FIRST, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_2등() {
        // given
        int matchCount = 5;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.SECOND, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_3등_메인번호() {
        // given
        int matchCount = 5;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.THIRD, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_3등_보너스포함() {
        // given
        int matchCount = 4;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.THIRD, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_4등_메인번호() {
        // given
        int matchCount = 4;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.FOURTH, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_4등_보너스포함() {
        // given
        int matchCount = 3;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.FOURTH, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_5등_메인번호() {
        // given
        int matchCount = 3;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.FIFTH, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_5등_보너스포함() {
        // given
        int matchCount = 2;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.FIFTH, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_미당첨_2개() {
        // given
        int matchCount = 2;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.NONE, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_미당첨_1개_보너스포함() {
        // given
        int matchCount = 1;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.NONE, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_미당첨_0개() {
        // given
        int matchCount = 0;

        // when
        Prize prize = Prize.findPrize(matchCount, false);

        // then
        assertEquals(Prize.NONE, prize);
    }

    @Test
    void 성공__등수_찾기_테스트_미당첨_0개_보너스포함() {
        // given
        int matchCount = 0;

        // when
        Prize prize = Prize.findPrize(matchCount, true);

        // then
        assertEquals(Prize.NONE, prize);
    }

}