package validator;

import lotto.validator.LottoBonusNumbersValidator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusNumbersValidatorTest {

    @Test
    void 빈_문자열_테스트() {
        assertThatThrownBy(() -> LottoBonusNumbersValidator.validateBonusNumber("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 비어있을 수 없습니다.");
    }

    @Test
    void 범위_초과_테스트() {
        assertThatThrownBy(() -> LottoBonusNumbersValidator.validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 숫자_아님_테스트() {
        assertThatThrownBy(() -> LottoBonusNumbersValidator.validateBonusNumber("abc", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해야 합니다.");
    }

    @Test
    void 당첨번호와_중복_테스트() {
        assertThatThrownBy(() -> LottoBonusNumbersValidator.validateBonusNumber("3", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void 정상_입력_테스트() {
        LottoBonusNumbersValidator.validateBonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
    }
}
