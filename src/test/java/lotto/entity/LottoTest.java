package lotto.entity;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 로또 번호 리스트 생성 테스트")
    void shouldCreateLottoWithValidNumbers() {
        // Given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외 발생")
    void shouldThrowExceptionWhenInvalidNumberCount() {
        // Given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5); // 5개 번호

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 로또 번호가 있을 경우 예외 발생")
    void shouldThrowExceptionWhenDuplicateNumbers() {
        // Given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복 번호

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbers));
        assertEquals(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 유효 범위를 벗어날 경우 예외 발생")
    void shouldThrowExceptionWhenNumberOutOfRange() {
        // Given
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46); // 46은 범위 초과

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(outOfRangeNumbers));
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수 확인 테스트")
    void shouldReturnCorrectMatchingCount() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);

        // When
        int matchCount = lotto.countMatchingNumbers(winningNumbers);

        // Then
        assertEquals(3, matchCount); // 1, 2, 3이 일치
    }

    @Test
    @DisplayName("보너스 번호와 일치할 경우 true 반환")
    void shouldReturnTrueWhenBonusNumberMatches() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 6;

        // When
        boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);

        // Then
        assertTrue(bonusMatch);
    }
}
