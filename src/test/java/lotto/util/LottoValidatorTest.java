package lotto.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    // SUCCESS
    @Test
    void 숫자인지_확인하다() {
        // given
        String number = "1000";

        // when
        int price = LottoValidator.validNumber(number);

        // then
        assertEquals(1000, price);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 10000})
    public void 천원_단위인지_확인하다(int price) {
        assertDoesNotThrow(() -> LottoValidator.validatePriceUnit(price));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 34, 45, 23})
    public void 숫자범위가_1에서_45사이인지_확인하다(int number) {
        assertDoesNotThrow(() -> LottoValidator.validateLottoNumber(number));
    }

    @Test
    void 보너스_번호가_정상적인지_확인한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);
        int uniqueNumber = 7;

        // then
        assertDoesNotThrow(() -> LottoValidator.validateDuplicateNumber(winningLotto, uniqueNumber));
    }

    // EXCEPTION
    @ParameterizedTest
    @ValueSource(strings = {"지종권", "abc", "!@#", " ", "1a2b", "일이삼"})
    void 숫자가_아니면_예외를_던진다(String invalidInput) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validNumber(invalidInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 1500, -1000, -500})
    void 천원단위가_아니면_예외를_던진다(int invalidPrice) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validatePriceUnit(invalidPrice));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100, 99999})
    void 숫자범위가_1에서_45사이의_숫자가_아니면_예외를_던진다(int invalidNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateLottoNumber(invalidNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스번호와_로또번호가_중복되면_예외를_던진다(int duplicateNumber) {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumbers);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateDuplicateNumber(winningLotto, duplicateNumber));
    }
}