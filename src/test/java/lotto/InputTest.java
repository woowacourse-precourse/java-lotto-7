package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.parser.InputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @DisplayName("금액 입력 테스트")
    @Test
    void 입력_테스트() {
        String input = "13000";

        int expectedAmount = 13000;
        int actualAmount = inputParser.purchaseAmountToInt(input);

        assertEquals(expectedAmount, actualAmount, "입력 금액이 제대로 변환되지 않았습니다.");
    }

    @DisplayName("당첨 번호 입력 테스트")
    @Test
    void 테스트_1() {
        String input = "1,2,3,4,5,6";

        List<Integer> expectedWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actualWinningNumbers = inputParser.winNumList(input);

        assertEquals(expectedWinningNumbers, actualWinningNumbers, "당첨 번호가 제대로 변환되지 않았습니다.");
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void 테스트_2() {
        String bonusNum = "5";
        int expectedBonusNumber = 5;

        int actualBonusNumber = inputParser.inputWinningBonusNumber(bonusNum);

        assertEquals(expectedBonusNumber, actualBonusNumber, "보너스 번호가 제대로 변환되지 않았습니다.");
    }
}
