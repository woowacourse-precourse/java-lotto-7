package lotto;

import java.util.Arrays;
import lotto.week3.domain.Lotto;
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
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성


    @Test
    void 로또_생성_정상_6개_번호() {
        // Given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    void 로또_생성_번호_개수_6개_미만() {
        // Given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(invalidNumbers)
        );
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void 로또_생성_중복된_번호() {
        // Given
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(duplicateNumbers)
        );
        assertEquals("[ERROR] 로또 번호는 중복되지 않아야 합니다.", exception.getMessage());
    }

    @Test
    void 로또_생성_범위_벗어난_번호() {
        // Given
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 2, 3, 4, 5, 46);

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Lotto(outOfRangeNumbers)
        );
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    void 로또_번호_일치_개수_계산() {
        // Given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

        // When
        int matchCount = lotto.matchCount(winningNumbers);

        // Then
        assertEquals(3, matchCount, "일치하는 번호의 개수가 정확하지 않습니다.");
    }

    @Test
    void 로또_번호_포함_여부_확인() {
        // Given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When & Then
        assertTrue(lotto.contains(3), "숫자 3은 로또 번호에 포함되어야 합니다.");
        assertFalse(lotto.contains(7), "숫자 7은 로또 번호에 포함되지 않아야 합니다.");
    }

}
