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
        assertDoesNotThrow(() -> inputException.validateMoney(1000)); // 올바른 금액
        assertDoesNotThrow(() -> inputException.validateMoney(5000)); // 올바른 금액
    }

    @Test
    public void 로또_번호가_유효하지_않으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5)); // 5개의 숫자만 있음
        }, "[ERROR] 로또 번호는 6개의 숫자로 입력되어야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 5)); // 중복된 숫자 있음
        }, "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateLottoNumbers(List.of(0, 2, 3, 4, 5, 6)); // 0은 범위 밖
        }, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 46)); // 46은 범위 밖
        }, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    public void 로또_번호가_유효하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputException.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        assertDoesNotThrow(() -> inputException.validateLottoNumbers(List.of(10, 20, 30, 40, 41, 42)));
    }

    @Test
    public void 보너스_번호가_유효하지_않으면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateBonusNumber(0); // 범위 밖
        }, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputException.validateBonusNumber(46); // 범위 밖
        }, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    public void 보너스_번호가_유효하면_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputException.validateBonusNumber(1));
        assertDoesNotThrow(() -> inputException.validateBonusNumber(45));
    }
}
