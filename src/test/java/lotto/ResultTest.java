package lotto;

import lotto.data.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("새로 만들어진 Result는 모든값이 0이다")
    @Test
    void 새로_만들어진_Result는_모든값이_0이다() {
        Result result = new Result();

        assertThat(result.getThreeNumberMatch()).isEqualTo(0);
        assertThat(result.getFourNumberMatch()).isEqualTo(0);
        assertThat(result.getFiveNumberMatch()).isEqualTo(0);
        assertThat(result.getBonusNumberMatch()).isEqualTo(0);
        assertThat(result.getSixNumberMatch()).isEqualTo(0);
    }
}
