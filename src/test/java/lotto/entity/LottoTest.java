package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#provideLottoNumbers")
    void 모든_검증에_통과하여_정상적으로_생성된다(List<Integer> numbers) {
        // given

        // when

        // then
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#provideWrongSizeLottos")
    void validateSize_로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_INVALID_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void validateInRange_당첨_번호의_범위가_맞지_않아_검증에_실패한다(Integer invalidNumber) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, invalidNumber);

        // when

        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }
}
