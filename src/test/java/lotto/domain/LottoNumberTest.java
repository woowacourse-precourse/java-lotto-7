package lotto.domain;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void 로또숫자_정상테스트(int number) throws Exception {
        //Given
        //When
        int actual = new LottoNumber(number).getNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 2147483647})
    public void 로또숫자X_예외테스트(int number) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "L", "또"})
    public void 로또숫자파싱_숫자X_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LottoNumber.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "9223372036854775807"})
    public void 로또숫자_int오버플로우_예외테스트(String input) throws Exception {
        //Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LottoNumber.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ERROR_MSG);
    }
}