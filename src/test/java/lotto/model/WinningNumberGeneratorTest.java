package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void 당첨번호를_split해_순서대로_저장한다_1(int lottoNumbersIndex, int lottoNumber) {
        String testNumber = "1,2,3,4,5,6";
        WinningNumber winningNumber = WinningNumberGenerator.registerWinningNumber(testNumber);

        assertThat(winningNumber.getNumbers().get(lottoNumbersIndex)).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 5", "55$5", "$5 5", "5$5 ", "5 $ 5"})
    void 하나의_번호_중간에_다른_문자가_있으면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> WinningNumberGenerator.registerWinningNumber(testNumber))
                .withMessage("[ERROR] 숫자값만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 45", "45 ", "    45", "45   "})
    void 번호와_번호_사이_띄어쓰기는_허용(String testNumber) {
        String defaultNumbers = "1,2,3,4,5,";
        assertThatCode(() -> WinningNumberGenerator.registerWinningNumber(defaultNumbers + testNumber))
                .doesNotThrowAnyException();
    }
}
