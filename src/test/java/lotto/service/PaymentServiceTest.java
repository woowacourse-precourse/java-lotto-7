package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentServiceTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("금액을 입력하면 1000원 당 한장의 로또 개수로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "3000:3", "8000:8"}, delimiter = ':')
    void buyLotto(String inputMoney, int lottoCnt) {
        // when & then
        assertSimpleTest(
                () -> {
                    run(inputMoney);
                    assertThat(output()).isEqualTo(
                            "구입금액을 입력해 주세요.\n"
                            + lottoCnt);
                }
        );
    }

    @DisplayName("금액 0 을 입력하면 예외가 발생한다.")
    @Test
    void initZero() {
        // given
        String inputMoney = "0";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputMoney);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("금액으로 음수를 입력하면 예외가 발생한다.")
    @Test
    void initNegative() {
        // given
        String inputMoney = "-1000";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputMoney);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("1000 단위의 금액이 아닌 수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "500", "2500"})
    void validateThousandUnitAmount(String inputMoney) {
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputMoney);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        PaymentService service = new PaymentService();
        System.out.println(service.buyLotto());
    }
}