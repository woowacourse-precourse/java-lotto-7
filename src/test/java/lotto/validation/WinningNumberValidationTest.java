package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.ErrorMessage.*;
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
    @DisplayName("중복되지 않은 6개의 수 입력")
    void 중복되지_않은_6개의_수_입력() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");

        //when
        List<String> winningNumbers = WinningNumberValidation.setUniqueNumbers(numbers);

        //then
        assertThat(winningNumbers).containsExactlyInAnyOrder("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("6개 미만 수 입력시 예외가 발생한다.")
    void 여섯개_미만_수_입력시_예외가_발생한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        //when
        //then
        assertThatThrownBy(() -> WinningNumberValidation.setUniqueNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
    }

    @Test
    @DisplayName("6개 초과 수 입력시 예외가 발생한다.")
    void 여섯개_초과_수_입력시_예외가_발생한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7");

        //when
        //then
        assertThatThrownBy(() -> WinningNumberValidation.setUniqueNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
    }

    @Test
    @DisplayName("중복있는 6개의 수 입력시 예외가 발생한다.")
    void 중복있는_6개의_수_입력시_예외가_발생한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "5");

        //when
        //then
        assertThatThrownBy(() -> WinningNumberValidation.setUniqueNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
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

    @Test
    @DisplayName("로또 번호는 1~45 사이")
    void 로또_번호는_1_45_사이() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        //then
        WinningNumberValidation.validateRange10To45(numbers);
    }

    @Test
    @DisplayName("로또 번호는 1~45 사이가 아니면 예외가 발생한다.")
    void 로또_번호는_1_45_사이가_아니면_예외가_발생한다() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 46, 5, 6);

        //when
        //then
        assertThatThrownBy(() -> WinningNumberValidation.validateRange10To45(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
    }

}