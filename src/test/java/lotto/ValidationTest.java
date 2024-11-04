package lotto;

import lotto.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {

    @Test
    @DisplayName("숫자 형식의 문자열 확인 - 올바른 형식")
    void isNumberValue_valid() {
        assertThat(Validation.isNumberValue("12345")).isTrue();
    }

    @Test
    @DisplayName("숫자 형식의 문자열 확인 - 빈 문자열")
    void isNumberValue_emptyString() {
        assertThat(Validation.isNumberValue("")).isFalse();
    }

    @Test
    @DisplayName("숫자 형식의 문자열 확인 - null 값")
    void isNumberValue_null() {
        assertThat(Validation.isNumberValue(null)).isFalse();
    }

    @Test
    @DisplayName("숫자 형식의 문자열 확인 - 숫자가 아닌 문자 포함")
    void isNumberValue_invalidFormat() {
        assertThat(Validation.isNumberValue("123a45")).isFalse();
    }

    @Test
    @DisplayName("숫자가 지정된 범위에 있는지 확인 - 범위 내 값")
    void isCorrectRange_validRange() {
        assertThat(Validation.isCorrectRange(10)).isTrue();
    }

    @Test
    @DisplayName("숫자가 지정된 범위에 있는지 확인 - 범위 외 값")
    void isCorrectRange_invalidRange() {
        assertThat(Validation.isCorrectRange(50)).isFalse();
    }

    @Test
    @DisplayName("금액이 1000으로 나누어지는지 확인 - 나누어 떨어짐")
    void isDivided_valid() {
        assertThat(Validation.isDivided(3000)).isTrue();
    }

    @Test
    @DisplayName("금액이 1000으로 나누어지는지 확인 - 나누어 떨어지지 않음")
    void isDivided_invalid() {
        assertThat(Validation.isDivided(2500)).isFalse();
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 형식 확인 - 올바른 형식")
    void isCorrectFormat_valid() {
        assertThat(Validation.isCorrectFormat("1,2,3,4,5,6")).isTrue();
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 형식 확인 - 잘못된 형식")
    void isCorrectFormat_invalid() {
        assertThat(Validation.isCorrectFormat("1,2,a,4,5,6")).isFalse();
    }

    @Test
    @DisplayName("숫자 리스트가 지정된 범위에 있는지 확인 - 범위 내 값")
    void isCorrectRange_listValidRange() {
        List<Integer> numbers = List.of(1, 10, 20, 30, 40, 45);
        assertThat(Validation.isCorrectRange(numbers)).isTrue();
    }

    @Test
    @DisplayName("숫자 리스트가 지정된 범위에 있는지 확인 - 범위 외 값 포함")
    void isCorrectRange_listInvalidRange() {
        List<Integer> numbers = List.of(1, 10, 20, 30, 50);
        assertThat(Validation.isCorrectRange(numbers)).isFalse();
    }

    @Test
    @DisplayName("숫자 리스트의 크기 확인 - 올바른 크기")
    void isCorrectSize_valid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Validation.isCorrectSize(numbers)).isTrue();
    }

    @Test
    @DisplayName("숫자 리스트의 크기 확인 - 잘못된 크기")
    void isCorrectSize_invalid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThat(Validation.isCorrectSize(numbers)).isFalse();
    }

    @Test
    @DisplayName("양수인지 확인 - 양수 값")
    void isPositive_positive() {
        assertThat(Validation.isPositive(5)).isTrue();
    }

    @Test
    @DisplayName("양수인지 확인 - 0 또는 음수 값")
    void isPositive_notPositive() {
        assertThat(Validation.isPositive(-5)).isFalse();
        assertThat(Validation.isPositive(0)).isFalse();
    }

    @Test
    @DisplayName("숫자 리스트에 중복된 값이 없는지 확인 - 중복 없음")
    void isDuplicate_noDuplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Validation.isDuplicate(numbers)).isTrue();
    }

    @Test
    @DisplayName("숫자 리스트에 중복된 값이 없는지 확인 - 중복 있음")
    void isDuplicate_hasDuplicate() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 5, 6);
        assertThat(Validation.isDuplicate(numbers)).isFalse();
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 확인 - 중복 있음")
    void isDuplicate_bonusNumberDuplicate() {
        int bonusNumber = 7;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(Validation.isDuplicate(bonusNumber, winningNumbers)).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 확인 - 중복 없음")
    void isDuplicate_bonusNumberNoDuplicate() {
        int bonusNumber = 8;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(Validation.isDuplicate(bonusNumber, winningNumbers)).isFalse();
    }
}

