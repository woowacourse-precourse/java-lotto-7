package lotto.controller;

import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputControllerTest {

    @Test
    public void 금액_입력_테스트() {
        InputView inputView = new InputView() {
            @Override
            public String getBuy() {
                return "10000";
            }
        };
        InputController inputController = new InputController(inputView);
        Money money = inputController.getMoney();
        assertEquals(10000, money.getAmount());
    }

    @Test
    public void 당첨_번호_입력_테스트() {
        InputView inputView = new InputView() {
            @Override
            public String getWinningNum() {
                return "1,2,3,4,5,6";
            }

            @Override
            public String getBonusNum() {
                return "7";
            }
        };
        InputController inputController = new InputController(inputView);
        WinningNumber winningNumber = inputController.getWinningNumber();

        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, winningNumber.getNumbers());
        assertEquals(7, winningNumber.getBonusNumber());
    }
}
