package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputControllerLoopTest extends NsTest {
    private static final String NOT_INTEGER = "[ERROR] 정수가 아니거나 처리할 수 없는 범위의 정수를 입력 받았습니다.";
    private static final String NOT_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1,000이상 100,000이하여의 정수여야 합니다.";
    private static final String NOT_ROUND_THOUSAND = "[ERROR] 로또 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String NOT_LOTTO_NUMBER = "[ERROR] 로또 번호는 1이상 45이하여야 합니다.";
    private static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 입력받은 당첨 번호에 이미 포함된 수입니다.";
    private static final String NOT_SIX_NUMBERS = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    InputController inputController = InputController.getInstance();

    @Test
    @DisplayName("유효한 입력을 받을 때까지 반복 테스트")
    void inputController_loopInputTest() {
        run("a", "-1", "3500", "1000",
                "1,2,3", "1,2,3,4,5,5", "1,2,3,4,5,60", "1,2,3,4,5,6",
                "3", "7");
        assertThat(output()).contains(
                NOT_INTEGER,
                NOT_PURCHASE_AMOUNT,
                NOT_ROUND_THOUSAND,
                NOT_SIX_NUMBERS,
                DUPLICATE_LOTTO_NUMBER,
                NOT_LOTTO_NUMBER,
                DUPLICATE_BONUS_NUMBER)
        ;
    }

    @Override
    protected void runMain() {
        inputController.inputPurchaseAmount();
        Lotto sampleLotto = inputController.inputLotto();
        inputController.inputBonus(sampleLotto);
    }
}
