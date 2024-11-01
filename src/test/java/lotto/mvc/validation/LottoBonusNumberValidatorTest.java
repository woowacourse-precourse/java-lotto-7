package lotto.mvc.validation;

import java.util.List;
import lotto.mvc.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBonusNumberValidatorTest {
    static Lotto lotto;

    @BeforeAll
    static void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("예외 테스트 - 아무것도 입력하지 않았을 때")
    @ParameterizedTest
    @NullAndEmptySource
    void test1(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - 문자를 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"ㅁ", ",", "/", "\"", "a", "1.1"})
    void test2(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - int 범위를 넘어가는 수를 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"21212121212", "2147483648"})
    void test3(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - 음수를 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-11", "-44"})
    void test4(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - 0을 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void test5(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - 1 ~ 45 사이의 정수가 아닌 수를 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"46", "80", "100"})
    void test6(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트 - 당첨 번호에 해당하는 수를 입력했을 때")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void test7(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberValidator.isValid(lotto, input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}