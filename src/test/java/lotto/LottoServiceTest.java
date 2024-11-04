package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService;
    private TestInputView inputView;
    private TestOutputView outputView;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
        outputView = new TestOutputView();
        lottoService = new LottoService(inputView, outputView);
    }

    @Test
    void parseInputToCash_유효한입력() {
        String input = "3000";
        Integer cash = lottoService.parseInputToCash(input);
        assertEquals(3000, cash);
    }

    @Test
    void parseInputToCash_잘못된입력_예외발생() {
        inputView.setNextInput("3000");
        String invalidInput = "abc";

        Integer cash = lottoService.parseInputToCash(invalidInput);

        assertEquals(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage(), outputView.getLastErrorMessage());
        assertEquals(3000, cash);
    }

    @Test
    void parseInputToCash_최소단위미만입력_예외발생() {
        inputView.setNextInput("3000");
        String invalidInput = "500";

        Integer cash = lottoService.parseInputToCash(invalidInput);

        assertEquals(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage(), outputView.getLastErrorMessage());
        assertEquals(3000, cash);
    }

    @Test
    void parseInputToCash_정확한단위아님_예외발생() {
        inputView.setNextInput("3000");
        String invalidInput = "2500";

        Integer cash = lottoService.parseInputToCash(invalidInput);

        assertEquals(ErrorMessage.INVALID_CASH_MESSAGE.getMessage(), outputView.getLastErrorMessage());
        assertEquals(3000, cash);
    }

    @Test
    void parseCashToLottoAmount_정확한결과() {
        Integer cash = 5000;
        Integer lottoAmount = lottoService.parseCashToLottoAmount(cash);
        assertEquals(5, lottoAmount);
    }

    @Test
    void parseWinningNumber_유효한번호() {
        String input = "1,2,3,4,5,6";
        Lotto winningLotto = lottoService.parseWinningNumber(input);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningLotto.getNumbers());
    }

    @Test
    void parseWinningNumber_잘못된번호입력_예외발생() {
        inputView.setNextInput("1,2,3,4,5,6");
        String invalidInput = "1,2,3,a,b,c";

        Lotto winningLotto = lottoService.parseWinningNumber(invalidInput);

        assertEquals(ErrorMessage.INVALID_WINNING_NUMBER.getMessage(), outputView.getLastErrorMessage());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winningLotto.getNumbers());
    }

    @Test
    void parseBonusNumber_유효한보너스번호() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String bonusNumberInput = "7";
        Integer bonusNumber = lottoService.parseBonusNumber(winningLotto, bonusNumberInput);
        assertEquals(7, bonusNumber);
    }

    @Test
    void parseBonusNumber_중복보너스번호_예외발생() {
        inputView.setNextInput("7");
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String bonusNumberInput = "5";

        Integer bonusNumber = lottoService.parseBonusNumber(winningLotto, bonusNumberInput);

        assertEquals(ErrorMessage.INVALID_BONUS_NUMBER.getMessage(), outputView.getLastErrorMessage());
        assertEquals(7, bonusNumber);
    }

    @Test
    void getLotto_정확한개수의로또생성() {
        Integer lottoAmount = 3;
        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        assertEquals(3, lottos.size());

        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }

    @Test
    void haveBonusNumber_포함여부확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertTrue(lottoService.haveBonusNumber(numbers, 3));
        assertFalse(lottoService.haveBonusNumber(numbers, 7));
    }

    // TestInputView와 TestOutputView 클래스 정의
    private static class TestInputView extends InputView {
        private String nextInput;

        public void setNextInput(String input) {
            this.nextInput = input;
        }

        @Override
        public String inputCash() {
            return nextInput;
        }

        @Override
        public String inputWinningNumber() {
            return nextInput;
        }

        @Override
        public String inputBonusNumber() {
            return nextInput;
        }
    }

    private static class TestOutputView extends OutputView {
        private String lastErrorMessage;

        @Override
        public void printError(ErrorMessage errorMessage) {
            this.lastErrorMessage = errorMessage.getMessage();
        }

        public String getLastErrorMessage() {
            return lastErrorMessage;
        }
    }
}
