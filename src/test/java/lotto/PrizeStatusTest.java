package lotto;

import lotto.machine.PrizeStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeStatusTest {

    @Test
    @DisplayName("THREE_MATCH 상수의 값이 올바른지 테스트")
    void threeMatchTest() {
        assertThat(PrizeStatus.THREE_MATCH.getPrizeMoney()).isEqualTo(5000);
        assertThat(PrizeStatus.THREE_MATCH.getStatusMessage()).isEqualTo("3개 일치 (5,000원)");
        assertThat(PrizeStatus.THREE_MATCH.getMatchCount()).isEqualTo(3);
        assertThat(PrizeStatus.THREE_MATCH.getIsRequireToMatchBonusNumber()).isFalse();
    }

    @Test
    @DisplayName("FOUR_MATCH 상수의 값이 올바른지 테스트")
    void fourMatchTest() {
        assertThat(PrizeStatus.FOUR_MATCH.getPrizeMoney()).isEqualTo(50000);
        assertThat(PrizeStatus.FOUR_MATCH.getStatusMessage()).isEqualTo("4개 일치 (50,000원)");
        assertThat(PrizeStatus.FOUR_MATCH.getMatchCount()).isEqualTo(4);
        assertThat(PrizeStatus.FOUR_MATCH.getIsRequireToMatchBonusNumber()).isFalse();
    }

    @Test
    @DisplayName("FIVE_MATCH 상수의 값이 올바른지 테스트")
    void fiveMatchTest() {
        assertThat(PrizeStatus.FIVE_MATCH.getPrizeMoney()).isEqualTo(1500000);
        assertThat(PrizeStatus.FIVE_MATCH.getStatusMessage()).isEqualTo("5개 일치 (1,500,000원)");
        assertThat(PrizeStatus.FIVE_MATCH.getMatchCount()).isEqualTo(5);
        assertThat(PrizeStatus.FIVE_MATCH.getIsRequireToMatchBonusNumber()).isFalse();
    }

    @Test
    @DisplayName("FIVE_MATCH_WITH_BONUS 상수의 값이 올바른지 테스트")
    void fiveMatchWithBonusTest() {
        assertThat(PrizeStatus.FIVE_MATCH_WITH_BONUS.getPrizeMoney()).isEqualTo(30000000);
        assertThat(PrizeStatus.FIVE_MATCH_WITH_BONUS.getStatusMessage()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(PrizeStatus.FIVE_MATCH_WITH_BONUS.getMatchCount()).isEqualTo(5);
        assertThat(PrizeStatus.FIVE_MATCH_WITH_BONUS.getIsRequireToMatchBonusNumber()).isTrue();
    }

    @Test
    @DisplayName("SIZE_MATCH 상수의 값이 올바른지 테스트")
    void sizeMatchTest() {
        assertThat(PrizeStatus.SIZE_MATCH.getPrizeMoney()).isEqualTo(2000000000);
        assertThat(PrizeStatus.SIZE_MATCH.getStatusMessage()).isEqualTo("6개 일치 (2,000,000,000원)");
        assertThat(PrizeStatus.SIZE_MATCH.getMatchCount()).isEqualTo(6);
        assertThat(PrizeStatus.SIZE_MATCH.getIsRequireToMatchBonusNumber()).isFalse();
    }

}
