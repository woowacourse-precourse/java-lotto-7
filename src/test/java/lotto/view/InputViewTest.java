package lotto.view;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 구매_금액이_null일_때_예외(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput(null);
        }, "[ERROR] 구입 금액을 입력해 주세요.");
    }

    @Test
    void 구매_금액이_빈_문자열일_떄_예외_발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput("");
        }, "[ERROR] 구입 금액을 입력해 주세요.");
    }

    @Test
    void 구매_금액이_숫자가_아닐_때_예와_발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput("invalid123");
        }, "[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @Test
    void 구매_금액이_올바른_입력일_때(){
        assertDoesNotThrow(() -> InputView.validateAmountInput("1000"));
    }

    @Test
    void 구매_금액이_1000원_단위가_아닐떄(){
        assertEquals(InputView.isModZero(1123), false);
    }

    @Test
    void 구매_금액이_1000원_단위일_때(){
        assertEquals(InputView.isModZero(100000), true);
    }

    @Test
    void 당첨_번호_입력이_빈_문자열일_때_예외_발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("");
        }, "[ERROR] 당첨 번호를 입력해 주세요.");
    }

    @Test
    void 당첨_번호_입력이_쉼표로_구분된_6개의_숫자가_아닐_때_예외(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("1,2,3,4,5");
        }, "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("1,2,3,4,5,6,7");
        }, "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호_입력에_숫자가_아닌_값이_포함될_때_예외(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("1,2,3,4,5,a");
        }, "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호_입력이_범위를_벗어날_때_예외(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("0,2,3,4,5,6");
        }, "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("1,2,3,4,5,46");
        }, "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateWinningLottoInput("-1,2,3,4,5,45");
        }, "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 올바른_당첨_번호_입력_케이스(){
        assertDoesNotThrow(() -> InputView.validateWinningLottoInput("1,2,3,4,5,6"));
    }

    @Test
    void 보너스_번호_입력이_빈_문자열인_경우_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumberInput("", winningNumbers);
        }, "[ERROR] 보너스 번호를 입력해 주세요.");
    }

    @Test
    void 보너스_번호_입력이_숫자가_아닌_경우_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumberInput("abc", winningNumbers);
        }, "[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호_입력이_범위를_벗어난_경우_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumberInput("0", winningNumbers);
        }, "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumberInput("46", winningNumbers);
        }, "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호_입력이_당첨_번호와_중복인_경우_예외(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateBonusNumberInput("3", winningNumbers); // 3은 당첨 번호에 포함됨
        }, "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void 보너스_번호_올바른_입력(){
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> InputView.validateBonusNumberInput("10", winningNumbers));
    }
}
