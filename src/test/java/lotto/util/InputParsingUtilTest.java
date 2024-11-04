package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputParsingUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2,3.4,5,6"})
    void 숫자가_아닌_문자_파싱_에러(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputParsingUtil.parseWinningLottoNumbers(input));
    }

}
