package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoInputParserTest {

    private final LottoInputParser lottoInputParser;

    public LottoInputParserTest() {
        lottoInputParser = new LottoInputParser(LottoConfig.WOOWA_CONFIG);
    }

    private static Stream<Arguments> provideNumbersAndExpectedNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4", List.of(1, 2, 3, 4)),
                Arguments.of("1,2,3,4,5,6,7,8,9", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(Integer.MAX_VALUE + "," + Integer.MIN_VALUE,
                        List.of(Integer.MAX_VALUE, Integer.MIN_VALUE))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,", ",1", ",1,"})
    void 숫자에_숫자가_아닌_문자가_포함된_값이_들어올_경우_예외가_발생한다(String number) {
        assertThatThrownBy(() -> lottoInputParser.parseInt(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "-10000000000"})
    void 숫자에_int타입_보다_크거나_작은_값이_들어올_경우_예외가_발생한다(String intNumber) {
        assertThatThrownBy(() -> lottoInputParser.parseInt(intNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "1,2,3:4", "1:2,3", "1[2]3"})
    void 숫자들에_지정된_구분자가_아닌_다른_구분자가_포함된다면_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> lottoInputParser.parseNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000,10000000000", "10000000000,-10000000000", "-10000000000,-10000000000"})
    void 숫자들에_int타입_보다_크거나_작은_값이_들어올_경우_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> lottoInputParser.parseNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", Integer.MAX_VALUE + "," + Integer.MAX_VALUE, Integer.MIN_VALUE + "," + Integer.MIN_VALUE})
    void 숫자가_int타입범위에_문자가_포함되지_않는다면_예외가_발생하지_않는다(String number, int expectedNumber) {
        int actualNumber = lottoInputParser.parseInt(number);

        assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpectedNumbers")
    void 숫자들에_int타입의_숫자만포함되고_구분자가_정확하다면_예외가_발생하지_않는다(String numbers, List<Integer> expectedNumbers) {
        List<Integer> actualNumbers = lottoInputParser.parseNumbers(numbers);

        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

}
