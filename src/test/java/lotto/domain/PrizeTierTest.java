package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTierTest {

    @Test
    @DisplayName("일치하는 당첨 등수를 정확히 판별하는지 확인")
    void 당첨_등수_판별() {
        Optional<PrizeTier> prizeTier = PrizeTier.getPrizeTier(5, true);
        assertThat(prizeTier).contains(PrizeTier.SECOND);
    }

    @Test
    @DisplayName("일치하는 등수가 없을 때 빈 Optional이 반환되어야 한다.")
    void 빈_등수_확인() {
        Optional<PrizeTier> prizeTier = PrizeTier.getPrizeTier(2, false);
        assertThat(prizeTier).isEmpty();
    }
}