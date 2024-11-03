package lotto.domain;

import lotto.error.LottoErrorMessage;
import lotto.error.NumberErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("provideMisSizeNumbers")
    void 당첨번호_갯수는_6개여야_한다(List<String> numbers) {
        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.UNMATCHED_SIZE.getMessage());
    }

    @Test
    void 당첨번호는_모두_숫자여야_한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "a");

        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRangeNumbers")
    void 당첨번호는_1부터_45_사이여야_한다(List<String> numbers) {
        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.NOT_ALLOWED_NUMBER.getMessage());
    }

    @Test
    void 당첨_번호는_중복될_수_없다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "3", "4", "5");

        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.DUPLICATED_NUMBER.getMessage());
    }

    @Test
    void 정상_테스트() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "45");

        //when && then
        assertThatCode(() -> new WinningNumbers(numbers))
                .doesNotThrowAnyException();
    }

    static Stream<List<String>> provideMisSizeNumbers() {
        return Stream.of(
                List.of("1", "2", "3"),
                List.of("1", "2", "3", "4", "5", "6", "6")
        );
    }

    static Stream<List<String>> provideOutOfRangeNumbers() {
        return Stream.of(
                List.of("1", "2", "3", "4", "5", "46"),
                List.of("0", "2", "3", "4", "5", "45")
        );
    }
}