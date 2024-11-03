package lotto.valid;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.config.exception.input.InputException;
import lotto.helper.valid.ValidInput;
import org.junit.jupiter.api.Test;

public class ValidInputTest {

    @Test
    void 구입금액의_입력값이_잘못된_경우_예외가_발생한다() {
        String emptyInput = "";
        String stringInput = "abc";
        String notUnitInput = "1234";
        assertThrows(InputException.class, () -> ValidInput.checkInputMoney(emptyInput));
        assertThrows(InputException.class, () -> ValidInput.checkInputMoney(stringInput));
        assertThrows(InputException.class, () -> ValidInput.checkInputMoney(notUnitInput));
    }

    @Test
    void 로또번호의_입력값이_잘못된_경우_예외가_발생한다() {
        String emptyInput = "";
        String notDelimiterInput = "1234";
        String stringInput = "1,a,2,3";
        assertThrows(InputException.class, () -> ValidInput.checkInputLottoNumbers(emptyInput));
        assertThrows(InputException.class, () -> ValidInput.checkInputLottoNumbers(notDelimiterInput));
        assertThrows(InputException.class, () -> ValidInput.checkInputLottoNumbers(stringInput));
    }

    @Test
    void 보너스번호의_입력값이_잘못된_경우_예외가_발생한다() {
        String emptyInput = "";
        String stringInput = "abc";
        assertThrows(InputException.class, () -> ValidInput.checkInputMoney(emptyInput));
        assertThrows(InputException.class, () -> ValidInput.checkInputMoney(stringInput));
    }
}
