package lotto;

import global.errorMessage.BonusNumberErrorMessage;
import global.errorMessage.LottoErrorMessage;
import global.errorMessage.NumberErrorMessage;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void test3() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호 중에서 45 보다 큰 번호가 있을 경우 예외가 발생한다.")
    void test1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 200)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.OUT_OF_RANGE.getMessage());
    }
    @Test
    @DisplayName("로또 번호 중에서 1 보다 작은 번호가 있을 경우 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.OUT_OF_RANGE.getMessage());
    }
}
