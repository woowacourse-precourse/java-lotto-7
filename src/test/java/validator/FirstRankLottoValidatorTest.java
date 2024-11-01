package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstRankLottoValidatorTest {

    private final FirstRankLottoValidator firstRankLottoValidator;

    FirstRankLottoValidatorTest() {
        this.firstRankLottoValidator = new FirstRankLottoValidator();
    }

    @Test
    @DisplayName("validateBonusNumber는 당첨 번호와 겹치는 보너스 번호일 때, IllegalArgumentException을 던집니다.")
    void validateBonusNumber_WithDuplicatedNumber_ThrowIllegalArgumentException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 4;

        // when & then
        assertThatThrownBy(
                () -> firstRankLottoValidator.validateBonusNumber(numbers, bonusNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateBonusNumber는 유효한 보너스 번호일 때, 예외를 던지지 않는다.")
    void validateBonusNumber_WithValidNumber_DoesNotThrowException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when & then
        assertThatCode(
                () -> firstRankLottoValidator.validateBonusNumber(numbers, bonusNumber)
        ).doesNotThrowAnyException();
    }
}
