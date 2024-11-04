package lotto.domain;

import java.util.List;
import lotto.common.ExceptionMessage;
import lotto.common.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {
    @DisplayName("보너스 번호에 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_숫자_예외() {
        assertThatThrownBy(() -> new LottoResult(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 사이의 정수가 아니라면 예외가 발생한다.")
    @Test
    void 보너스번호_1_45_범위가_아니면_예외() {
        assertThatThrownBy(() ->
                new LottoResult(List.of(1, 2, 3, 4, 5, 6), LottoConfig.LOTTO_MAX_NUMBER.getValue() + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
