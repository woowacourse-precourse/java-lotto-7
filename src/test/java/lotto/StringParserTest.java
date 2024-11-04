package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.common.util.StringParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "10,40,30"})
    void 구분자를_기준으로_자르게된다면_결과_리스트의_크기는_3이다(String inputValue) {
        List<Integer> result = StringParser.splitByDelimiter(inputValue);
        Assertions.assertEquals(result.size(), 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,h,3", "1h,2,3", "1.2.3"})
    void 문자가_포함되면_예외를_반환한다(String inputValue) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.splitByDelimiter(inputValue);
        });
    }
}
