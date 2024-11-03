package lotto.domain;

import static lotto.domain.BonusNumber.BONUS_NUMBER_DUPLICATE_ERROR_MSG;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {7, 45})
    public void 보너스번호_정상테스트(int number) throws Exception {
        //Given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When
        int actual = new BonusNumber(number, winningNumber).getNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    public void 보너스번호_중복_예외테스트(int number) throws Exception {
        //Given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When, Then
        Assertions.assertThatThrownBy(() -> new BonusNumber(number, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7", "45"})
    public void 보너스번호파싱_정상테스트(String input) throws Exception {
        //Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int expected = Integer.parseInt(input);

        //When
        int actual = BonusNumber.parse(input, winningNumbers).getNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "6"})
    public void 보너스번호파싱_중복_예외테스트(String input) throws Exception {
        //Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When, Then
        Assertions.assertThatThrownBy(() -> BonusNumber.parse(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_ERROR_MSG);
    }
}