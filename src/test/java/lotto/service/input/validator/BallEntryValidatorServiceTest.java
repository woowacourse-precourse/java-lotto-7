package lotto.service.input.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallEntryValidatorServiceTest {

    private BallEntryValidatorService ballEntryValidator;

    @BeforeEach
    void setUp() {
        ballEntryValidator = new BallEntryValidatorService();
    }

    @Test
    @DisplayName("정상적인 입력 시 예외 미 발생 테스트")
    void normal() {
        String input = "1,2,3,4,5,6";
        assertDoesNotThrow(() -> ballEntryValidator.validate(input));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 섞여 있을 시 예외 발생 테스트")
    void noneNumeric() {
        String input = "1t";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 숫자 개수 입력 시 예외 발생 테스트_더 많은 경우")
    void wrongNumberCount1() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 숫자 개수 입력 시 예외 발생 테스트_더 적은 경우")
    void wrongNumberCount2() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 구분자 개수 입력 시 예외 발생 테스트_더 많은 경우")
    void wrongSeparatorCount1() {
        String input = "1,2,3,4,5,6,";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 범위 숫자 입력 시 예외 발생 테스트_범위보다 큰 값")
    void wrongNumberRange1() {
        String input = "1,2,3,4,46,5";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 범위 숫자 입력 시 예외 발생 테스트_범위보다 작은 값")
    void wrongNumberRange2() {
        String input = "0,2,3,4,46,5";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 숫자가 있을 경우 예외 발생 테스트1")
    void sameNumberExist1() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> ballEntryValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 숫자가 있을 경우 예외 발생 테스트2 행운 숫자와 같은 수")
    void sameNumberExist2() {
        String input = "1,2,3,4,5,6";
        String lucky = "6";

        assertThatThrownBy(() -> {
            ballEntryValidator.validate(input);

            LuckyBallInputValidatorService luckyBallInputValidator
                    = new LuckyBallInputValidatorService(BallEntryValidatorService.getBallInputEntry());

            luckyBallInputValidator.validate(lucky);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}