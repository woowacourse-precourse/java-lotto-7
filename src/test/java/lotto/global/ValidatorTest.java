package lotto.global;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private String validWinningNumbers;
    private String validBonusNumber;
    private String invalidPurchaseAmount;
    private List<Consumer<String>> validators;
    private List<String> invalidInputs;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validator.getInstance();

        validWinningNumbers = "1,2,3,4,5,6";
        validBonusNumber = "7";
        invalidPurchaseAmount = "1200";

        validators = Arrays.asList(
                validator::validatePurchaseAmount,
                validator::validateWinningNumbers
        );

        invalidInputs = Arrays.asList("", null);
    }

    @Nested
    @DisplayName("구입 금액 테스트")
    class ValidatePurchaseAmountTests {

        @Test
        @DisplayName("1,000원 단위가 아닌 경우 예외 발생")
        void 구입_금액_1000원_단위가_아니면_예외가_발생한다() {
            // when & then
            assertThatThrownBy(() -> validator.validatePurchaseAmount(invalidPurchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_PURCHASE_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("공백 또는 null인 경우 예외 발생")
        void 구입_금액_미입력_되면_예외가_발생한다() {
            // when & then
            invalidInputs.forEach(input ->
                    assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EMPTY_INPUT.getMessage())
            );
        }

        @Test
        @DisplayName("정상적인 금액 입력 시 예외 발생하지 않음")
        void 구입_금액_정상_입력_테스트() {
            // given
            String validPurchaseAmount = "8000"; // 예를 들어, 8000원이 정상 입력

            // when & then
            assertThatCode(() -> validator.validatePurchaseAmount(validPurchaseAmount))
                    .doesNotThrowAnyException(); // 예외가 발생하지 않음을 확인
        }

        @Test
        @DisplayName("0원 입력 시 예외 발생")
        void 구입_금액_0원_입력_테스트() {
            // when & then
            assertThatThrownBy(() -> validator.validatePurchaseAmount("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_POSITIVE_INPUT.getMessage());
        }
    }
}
