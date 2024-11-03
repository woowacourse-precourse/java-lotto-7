package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputControllerLottoTest extends NsTest {
    private static final String NOT_INTEGER = "[ERROR] 정수가 아니거나 처리할 수 없는 범위의 정수를 입력 받았습니다.";
    private static final String NOT_LOTTO_NUMBER = "[ERROR] 로또 번호는 1이상 45이하여야 합니다.";
    private static final String NOT_SIX_NUMBERS = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";


    InputController inputController = InputController.getInstance();

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("invalidLotto")
    @DisplayName("유효하지 않은 당첨 번호 테스트")
    void inputController_invalidInputTest(String lottoString, String message, String errorMessage) {

        runException(lottoString);
        assertThat(output()).contains(errorMessage);
    }

    static Stream<Arguments> invalidLotto() {
        return Stream.of(
                Arguments.of("a,4,5", "정수가 아닌 입력", NOT_INTEGER),
                Arguments.of("1", "6개보다 적은 수 입력 1", NOT_SIX_NUMBERS),
                Arguments.of("1,2,3", "6보다 적은 수 입력 2", NOT_SIX_NUMBERS),
                Arguments.of("1,2,3,4,5,6,7", "6개 많은 수 입력", NOT_SIX_NUMBERS),
                Arguments.of("1,2,3,4,5,5", "중복된 수 입력", DUPLICATE_LOTTO_NUMBER),
                Arguments.of("0,2,3,4,5,6", "로또 번호 범위를 벗어나는 수 입력 1", NOT_LOTTO_NUMBER),
                Arguments.of("1,2,3,4,5,60", "로또 번호 범위를 벗어나는 수 입력 2", NOT_LOTTO_NUMBER),
                Arguments.of("\n", "공백 입력", NOT_INTEGER)
        );
    }

    @Override
    protected void runMain() {
        inputController.inputLotto();
    }
}
