package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @DisplayName("타입에 따른 인풋 뷰 생성 테스트")
    @ParameterizedTest
    @CsvSource({InputView.AMOUNT + "," + InputView.AMOUNT_INPUT_REQUEST_MESSAGE,
            InputView.WINNING_NUMBER + "," + InputView.WINNING_NUMBER_INPUT_REQUEST_MESSAGE,
            InputView.BONUS_NUMBER + "," + InputView.BONUS_NUMBER_INPUT_REQUEST_MESSAGE})
    void variousTypeOfInputViewCreateTest(String input, String expectedMessage) {
        assertThat(InputView.of(input))
                .extracting("requestMessage")
                .isEqualTo(expectedMessage);
    }
}