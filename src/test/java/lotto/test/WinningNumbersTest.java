package lotto.test;

import static lotto.constant.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_SIX_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호를 담고있는 WinningNumbers에서")
public class WinningNumbersTest {
    @Test
    @DisplayName("정상적인 당첨번호가 입력되면 오류가 발생하지 않는다")
    public void normalWinningNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨번호가 6개가 아니면 오류가 발생한다")
    public void notSixWinningNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(NOT_SIX_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨번호가 중복되면 오류가 발생한다")
    public void duplicatedWinningNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨번호가 1~45사이에 없으면 오류가 발생한다")
    public void notInNormalNumberRangeWinningNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        numbers.add(100);
        //when
        //then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_RANGE_WINNING_NUMBER.getMessage());
    }
}
