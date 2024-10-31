package lotto.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoInputHandlerTest {

    private LottoInputHandler lottoInputHandler;
    private TestInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
    }

    @Test
    void testGetPurchaseAmount() {
        String nextInput = "5000";
        inputView.setNextInput(nextInput);
        OutputView outputView = new OutputView();
        lottoInputHandler = new LottoInputHandler(inputView, outputView);
        int amount = lottoInputHandler.getPurchaseAmount();
        assertEquals(5000, amount);
    }

    @Test
    void testGetWinningNumbers() {
        String nextInput = "1,2,3,4,5,6";
        inputView.setNextInput(nextInput);
        OutputView outputView = new OutputView();
        lottoInputHandler = new LottoInputHandler(inputView, outputView);
        List<Integer> winningNumbers = lottoInputHandler.getWinningNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }

    @Test
    void testGetBonusNumber() {
        String nextInput = "7";
        inputView.setNextInput(nextInput);
        OutputView outputView = new OutputView();
        lottoInputHandler = new LottoInputHandler(inputView, outputView);
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

    // LottoInputHandlerTest 에서 예외 처리를 테스트할 수 없는 이유:
    // getInputWithValidation 메서드가 무한 루프를 포함하고 있어서 유효하지 않은 입력이 주어질 경우
    // 계속해서 입력을 요구하게 됩니다.이로 인해 테스트가 멈추지 않고 무한 반복될 수 있습니다.
    // 그래서 현재로서는 이 부분을 테스트하기가 어려운 것 같습니다.

}
