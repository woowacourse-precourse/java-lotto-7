package lotto.model;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_ORDER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_SIZE;
import static lotto.exception.ExceptionMessage.NULL_LOTTO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 유효한_번호_입력시_로또_생성은_성공한다() {
        // Given
        List<Integer> validNumbers = Arrays.asList(1, 5, 12, 23, 35, 45);

        // When
        Lotto lotto = new Lotto(validNumbers);

        // Then
        assertNotNull(lotto);
    }

    @Test
    void null_입력시_예외가_발생한다() {
        // Given
        List<Integer> nullNumbers = null;

        // When & Then
        assertThatThrownBy(() -> {
            new Lotto(nullNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_LOTTO.getMessage());
    }

    @Test
    void 로또_번호는_6개여야_한다() {
        // Given
        List<Integer> invalidSizeNumbers = Arrays.asList(1, 5, 12);

        // When & Then
        assertThatThrownBy(() -> {
            new Lotto(invalidSizeNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_SIZE.getMessage());
    }

    @Test
    void 로또_번호가_중복되면_안된다() {
        // Given
        List<Integer> duplicateNumbers = Arrays.asList(1, 5, 5, 23, 35, 45);

        // When & Then
        assertThatThrownBy(() -> {
            new Lotto(duplicateNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 로또_번호는_오름차순으로_정렬되어야_한다() {
        // Given
        List<Integer> unorderedNumbers = Arrays.asList(45, 35, 12, 5, 23, 1);

        // When & Then
        assertThatThrownBy(() -> {
            new Lotto(unorderedNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_ORDER.getMessage());
    }

    @Test
    void 로또_번호가_같으면_ID도_같다() {
        // Given
        List<Integer> numbers1 = Arrays.asList(1, 5, 12, 23, 35, 45);
        List<Integer> numbers2 = Arrays.asList(1, 5, 12, 23, 35, 45);

        // When
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);

        // Then
        assertEquals(lotto1.getId(), lotto2.getId());
    }
}