package lotto.model;

import java.util.stream.Stream;
import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_SIZE.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidRangeIntegerLists")
    void 로또_번호가_범위에_맞지_않으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_번호는_수정될_수_없다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> returned = lotto.getNumbers();

        assertThatThrownBy(() -> returned.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    static Stream<List<Integer>> invalidRangeIntegerLists() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }
}
