package lotto;

import lotto.exceptioin.InputException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputExceptionTest {

    private final InputException inputException = new InputException();

    @Test
    public void 로또_구매금액이_유효하지_않으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateMoney(500); // 1000원 단위가 아님
        }, "[ERROR] 구매 금액은 1,000원 단위의 양수여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateMoney(-1000); // 음수 금액
        }, "[ERROR] 구매 금액은 1,000원 단위의 양수여야 합니다.");
    }

    @Test
    public void 로또_구매금액이_유효하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputException.validateMoney(1000));
        assertDoesNotThrow(() -> inputException.validateMoney(5000));
    }


    @Test
    public void 로또_번호가_유효하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertDoesNotThrow(() -> inputException.validateLottoNumbers(List.of(10, 20, 30, 40, 41, 42)));
    }

    @Test
    public void 보너스_번호가_유효하지_않으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateBonusNumber(0);
        }, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateBonusNumber(46);
        }, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    public void 보너스_번호가_유효하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputException.validateBonusNumber(1));
        assertDoesNotThrow(() -> inputException.validateBonusNumber(45));
    }
    @Test
    public void 로또_번호가_유효하지_않으면_예외가_발생한다() {
        // 유효하지 않은 경우: 6개가 아닌 숫자의 개수
        assertThrows(IllegalArgumentException.class, () -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5)));
        assertThrows(IllegalArgumentException.class, () -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));

        // 유효하지 않은 경우: 중복된 숫자 포함
        assertThrows(IllegalArgumentException.class, () -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5)));

        // 유효하지 않은 경우: 숫자가 1 미만이거나 45를 초과하는 경우
        assertThrows(IllegalArgumentException.class, () -> inputException.validateLottoNumbers(List.of(0, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 46)));
    }

}
