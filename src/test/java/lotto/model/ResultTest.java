package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @Test
    @DisplayName("해당 등수가 없는 경우")
    void 해당_등수가_없는_경우() {
        // given
        Result result = new Result();

        // when
        int cnt = result.getCount(Rank.SECOND);

        // then
        assertEquals(0, cnt);
    }

    @Test
    @DisplayName("해당 등수가 아닌 다른 등수가 있는 경우")
    void 해당_등수가_아닌_다른_등수가_있는_경우() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.FIRST);
        int cnt = result.getCount(Rank.SECOND);

        // then
        assertEquals(0, cnt);
    }

    @Test
    @DisplayName("해당 등수가 2개 있는 경우")
    void 해당_등수가_2개_있는_경우() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.SECOND);
        result.add(Rank.SECOND);
        int cnt = result.getCount(Rank.SECOND);

        // then
        assertEquals(2, cnt);
    }

    @Test
    @DisplayName("2등이 2번있는 경우 3등 상금")
    void 해당_등수가_2개_있는_경우_3등_상금() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.SECOND);
        result.add(Rank.SECOND);
        long price = result.getPrice(Rank.THIRD);

        // then
        assertEquals(0L, price);
    }

    @Test
    @DisplayName("2등이 2번있는 경우 2등 상금")
    void 해당_등수가_2개_있는_경우_2등_상금() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.SECOND);
        result.add(Rank.SECOND);
        long price = result.getPrice(Rank.SECOND);

        // then
        assertEquals(Rank.SECOND.getPrice()*2L, price);
    }

    @Test
    @DisplayName("수익률 자연수로 나누어 떨어질 경우")
    void 수익률_자연수로_나누어_떨어질_경우() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.FIFTH);
        String rate = result.getRate();

        // then
        assertEquals("500%", rate);
    }

    @Test
    @DisplayName("수익률 소수점 올림 없이 나누어질 경우")
    void 수익률_소수점_올림_없이_나누어질_경우() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.FIFTH);
        result.add(Rank.FIFTH);
        result.add(Rank.NO_LUCK);
        String rate = result.getRate();

        // then
        assertEquals("333.3%", rate);
    }

    @Test
    @DisplayName("수익률 소수점 올림하고 나누어질 경우")
    void 수익률_소수점_올림하고_나누어질_경우() {
        // given
        Result result = new Result();

        // when
        result.add(Rank.FIFTH);
        result.add(Rank.NO_LUCK);
        result.add(Rank.NO_LUCK);
        String rate = result.getRate();

        // then
        assertEquals("166.7%", rate);
    }
}