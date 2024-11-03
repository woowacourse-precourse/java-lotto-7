package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidationTest {
    @Test
    @DisplayName("당첨 번호 입력 공백 제거")
    void 당첨_번호_입력_공백_제거() {
        //given
        String numbers = "   1, 2 , 3 , 4 , 5   ,  6   ";

        //when
        List<String> winningNumbers = WinningNumberValidation.setTrimNumbers(numbers);

        //then
        assertThat(winningNumbers).isEqualTo(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThat(winningNumbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("숫자 리스트로 변환")
    void 숫자_리스트로_변환() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");

        //when
        List<Integer> winningNumbers = WinningNumberValidation.parseNumbers(numbers);

        //then
        assertThat(winningNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열 입력시 예외가 발생한다.")
    void 숫자가_아닌_문자열_입력시_예외가_발생한다() {
        //given
        List<String> numbers = List.of("1", "2", "삼", "4", "5", "6");

        //when
        //then
        assertThatThrownBy(() -> WinningNumberValidation.parseNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_MONEY.getErrorMessage());
    }
}