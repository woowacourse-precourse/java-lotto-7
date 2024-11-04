package lotto.service.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberParserTest {

    @DisplayName("문자열을 넘겨주면 당첨번호들의 리스트를 넘겨줍니다")
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedList")
    void 당첨_번호_추출(String input, List<Integer> expectedList){
        List<Integer> winningNumbers = WinningNumberParser.parseWinningNumber(input);
        Assertions.assertThat(winningNumbers).containsExactlyElementsOf(expectedList);
    }

    static Stream<Arguments> provideInputAndExpectedList() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", Arrays.asList(1,2,3,4,5,6)),
                Arguments.of("1, 3, 5, 7, 9, 11", Arrays.asList(1,3,5,7,9,11)),
                Arguments.of("43 , 24, 33, 15 , 1,8", Arrays.asList(43,24,33,15,1,8))
        );
    }

    @DisplayName("문자열을 넘겨주면 보너스 번호를 추출해줍니다")
    @ParameterizedTest
    @CsvSource({
            "1 ,1",
            "43,43",
            " 34,34"
    })
    void 보너스_번호_추출(String input, int expected){
        int bonusNumber = WinningNumberParser.parseBonusNumber(input);
        Assertions.assertThat(bonusNumber).isEqualTo(expected);
    }
}