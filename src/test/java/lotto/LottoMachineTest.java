package lotto;

import static lotto.Lotto.LOTTO_NUMBER_DUPLICATE_ERROR_MSG;
import static lotto.Lotto.LOTTO_NUMBER_SIZE_ERROR_MSG;
import static lotto.LottoMachine.AMOUNT_ERROR_MSG;
import static lotto.LottoMachine.BONUS_NUMBER_DUPLICATE_ERROR_MSG;
import static lotto.LottoMachine.LOTTO_NUMBER_RANGE_ERROR_MSG;
import static lotto.LottoMachine.LOTTO_PRICE;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    public void 로또번호_정상테스트(String input) throws Exception {
        //Given
        int expected = Integer.parseInt(input);

        //When
        int actual = LOTTO_MACHINE.parseLottoNumber(input);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "로또번호", "LOTTO"})
    public void 로또번호_숫자X_예외테스트(String input) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "2147483647"})
    public void 로또번호_숫자범위_예외테스트(String input) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }

    @Test
    public void 로또_발행_테스트() throws Exception {
        //Given
        int amount = 14000;
        int expected = amount / LOTTO_PRICE;
        LOTTO_MACHINE.issue(amount);

        //When
        int actual = LOTTO_MACHINE.getLottoBunch().size();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 당첨번호_정상테스트() throws Exception {
        //Given
        String input = "1,10,20,30,40,45";

        //When
        List<Integer> actual = LOTTO_MACHINE.parseWinningNumber(input).getNumbers();

        //Then
        Assertions.assertThat(actual).containsExactly(1, 10, 20, 30, 40, 45);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1,,3,4,5,6", "1,2,3,4,5,46", "1,2,3,4,5, 6"})
    public void 당첨번호_로또숫자_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }

    @Test
    public void 당첨번호_중복_예외테스트() throws Exception {
        //Given
        String input = "1,2,3,4,6,6";

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void 당첨번호_개수_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_SIZE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "45"})
    public void 보너스번호_정상테스트(String input) throws Exception {
        //Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expected = Integer.parseInt(input);

        //When
        int actual = LOTTO_MACHINE.parseBonusNumber(winningNumbers, input);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "6"})
    public void 보너스번호_중복_예외테스트(String input) throws Exception {
        //Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When, Then
        Assertions.assertThatThrownBy(() -> LOTTO_MACHINE.parseBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_ERROR_MSG);
    }
}