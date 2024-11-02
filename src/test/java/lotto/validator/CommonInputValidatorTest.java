package lotto.validator;

import static lotto.constant.ExceptionMessage.INVALID_COMMON_EMPTY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CommonInputValidatorTest extends NsTest {

    @ParameterizedTest
    @CsvSource({
            "'', '1,2,3,4,5,6', '7'",
            "'8000', '', '7'",
            "'8000', '1,2,3,4,5,6', ''"
    })
    @DisplayName("사용자는 빈 문자열을 입력할 수 없다.")
    void 빈_문자열_입력_테스트(String price, String winning, String bonus) {
        assertThatThrownBy(() -> runException(price, winning, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMON_EMPTY.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "' ', '1,2,3,4,5,6', '7'",
            "'8000', ' ', '7'",
            "'8000', '1,2,3,4,5,6', ' '"
    })
    @DisplayName("사용자는 공백을 입력할 수 없다.")
    void 공백_입력_테스트(String price, String winning, String bonus) {
        assertThatThrownBy(() -> runException(price, winning, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_COMMON_EMPTY.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
