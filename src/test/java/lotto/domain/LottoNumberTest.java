package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("정상 테스트 1~45")
    void test1() {
        for (int i = 1; i < 46; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);

            assertThat(lottoNumber.toString()).hasToString(Integer.toString(i));
        }

        for (int i = 1; i < 46; i++) {
            String s = String.valueOf(i);
            LottoNumber lottoNumber = new LottoNumber(s);

            assertThat(lottoNumber.toString()).hasToString(Integer.toString(i));
        }
    }

    @ParameterizedTest
    @DisplayName("예외 테스트 음수, 0, 45 초과 및 null")
    @ValueSource(ints = {-1, 0, 46})
    @NullSource
    void test1(Integer value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외) 공백 테스트과 초과값, 미만")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"0", "-1", "46"})
    void test2(String value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
