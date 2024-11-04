package lotto.utils.inputValidator;

import static lotto.constants.LottoTicket.LOTTO_PRICE;
import static lotto.constants.LottoTicket.PURCHASE_LIMIT;
import static lotto.exception.ErrorMessages.BEYOND_LIMIT;
import static lotto.exception.ErrorMessages.NOT_DIVIDED_BY_LOTTO_PRICE;
import static lotto.utils.fixture.InputFixture.VALID_RAW_PURCHASE_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[Utils] PurchaseAmountValidator")
public class PurchaseAmountValidatorTest {
    private final PositiveIntValidator positiveIntValidator = new PositiveIntValidator();
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator(positiveIntValidator);

    @Nested
    @DisplayName("[validateDividedByLottoPrice] 입력값이 로또 가격으로 나누어떨어지는 지 검증한다")
    class ValidateDividedByLottoPriceTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 로또 구매 금액은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateDividedByLottoPrice_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_PURCHASE_AMOUNT.getInput();

            //when & then
            assertDoesNotThrow(()-> purchaseAmountValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"810","1880","124523"}) //given
        @DisplayName("[Exception] 입력값이 로또 가격으로 나누어떨어지지 않는 경우 예외를 던진다.")
        void Given_NotDividedByLottoPrice_When_ValidateDividedByLottoPrice_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> purchaseAmountValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(NOT_DIVIDED_BY_LOTTO_PRICE.getMessage(),LOTTO_PRICE.getValue()));
        }
    }


    @Nested
    @DisplayName("[validateNotBeyondPurchaseLimit] 입력값이 최대 구매 가능 금액을 넘지 않는 지 검증한다.")
    class ValidateNotBeyondPurchaseLimitTest {

        @Test
        @DisplayName("[Pass] 정상적인 조건의 로또 구매 금액은 아무런 행동도 하지 않는다.")
        void Given_ValidInput_When_ValidateNotBeyondPurchaseLimit_Then_DoNothing(){
            //given
            final String VALID_INPUT = VALID_RAW_PURCHASE_AMOUNT.getInput();

            //when & then
            assertDoesNotThrow(()-> purchaseAmountValidator.validate(VALID_INPUT));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000000","500000000"}) //given
        @DisplayName("[Exception] 입력값이 로또 가격으로 나누어떨어지지 않는 경우 예외를 던진다.")
        void Given_BeyondPurchaseLimit_When_ValidateNotBeyondPurchaseLimit_Then_ThrowException(String invalidInput){

            //when & then
            assertThatThrownBy(()-> purchaseAmountValidator.validate(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(BEYOND_LIMIT.getMessage(),PURCHASE_LIMIT.getValue()));
        }
    }
}
