package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Test
    void 로또_번호가_정상적으로_입력될_경우_정상_작동한다() {
        Lotto lotto = new Lotto(Lotto.lottoGenerator());
    }

    @ParameterizedTest
    @MethodSource("invalidSizeOfLottoNumbers")
    void 로또_번호_개수가_유효하지_않으면_예외가_발생한다(List<Integer> testNumbers) {
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_SIZE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidRangeOfLottoNumbers")
    void 로또_번호_범위가_유효하지_않으면_예외가_발생한다(List<Integer> testNumbers) {
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("duplicateLottoNumbers")
    void 로또_번호_중복되면_예외가_발생한다(List<Integer> testNumbers) {
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    static List<List<Integer>> invalidSizeOfLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5),
                List.of(1),
                List.of()
        );
    }

    static List<List<Integer>> invalidRangeOfLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 46),
                List.of(0, 1, 2, 3, 4, 5),
                List.of(-1, 2, 3, 4, 5, 6),
                List.of(1, 30, 20, 0, 10, 100)
        );
    }

    static List<List<Integer>> duplicateLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(12, 23, 29, 43, 43, 10),
                List.of(1, 23, 31, 40, 45, 45),
                List.of(1, 30, 20, 10, 10, 20)
        );
    }
}