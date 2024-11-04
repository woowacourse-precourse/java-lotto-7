package lotto.domain;

import lotto.common.ExceptionMessage;
import lotto.common.LottoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개 이상이면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1~45 사이의 정수가 아니면 예외가 발생한다.(이상)")
    @Test
    void 로또_번호가_1_45_사이의_정수가_아니면_예외가_발생한다_이상() {
        assertThatThrownBy(() ->
                new Lotto(List.of(1, 2, 3, 4, 5, LottoConfig.LOTTO_MAX_NUMBER.getValue() + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 1~45 사이의 정수가 아니면 예외가 발생한다.(이하)")
    @Test
    void 로또_번호가_1_45_사이의_정수가_아니면_예외가_발생한다_이하() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, LottoConfig.LOTTO_MIN_NUMBER.getValue() - 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
