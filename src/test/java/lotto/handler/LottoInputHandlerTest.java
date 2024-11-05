package lotto.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.view.ErrorView;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoInputHandlerTest {

    private LottoInputHandler lottoInputHandler;
    private TestInputView inputView;
    private ErrorView errorView;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
        errorView = new ErrorView();

    }

    @Test
    @DisplayName("구매 금액 입력 테스트")
    void testGetPurchaseAmount() {
        String nextInput = "5000";
        inputView.setNextInput(nextInput);
        lottoInputHandler = new LottoInputHandler(inputView, errorView);
        int amount = lottoInputHandler.getPurchaseAmount();
        assertEquals(5000, amount);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void testGetWinningNumbers() {
        String nextInput = "1,2,3,4,5,6";
        inputView.setNextInput(nextInput);
        lottoInputHandler = new LottoInputHandler(inputView, errorView);
        List<Integer> winningNumbers = lottoInputHandler.getWinningNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void testGetBonusNumber() {
        String nextInput = "7";
        inputView.setNextInput(nextInput);
        lottoInputHandler = new LottoInputHandler(inputView, errorView);
        int bonusNumber = lottoInputHandler.getBonusNumber(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(7, bonusNumber);
    }

    // 테스트용
    private static class TestInputView extends InputView {
        private String nextInput;

        public void setNextInput(String nextInput) {
            this.nextInput = nextInput;
        }

        @Override
        public String inputPurchaseAmount() {
            return nextInput;
        }

        @Override
        public String inputLottoNumbers() {
            return nextInput;
        }

        @Override
        public String inputBonusNumber() {
            return nextInput;
        }
    }
    
}
