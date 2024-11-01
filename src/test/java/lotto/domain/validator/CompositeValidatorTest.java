package lotto.domain.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompositeValidatorTest {
    private static class TestValidator implements InputValidator {

        @Override
        public void validate(String input) {
            throw new IllegalArgumentException("Input is wrong");
        }

        @Override
        public void validate(List<Integer> numbers) {
        }
    }

    @Test
    @DisplayName("모든 validator가 검증을 통과하면 예외가 발생하지 않는다")
    void validateShouldPassWhenAllValidatorsPass() {
        List<InputValidator> validators = Arrays.asList(
            new NonBlankValidator(),
            new NonBlankValidator()  // 예시를 위해 같은 validator를 두 번 사용
        );
        CompositeValidator compositeValidator = new CompositeValidator(validators);
        String input = "valid input";

        assertThatCode(() -> compositeValidator.validate(input))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("하나의 validator라도 실패하면 예외가 발생한다")
    void validateShouldThrowExceptionWhenAnyValidatorFails() {
        List<InputValidator> validators = Arrays.asList(
            new NonBlankValidator(),
            new TestValidator()
        );
        CompositeValidator compositeValidator = new CompositeValidator(validators);
        String input = "wrong input";

        assertThatThrownBy(() -> compositeValidator.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Input is wrong");
    }

    @Test
    @DisplayName("빈 validator 리스트로 생성된 경우 검증을 통과한다")
    void validateShouldPassWithEmptyValidators() {
        CompositeValidator compositeValidator = new CompositeValidator(Collections.emptyList());
        String input = "any input";

        assertThatCode(() -> compositeValidator.validate(input))
            .doesNotThrowAnyException();
    }
}