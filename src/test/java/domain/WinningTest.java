package domain;

import static exception.ErrorMessage.LOTTO_NUMBER_CONTAINS_BONUS_NUMBER;
import static exception.ErrorMessage.NUMBER_RANGE_ERROR;
import static exception.ErrorMessage.NUMBER_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @DisplayName("보너스 번호가 당첨번호에 존재한다면, 예외가 발생한다")
    @Test
    void numbers_contains_bonus_number_then_throw_exception() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;

        //when, then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Winning winning = Winning.of(numbers, bonusNumber);
        });
        assertThat(exception.getMessage()).isEqualTo(
                LOTTO_NUMBER_CONTAINS_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 당첨번호에 존재하지 않는다면 winner 객체가 성공적으로 만들어진다")
    @Test
    void numbers_not_contains_bonus_number_then_pass() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when, then
        Winning winning = Winning.of(numbers, bonusNumber);
    }

    @DisplayName("당첨번호가 1<=x<=45 범위가 아닐 경우, 예외가 발생한다")
    @Test
    void invalid_number_range_then_throw_exception() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 56);
        int bonusNumber = 6;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Winning winning = Winning.of(numbers, bonusNumber);
        });
        assertThat(exception.getMessage()).isEqualTo(NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 1<=x<=45 범위가 아닐 경우, 예외가 발생한다")
    @Test
    void invalid_bonus_number_range_then_throw_exception() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 46;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Winning winning = Winning.of(numbers, bonusNumber);
        });
        assertThat(exception.getMessage()).isEqualTo(NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("당첨번호의 크기가 6이 아니면 예외가 발생한다")
    @Test
    void invalid_number_size_then_throw_exception() {
        //given
        List<Integer> numbers = List.of(1,2,3,4,5);
        int bonusNumber = 10;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Winning winning = Winning.of(numbers, bonusNumber);
        });
        assertThat(exception.getMessage()).isEqualTo(NUMBER_SIZE_ERROR.getMessage());
    }

}
