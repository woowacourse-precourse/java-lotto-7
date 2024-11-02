package lotto.exception;

import static org.junit.jupiter.api.Assertions.*;

import lotto.enums.ErrorType;
import org.junit.jupiter.api.Test;

class CheckInputTest {

    @Test
    void 구매금액이_1000원_이하면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(500)
        );
        assertEquals(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 구매금액의_단위가_1000원이_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(1234)
        );
        assertEquals(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 입력한_구매금액이_정상일때() {
        assertDoesNotThrow(() -> CheckInput.checkInputMoney(3000));
    }

    @Test
    void 로또_당첨번호_포맷이_잘못되었을때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("strange format")
        );
        assertEquals(ErrorType.INVALID_LOTTO_NUMBER_FORMAT.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 로또_당첨번호_범위가_잘못되었을때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("1, 6, 48")
        );
        assertEquals(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 로또_당첨번호_갯수가_6개가_아닐때_예외가_발생한다(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkLottoNumbers("1, 2, 3, 4, 5, 6, 7")
        );
        assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
    }

}