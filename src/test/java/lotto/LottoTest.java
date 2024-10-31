package lotto;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 클래스 테스트")
class LottoTest {

    @ParameterizedTest
    @MethodSource("provideInvalidNumberCounts")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_정상_범위_밖이면_예외를_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> provideInvalidNumberCounts() {
        return Stream.of(
            List.of(1),
            List.of(1, 2),
            List.of(1, 2, 3),
            List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

}
