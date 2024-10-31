package lotto;

import static lotto.LottoMachine.AMOUNT_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    @ParameterizedTest
    @ValueSource(strings = {"0", "1000", "10000", "14000", "2147483000"})
    public void 구입금액_정상테스트(String input) throws Exception {
        //Given
        int expected = Integer.parseInt(input);

        //When
        int actual = LOTTO_MACHINE.parseAmount(input);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1000원", "구입금액", "AMOUNT"})
    public void 구입금액_숫자X_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "-2147483648"})
    public void 구입금액_음수_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "9223372036854775807"})
    public void 구입금액_int오버플로우_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1010", "1100", "11100", "2147483647"})
    public void 구입금액_1000단위X_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_ERROR_MSG);
    }
}