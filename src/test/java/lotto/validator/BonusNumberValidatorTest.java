package lotto.validator;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberValidatorTest {

    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void 유효한_보너스번호_검사(int bonusNumber) {
        assertThatCode(() -> bonusNumberValidator.validate(bonusNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void 유효하지_않은_보너스번호_검사(int bonusNumber) {
        assertThatThrownBy(() -> bonusNumberValidator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_ERROR_MESSAGE);
    }
}
