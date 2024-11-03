package lotto.domain.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("문자열을 정수형 숫자로 변환")
    void 문자열_숫자로_변환() {
        // given
        String number = "8000";

        // when
        int convertedNumber = InputValidator.convertInteger(number);

        // then
        assertThat(convertedNumber).isEqualTo(8000);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우")
    void 구입금액_1000원단위_아닐경우() {
        // given
        int money = 8080;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isValidUnit(money);
        });
    }

    @Test
    @DisplayName("문자열을 쉼표 기준으로 분리")
    void 문자열_쉼표기준_분리() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        String[] splitedString = InputValidator.splitString(input);

        // then
        assertThat(splitedString.length).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호들을 정수형 숫자로 변환하여 리스트로 변환")
    void 문자열배열_숫자리스트_변환() {
        // given
        String input = "1,2,3,4,5,6";
        String[] splitedString = InputValidator.splitString(input);

        // when
        List<Integer> numbers = InputValidator.convertIntegers(splitedString);

        // then
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.get(0)).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("입력된 당첨 번호가 6개인지 검사")
    void 입력번호_6개_아닐때() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isValidLength(numbers);
        });
    }

    @Test
    @DisplayName("입력된 당첨 번호가 중복인지 검사")
    void 입력번호_중복일때() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 3, 6);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isDuplicate(numbers);
        });
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않는지 검사")
    void 보너스번호_당첨번호와_중복일때() {
        // given
        List<Integer> prizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isDuplicateWithPrizeNumber(prizeNumbers, bonusNumber);
        });
    }
}