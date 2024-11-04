package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void 초기화() {
        Console.close();
        inputView = new InputView();
    }

    @AfterEach
    public void 종료_후_정리() {
        Console.close();
    }

    @Test
    public void 구매금액_입력_테스트() {
        String simulatedInput = "5000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = inputView.getBuy();
        assertEquals("5000", result);
    }

    @Test
    public void 당첨번호_입력_테스트() {
        String simulatedInput = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = inputView.getWinningNum();
        assertEquals("1,2,3,4,5,6", result);
    }

    @Test
    public void 보너스번호_입력_테스트() {
        String simulatedInput = "7\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String result = inputView.getBonusNum();
        assertEquals("7", result);
    }
}
