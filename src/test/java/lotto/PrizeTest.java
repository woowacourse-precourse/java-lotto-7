package lotto;

import lotto.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @DisplayName("일치하는 번호 개수와 보너스 번호 일치 여부로 올바른 등수를 반환한다.")
    @Test
    void valueOf() {
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
        assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.valueOf(2, false)).isEqualTo(Prize.NONE);
    }

    @DisplayName("당첨금 정보를 정확히 반환한다.")
    @Test
    void getPrizeMoney() {
        assertThat(Prize.FIRST.getPrizeMoney()).isEqualTo(2_000_000_000);
        assertThat(Prize.SECOND.getPrizeMoney()).isEqualTo(30_000_000);
        assertThat(Prize.THIRD.getPrizeMoney()).isEqualTo(1_500_000);
        assertThat(Prize.FOURTH.getPrizeMoney()).isEqualTo(50_000);
        assertThat(Prize.FIFTH.getPrizeMoney()).isEqualTo(5_000);
    }

    @DisplayName("NONE의 경우 빈 문자열을 반환한다")
    @Test
    void noneDescription() {
        assertThat(Prize.NONE.getDescription()).isEqualTo("");
    }
}