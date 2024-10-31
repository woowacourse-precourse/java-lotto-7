package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinnerLottoTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("예외 : null 공백 입력")
    void test1(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "6,5,4,3,2,1"})
    @DisplayName("정상 입력")
    void test2(String input) {
        new WinnerLotto(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,1"})
    @DisplayName("예외 : 중복 입력")
    void test3(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("예외 : 6자 미만 초과")
    void test4(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5,6,", "1,,2,3,4,5,6", ",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    @DisplayName("예외 : 비정상 구분자")
    void test5(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    @DisplayName("예외 : 로또 숫자 범위 초과")
    void test6(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a,2,3,4,5,6", "1,2,3,4,5,6a", "1,2,3,4,5!,6", "1!2,3,4,5a6"})
    @DisplayName("예외 : 문자 추가")
    void test7(String input) {
        assertThatThrownBy(() -> new WinnerLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
