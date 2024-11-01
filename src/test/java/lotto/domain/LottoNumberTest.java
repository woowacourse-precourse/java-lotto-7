package lotto.domain;

import static lotto.LottoMachine.LOTTO_NUMBER_RANGE_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    public void 로또번호_정상테스트(String input) throws Exception {
        //Given
        LottoNumber expected = new LottoNumber(Integer.parseInt(input));

        //When
        LottoNumber actual = LottoNumber.parseLottoNumber(input);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "로또번호", "LOTTO"})
    public void 로또번호_숫자X_예외테스트(String input) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LottoNumber.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "2147483647"})
    public void 로또번호_숫자범위_예외테스트(String input) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> LottoNumber.parseLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }
}