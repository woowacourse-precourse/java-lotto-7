package lotto.domain;

import java.util.Arrays;
import lotto.exception.LottoException;
import lotto.exception.message.LottoExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("유효한 로또 번호 리스트로 Lotto 객체를 생성한다.")
    void createLottoWithValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);

        Assertions.assertEquals(validNumbers, lotto.getNumbers());
    }

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

    @Test
    @DisplayName("로또 번호가 6개보다 적을 경우 예외를 발생시킨다.")
    void throwExceptionWhenInvalidLottoCount() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3);

        LottoException exception = Assertions.assertThrows(LottoException.class, () ->
                new Lotto(invalidNumbers)
        );

        Assertions.assertTrue(
                exception.getMessage().contains(LottoExceptionMessage.INVALID_LOTTO_COUNT.getMessage())
        );
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어날 경우 예외를 발생시킨다.")
    void throwExceptionWhenNumberOutOfRange() {
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 2, 3, 4, 5, 6);

        LottoException exception = Assertions.assertThrows(LottoException.class, () ->
                new Lotto(outOfRangeNumbers)
        );

        Assertions.assertTrue(
                exception.getMessage().contains(LottoExceptionMessage.INVALID_LOTTO_NUMBER.getMessage())
        );
    }

}
