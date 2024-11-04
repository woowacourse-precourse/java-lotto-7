package lotto.service;

import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputServiceTest {

    private InputService inputService;

    @BeforeEach
    public void 초기화() {
        InputView inputView = new InputView() {
            @Override
            public String getBuy() {
                return "5000";
            }

            @Override
            public String getWinningNum() {
                return "1,2,3,4,5,6";
            }

            @Override
            public String getBonusNum() {
                return "7";
            }
        };
        inputService = new InputService(inputView);
    }

    @Test
    public void 유효한_구매금액_입력_테스트() {
        int buyAmount = inputService.getValidBuyInput();
        assertEquals(5000, buyAmount);
    }

    @Test
    public void 유효한_당첨번호_입력_테스트() {
        Set<Integer> winningNumbers = inputService.getValidWinningNumInput();
        assertEquals(Set.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }

    @Test
    public void 유효한_보너스번호_입력_테스트() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = inputService.getValidBonusNumberInput(winningNumbers);
        assertEquals(7, bonusNumber);
    }
}
