package lotto.validator;

import static lotto.validator.ValidatorUtils.PRICE_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceValidatorTest {

    private PriceValidator priceValidator;

    @BeforeEach
    void setUp() {
        priceValidator = new PriceValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    void 유효한_구입금액_검사(int price) {
        assertThatCode(() -> priceValidator.validate(price))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 1001, 1500})
    void 유효하지않은_구입금액_검사(int price) {
        assertThatThrownBy(() -> priceValidator.validate(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PRICE_ERROR_MESSAGE);
    }
}
