package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.app.Application;
import lotto.util.InputValidator;
import lotto.view.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputHandlerTest extends NsTest {
    private InputValidator inputValidator;
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
        inputHandler = new InputHandler(inputValidator);
    }

    @Test
    void getPurchaseAmount_shouldReturnParsedInteger() {
        String validAmount = "5000";
        mockConsoleInput(validAmount);

        int purchaseAmount = inputHandler.getPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(5000);
    }

    @Test
    void getPurchaseAmount_shouldThrowExceptionForInvalidAmount() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains("[ERROR] 입력값이 숫자 형식이 아닙니다.");
        });
    }

    @Test
    void getWinningNums_shouldReturnParsedListOfIntegers() {
        String validWinningNums = "1, 2, 3, 4, 5, 6";
        mockConsoleInput(validWinningNums);

        List<Integer> winningNums = inputHandler.getWinningNums();
        assertThat(winningNums).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void getWinningNums_shouldThrowExceptionForOutOfRangeNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 46");
            assertThat(output()).contains("[ERROR] 로또 번호는 1 ~ 45 사이의 번호이어야 합니다.");
        });
    }

    @Test
    void getBonusNum_shouldReturnParsedInteger() {
        String validBonusNum = "7";
        mockConsoleInput(validBonusNum);

        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);

        int bonusNum = inputHandler.getBonusNum(winningNums);
        assertThat(bonusNum).isEqualTo(7);
    }

    @Test
    void getBonusNum_shouldThrowExceptionForBonusInWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    private void mockConsoleInput(String input) {
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});;
    }
}
