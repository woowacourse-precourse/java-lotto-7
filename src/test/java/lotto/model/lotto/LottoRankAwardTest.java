package lotto.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankAwardTest {

    @ParameterizedTest
    @DisplayName("로또 당첨 번호가 2개 이하인 경우 rank는 null이다.")
    @ValueSource(ints = {0, 1, 2})
    void shouldReturnNullForRankWhenMatchedNumbersAreTwoOrLess(int matchedNumberCount) {
        // when
        LottoRankAward rankAward = LottoRankAward.findLottoRank(matchedNumberCount, false);

        // then
        assertThat(rankAward).isNull();
    }

    @Test
    @DisplayName("로또 당첨 번호가 5개이고 보너스 번호가 맞은 경우 2등이다")
    void shouldReturnSecondRank() {
        // when
        LottoRankAward rankAward = LottoRankAward.findLottoRank(5, true);

        // then
        assertThat(rankAward).isEqualTo(LottoRankAward.SECOND_RANK);
    }

    @Test
    @DisplayName("로또 당첨 번호가 5개이고 보너스 번호가 맞지 않은 경우 3등이다")
    void shouldReturnThirdRank() {
        // when
        LottoRankAward rankAward = LottoRankAward.findLottoRank(5, false);

        // then
        assertThat(rankAward).isEqualTo(LottoRankAward.THIRD_RANK);
    }

}
