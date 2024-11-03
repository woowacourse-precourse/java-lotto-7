package validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import model.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberValidateTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("validateBonusNumber 문자열 입력 테스트")
    @Test
    void validateBonusNumber_문자열_입력_테스트() {
        Status statusTest = new Status(1000);
        statusTest.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Validator.validateBonusNumber("SuperNova", statusTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateBonusNumber 범위 외 입력 테스트")
    @Test
    void validateBonusNumber_범위_외_입력_테스트() {
        Status statusTest = new Status(1000);
        statusTest.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Validator.validateBonusNumber("222", statusTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }


    @DisplayName("validateBonusNumber 중복 입력 테스트")
    @Test
    void validateBonusNumber_중복_입력_테스트() {
        Status statusTest = new Status(1000);
        statusTest.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Validator.validateBonusNumber("2", statusTest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateBonusNumber 정상 검증 테스트")
    @Test
    void validateBonusNumber_정상_검증_테스트() {
        Status statusTest = new Status(1000);
        statusTest.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> Validator.validateBonusNumber("7", statusTest))
                .doesNotThrowAnyException();
    }
}
