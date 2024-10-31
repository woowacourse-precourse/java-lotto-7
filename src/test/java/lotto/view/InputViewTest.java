package lotto.view;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.ExceptionMessage;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    public void 구입_금액_입력_통과() {
        System.setIn(new ByteArrayInputStream("2000\n".getBytes()));
        int result = inputView.totalCostInput();
        assertEquals(2, result);
    }

    @Test
    public void 구입_금액_단위에_맞지않는_입력() {
        System.setIn(new ByteArrayInputStream("1500\n".getBytes()));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            inputView.totalCostInput();
        });
        assertEquals(ExceptionMessage.ERROR_NOT_DIVISIBLE_BY_1000.getMessage(), thrown.getMessage());
    }

    @Test
    public void 보너스_번호_통과() {
        System.setIn(new ByteArrayInputStream("7\n".getBytes()));
        int result = inputView.setBonusNumber();
        assertEquals(7, result);
    }

    @Test
    public void 번호_범위에_불일치() {
        System.setIn(new ByteArrayInputStream("50\n".getBytes()));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            inputView.setBonusNumber();
        });
        assertEquals(ExceptionMessage.ERROR_NOT_IN_LOTTO_NUMBER_RANGE.getMessage(), thrown.getMessage());
    }

    @Test
    public void 당첨_값_통과() {
        System.setIn(new ByteArrayInputStream("1, 2, 3, 4, 5, 6\n".getBytes()));
        assertDoesNotThrow(() -> {
            inputView.setWinningNumber();
        });
    }

    @Test
    public void 당첨_값_불일치() {
        System.setIn(new ByteArrayInputStream("1, 2, 3\n".getBytes()));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            inputView.setWinningNumber();
        });
        assertEquals(ExceptionMessage.ERROR_LOTTO_SIZE_NOT_MATCHED.getMessage(), thrown.getMessage());
    }
}
