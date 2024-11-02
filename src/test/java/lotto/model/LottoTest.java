package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("잘못된 로또 번호를 입력해 객체 생성을 시도")
    @ParameterizedTest(name = "로또 번호가 {0}일 경우 : {1}")
    @MethodSource
    void 잘못된_로또_번호를_입력해_객체_생성을_시도(List<Integer> inputNumbers, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(inputNumbers))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_로또_번호를_입력해_객체_생성을_시도() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), Lotto.INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), Lotto.INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE),
                Arguments.of(List.of(1, 1, 3, 4, 5, 6), Lotto.NUMBER_DUPLICATION_EXCEPTION_MESSAGE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46), Lotto.OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE),
                Arguments.of(List.of(0, 2, 3, 4, 5, 6), Lotto.OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE)
        );
    }
}
