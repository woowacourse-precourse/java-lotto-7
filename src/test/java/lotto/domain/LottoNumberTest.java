package lotto.domain;

import static lotto.LottoMachine.LOTTO_NUMBER_RANGE_ERROR_MSG;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void 로또번호_정상테스트(int number) throws Exception {
        //Given
        //When
        LottoNumber actual = new LottoNumber(number);

        //Then
        Assertions.assertThat(actual).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 2147483647})
    public void 로또번호_숫자범위_예외테스트(int number) throws Exception {
        ///Given

        //When, Then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MSG);
    }
}