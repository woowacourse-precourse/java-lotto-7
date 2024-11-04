package lotto.model.lottoprize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("주어진 값에 따라 적절한 LottoPrize를 반환한다.")
    @Test
    void 주어진_값에_따라_적절한_LottoPrize를_반환한다() {
        assertThat(LottoPrize.fromMatchCountAndBonus(3, false)).isEqualTo(LottoPrize.THREE_MATCHES);
        assertThat(LottoPrize.fromMatchCountAndBonus(4, false)).isEqualTo(LottoPrize.FOUR_MATCHES);
        assertThat(LottoPrize.fromMatchCountAndBonus(5, true)).isEqualTo(LottoPrize.FIVE_MATCHES_WITH_BONUS);
        assertThat(LottoPrize.fromMatchCountAndBonus(6, false)).isEqualTo(LottoPrize.SIX_MATCHES);
        assertThat(LottoPrize.fromMatchCountAndBonus(7, false)).isEqualTo(LottoPrize.NO_PRIZE); // 유효하지 않은 입력
    }

    @DisplayName("해당하는 값이 없을 경우 NO_PRIZE를 반환한다.")
    @Test
    void 해당하는_값이_없을_경우_NO_PRIZE를_반환한다() {
        assertThat(LottoPrize.fromMatchCountAndBonus(-1, false)).isEqualTo(LottoPrize.NO_PRIZE);
        assertThat(LottoPrize.fromMatchCountAndBonus(0, false)).isEqualTo(LottoPrize.NO_PRIZE);
    }

    @DisplayName("적절한 형식으로 문자열을 반환한다.")
    @Test
    void 적절한_형식으로_문자열을_반환한다() {
        assertThat(LottoPrize.THREE_MATCHES.toString()).isEqualTo("3개 일치 (5,000원) - ");
        assertThat(LottoPrize.FIVE_MATCHES_WITH_BONUS.toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        assertThat(LottoPrize.SIX_MATCHES.toString()).isEqualTo("6개 일치 (2,000,000,000원) - ");
        assertThat(LottoPrize.NO_PRIZE.toString()).isEqualTo("0개 일치 (0원) - ");
    }
}
