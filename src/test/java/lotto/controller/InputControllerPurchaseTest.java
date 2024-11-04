package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputControllerPurchaseTest extends NsTest {
    private static final String NOT_INTEGER = "[ERROR] 정수가 아니거나 처리할 수 없는 범위의 정수를 입력 받았습니다.";
    private static final String NOT_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1,000이상 100,000이하여의 정수여야 합니다.";
    private static final String NOT_ROUND_THOUSAND = "[ERROR] 로또 구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    InputController inputController = InputController.getInstance();

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidPurchase")
    @DisplayName("유효하지 않은 구입 금액 테스트")
    void inputController_invalidPurchaseTest(String purchaseAmount, String message, String errorMessage) {

        runException(purchaseAmount);
        assertThat(output()).contains(errorMessage);
    }

    static Stream<Arguments> invalidPurchase() {
        return Stream.of(
                Arguments.of("a", "정수가 아닌 입력", NOT_INTEGER),
                Arguments.of("-500", "구입 금액의 범위에 벗어나는 입력 ", NOT_PURCHASE_AMOUNT),
                Arguments.of("3500", "구입 금액이 1000으로 나누어 떨어지지 않음", NOT_ROUND_THOUSAND),
                Arguments.of("\n", "공백 입력", NOT_INTEGER)
        );
    }

    @Override
    protected void runMain() {
        inputController.inputPurchaseAmount();
    }
}
