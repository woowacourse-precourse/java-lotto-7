package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("LottoRank valueOf 메서드 테스트: 6개 일치 시 1등 반환")
    void 여섯_개_일치하면_1등_반환() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("LottoRank valueOf 메서드 테스트: 5개 일치 + 보너스 번호 일치 시 2등 반환")
    void 다섯_개_일치하고_보너스_일치하면_2등_반환() {
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("LottoRank valueOf 메서드 테스트: 5개 일치 시 3등 반환")
    void 다섯_개_일치하면_3등_반환() {
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("LottoRank valueOf 메서드 테스트: 일치 개수가 적으면 NONE 반환")
    void 세_개_미만의_일치하면_NONE_반환() {
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }
}
