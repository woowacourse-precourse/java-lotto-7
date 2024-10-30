package lotto;

import lotto.handler.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    private InputHandler inputHandler;

    @BeforeEach
    public void setUp() {
        inputHandler = new InputHandler();
    }
    @Test
    public void testInputMoney_validInput() {
        String input = "1000";
        int result = inputHandler.inputMoney(input);
        assertEquals(1000, result, "The money input should be parsed correctly.");
    }

    @Test
    public void 당첨번호_구분_후_입력() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = inputHandler.inputWinningNumbers(input);
        assertEquals(expected, result, "당첨 번호는 ','로 구분되어야 합니다.");
    }

    @Test
    public void 당첨번후_구분_후_입력_공백포함() {
        String input = " 1 , 2 , 3 , 4 , 5 , 6 ";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = inputHandler.inputWinningNumbers(input);
        assertEquals(expected, result, "공백이 있어도 당첨 번호를 올바르게 구문 분석해야 합니다.");
    }

    @Test
    public void 보너스_숫자_입력() {
        String input = "7";
        int result = inputHandler.inputBonusNumber(input);
        assertEquals(7, result, "보너스 번후 입력.");
    }
}
