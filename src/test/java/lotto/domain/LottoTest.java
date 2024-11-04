package lotto.domain;

import lotto.domain.vo.LottoNumber;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.constants.LottoConstants.LOTTO_DEFAULT_COUNT;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidLottoNumbersThenCreatesInstance() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(validNumbers);

        assertThat(lotto.getNumbersAsUnmodifiableList())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void testLottoNumbersAreSorted() {
        List<Integer> unsortedNumbers = List.of(5, 3, 1, 6, 4, 2);
        Lotto lotto = Lotto.from(unsortedNumbers);

        assertThat(lotto.getNumbersAsUnmodifiableList())
                .containsExactly(1, 2, 3, 4, 5, 6);  // 오름차순 정렬 여부 확인
    }

    @Test
    void testInvalidLottoSizeThenThrowsException() {
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5);  // 5개일 때

        assertThatThrownBy(() -> Lotto.from(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 6})
    void testContainsReturnsTrueForExistingNumber(int number) {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.of(number);

        assertThat(lotto.contains(lottoNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9})
    void testContainsReturnsFalseForNonExistingNumber(int number) {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.of(number);

        assertThat(lotto.contains(lottoNumber)).isFalse();
    }

    @Test
    void testCountMatchingNumbersReturnsCorrectCount() {
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(List.of(4, 5, 6, 7, 8, 9));

        int matchingCount = lotto1.countMatchingNumbers(lotto2);

        assertThat(matchingCount).isEqualTo(3);
    }

    @Test
    void testCountMatchingNumbersReturnsZeroWhenNoMatches() {
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(List.of(7, 8, 9, 10, 11, 12));

        int matchingCount = lotto1.countMatchingNumbers(lotto2);

        assertThat(matchingCount).isEqualTo(0);
    }

    @Test
    void testGetNumbersAsUnmodifiableListReturnsCorrectSize() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbers = lotto.getNumbersAsUnmodifiableList();

        assertThat(numbers).hasSize(LOTTO_DEFAULT_COUNT);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
