package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilTest {
    @Test
    void 유효한_숫자_검증_성공_테스트() {
        Assertions.assertEquals(Util.checkValidInteger("34"), 34);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2", "12 ", "12a", "12/"})
    void 유효한_숫자_검증_실패_테스트(String input) {
        assertThatThrownBy(() -> Util.checkValidInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}