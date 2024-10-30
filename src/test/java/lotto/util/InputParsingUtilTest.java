package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParsingUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2,3.4,5,6"})
    void 숫자가_아닌_문자_파싱_에러(String input) {
        Assertions.assertThatThrownBy(() -> InputParsingUtil.parseWinningLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
