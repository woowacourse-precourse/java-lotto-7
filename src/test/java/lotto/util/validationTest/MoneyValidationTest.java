package lotto.util.validationTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.enumValue.CommonMessage;
import lotto.util.Input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyValidationTest extends NsTest {
    private final String[] DATA_SET_CORRECT = {"8000", "1000"};
    private final String[] DATA_SET_WRONG = {
            "300\n3000", "1100\n3000", // 1000 으로 나누어 떨어지지 않는 경우
            "\n3000", // 공백 입력
            "8000.5\n3000", // 실수 입력
            "a\n3000", // 문자 입력
            "0\n3000", // 0 입력
            "-3\n3000" // 음수 입력
    };

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void money_ticket_정답_케이스(int index) {
        assertSimpleTest(() -> {
            run(DATA_SET_CORRECT[index]);
            assertThat(output()).contains(CommonMessage.SUCCESS_TEST_MONEY_TICKET.getMessange());
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void money_ticket_예외_케이스(int index) {
        run(DATA_SET_WRONG[index]);
        assertThat(output()).contains(CommonMessage.ERROR.getMessange());
    }

    @Override
    public void runMain() {
        Input.moneyTicket();
    }
}
