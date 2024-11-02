package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void 생성확인_1등_테스트() {
        Prize prize = Prize.getPrize(6, false);

        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    void 생성확인_2등_테스트() {
        Prize prize = Prize.getPrize(5, true);

        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    void 생성확인_3등_테스트() {
        Prize prize = Prize.getPrize(5, false);

        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    void 생성확인_4등_테스트1() {
        Prize prize = Prize.getPrize(4, false);

        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    void 생성확인_4등_테스트2() {
        Prize prize = Prize.getPrize(4, true);

        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    void 생성확인_5등_테스트1() {
        Prize prize = Prize.getPrize(3, false);

        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 생성확인_5등_테스트2() {
        Prize prize = Prize.getPrize(3, true);

        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 생성확인_미당첨_테스트() {
        Prize prize = Prize.getPrize(2, true);

        assertThat(prize).isEqualTo(Prize.ZERO);
    }
}