package lotto.domain;

import static lotto.domain.Amount.AMOUNT_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 14000, 2147483000})
    public void 구입금액_정상테스트(int value) throws Exception {
        //Given

        //When
        int actual = new Amount(value).getValue();

        //Then
        Assertions.assertThat(actual).isEqualTo(value);
    }

    @Test
    public void 구입금액_0원_예외테스트() throws Exception {
        //Given
        int value = 0;

        //When, Then
        Assertions.assertThatThrownBy(() -> new Amount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -2147483648})
    public void 구입금액_음수_예외테스트(int value) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> new Amount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1010, 1100, 11100, 2147483647})
    public void 구입금액_1000단위X_예외테스트(int value) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> new Amount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1000원", "구입금액", "AMOUNT"})
    public void 구입금액_숫자X_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> Amount.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "9223372036854775807"})
    public void 구입금액_int오버플로우_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> Amount.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }
}