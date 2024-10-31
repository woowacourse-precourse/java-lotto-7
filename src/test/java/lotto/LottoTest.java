package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @MethodSource("provideNumbersGreaterOrLess6InLength")
    void 로또_번호의_개수가_6개보다_적거나_많으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    private static Stream<Arguments> provideNumbersGreaterOrLess6InLength() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @Test
    void 로또_번호_리스트가_NULL이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 NULL 일 수 없습니다.");
    }

    @Test
    void 로또_번호가_NULL이면_예외가_발생한다() {
        List<Integer> numbers = Arrays.asList(null, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 null 을 포함할 수 없습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
