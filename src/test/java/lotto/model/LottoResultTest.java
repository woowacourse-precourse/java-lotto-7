package lotto.model;

import lotto.model.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {
    LottoResult lottoResult;

    @BeforeEach
    void setup() {
        lottoResult = new LottoResult();
    }

    @DisplayName("등수 계산 시 1보다 작은 값이 들어오면 예외가 발생한다.")
    @Test
    void 등수_계산_시_1보다_작은_값이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoResult.updateLottoRankSize(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수 계산 시 5보다 큰 값이 들어오면 예외가 발생한다.")
    @Test
    void 등수_계산_시_5보다_큰_값이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> lottoResult.updateLottoRankSize(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상금 계산기 테스트")
    @Test
    void 상금_계산기_테스트() {
        lottoResult.updateLottoRankSize(1);
        int sum = lottoResult.calculPrizeMoney();

        assertThat(sum).isEqualTo(2000000000);
    }
}
