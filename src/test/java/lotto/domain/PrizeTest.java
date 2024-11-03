package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @DisplayName("일등 당첨 내역 결과 검증")
    @Test
    void 일등_당첨_결과_검증() {
        Prize prize = Prize.getPrize(getLotto(), List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @DisplayName("이등 당첨 내역 결과 검증")
    @Test
    void 이등_당첨_결과_검증() {
        Prize prize = Prize.getPrize(getLotto(), List.of(1, 2, 3, 4, 5, 16), 6);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @DisplayName("삼등 당첨 내역 결과 검증")
    @Test
    void 삼등_당첨_결과_검증() {
        Prize prize = Prize.getPrize(getLotto(), List.of(1, 2, 3, 4, 5, 16), 7);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @DisplayName("사등 당첨 내역 결과 검증")
    @Test
    void 사등_당첨_결과_검증() {
        Prize prize = Prize.getPrize(getLotto(), List.of(1, 2, 3, 4, 15, 16), 7);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("오등 당첨 내역 결과 검증")
    @Test
    void 오등_당첨_결과_검증() {
        Prize prize = Prize.getPrize(getLotto(), List.of(1, 2, 3, 14, 15, 16), 7);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    private static Lotto getLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}