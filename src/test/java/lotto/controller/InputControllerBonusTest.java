package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputControllerBonusTest extends NsTest {
    private static final String NOT_INTEGER = "[ERROR] 정수가 아니거나 처리할 수 없는 범위의 정수를 입력 받았습니다.";
    private static final String NOT_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1,000이상 100,000이하여의 정수여야 합니다.";
    private static final String NOT_ROUND_THOUSAND = "[ERROR] 로또 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String NOT_LOTTO_NUMBER = "[ERROR] 로또 번호는 1이상 45이하여야 합니다.";
    private static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 입력받은 당첨 번호에 이미 포함된 수입니다.";
    private static final String NOT_SIX_NUMBERS = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final Lotto VALID_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));


    InputController inputController = InputController.getInstance();

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidBonus")
    @DisplayName("유효하지 않은 보너스 번호 테스트")
    void inputController_invalidInputTest(String lottoString, String message, String errorMessage) {

        runException(lottoString);
        assertThat(output()).contains(errorMessage);
    }

    static Stream<Arguments> invalidBonus() {
        return Stream.of(
                Arguments.of("a", "정수가 아닌 입력", NOT_INTEGER),
                Arguments.of("-2", "보너스 번호 범위에 벗어나는 입력 1", NOT_LOTTO_NUMBER),
                Arguments.of("50", "보너스 번호 범위에 벗어나는 입력 2", NOT_LOTTO_NUMBER),
                Arguments.of("3", "이미 입력한 당첨 번호와 중복되는 수 입력", DUPLICATE_BONUS_NUMBER),
                Arguments.of("\n", "공백 입력", NOT_INTEGER)
        );
    }

    @Override
    protected void runMain() {
        inputController.inputBonus(VALID_LOTTO);
    }
}
