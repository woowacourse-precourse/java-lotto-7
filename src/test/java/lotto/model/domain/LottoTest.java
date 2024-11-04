package lotto.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("유효한 로또 번호가 주어지면 Lotto 객체가 성공적으로 생성된다")
    void givenValidNumbers_whenCreatingLotto_thenLottoIsCreated() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(validNumbers);

        // then
        assertNotNull(lotto);
        assertEquals(validNumbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("6개 미만의 숫자가 주어지면 예외가 발생한다")
    void givenLessThanSixNumbers_whenCreatingLotto_thenThrowsException() {
        // given
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidSizeNumbers));
    }

    @Test
    @DisplayName("6개 초과의 숫자가 주어지면 예외가 발생한다")
    void givenMoreThanSixNumbers_whenCreatingLotto_thenThrowsException() {
        // given
        List<Integer> invalidSizeNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidSizeNumbers));
    }

    @Test
    @DisplayName("중복된 숫자가 포함되면 예외가 발생한다")
    void givenDuplicateNumbers_whenCreatingLotto_thenThrowsException() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 1, 3, 4, 5, 6);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbers));
    }

}