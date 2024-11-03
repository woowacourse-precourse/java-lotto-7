package lotto;

import org.junit.jupiter.api.Test;

import lotto.Utils.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "", "1111111111111111"})
    void 정수변환_테스트(String strToConvert){
        assertThatThrownBy(() -> NumberUtils.parseStringToInt("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
