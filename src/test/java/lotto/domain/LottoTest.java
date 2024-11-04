package lotto.domain;

import lotto.exception.lotto.LottoNumberRangeException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 객체 테스트")
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

    @ParameterizedTest(name = "{index} : {1}")
    @MethodSource("generateExceptionData")
    @DisplayName("로또 번호가 1~45 사이가 아니라면 예외가 발생한다.")
    void invalidLottoNumberRange(List<Integer> numbers, String message) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE);
    }

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46), "45 초과"),
                Arguments.of(List.of(0, 2, 3, 4, 5, 45), "1 미만")
        );
    }

    @Test
    @DisplayName("정상 객체 생성 테스트")
    void createLotto() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 45))).isInstanceOf(Lotto.class);
    }
}
