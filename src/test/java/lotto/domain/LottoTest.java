package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    static Stream<Arguments> listParameterProvider() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 46)),
                arguments(List.of(0, 1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("listParameterProvider")
    void 로또_번호_1보다작고_45보다크면_에러(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers));
    }
}
