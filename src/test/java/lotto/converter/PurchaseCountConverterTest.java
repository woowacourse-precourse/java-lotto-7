package lotto.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 구입 금액 변환")
class PurchaseCountConverterTest {

    private final PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter();

    @ParameterizedTest
    @ValueSource(strings = {"lotto", "amount1000", " 1000", "-1000"})
    @DisplayName("구입 금액 변환 - 정수가 아닌 문자열 변환 시도 시 예외 발생")
    void nonPositiveString_convert_throwException(String inputPurchaseAmount) {
        //given & when
        Throwable throwable = catchThrowable(() -> purchaseCountConverter.getPurchaseCount(inputPurchaseAmount));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("구매 금액은 양수만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1010", "2500", "14500", "110001"})
    @DisplayName("구입 금액 변환 - 로또 가격의 배수가 아닌 정수 변환 시도 시 예외 발생")
    void notDivisibleIntegerByThousand_convert_throwException(String inputPurchaseAmount) {
        //given & when
        Throwable throwable = catchThrowable(() -> purchaseCountConverter.getPurchaseCount(inputPurchaseAmount));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("구매 금액은 천 단위의 양수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("구입 금액 변환 - 올바른 형식의 로또 구입 금액 변환 시도 시 로또 구매 횟수 반환")
    void properFormatLottoPurchaseAmount_convert_returnLottoPurchaseCount() {
        //given
        String inputPurchaseAmount = "15000";

        //when
        int purchaseCount = purchaseCountConverter.getPurchaseCount(inputPurchaseAmount);

        //then
        assertThat(purchaseCount).isEqualTo(15);
    }
}