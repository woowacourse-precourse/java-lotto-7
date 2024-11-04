package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewFactoryTest {

    @DisplayName("타입에 따른 인풋 뷰 생성 테스트")
    @ParameterizedTest
    @CsvSource({InputViewFactory.AMOUNT + "," + InputViewFactory.AMOUNT_INPUT_REQUEST_MESSAGE,
            InputViewFactory.WINNING_NUMBER + "," + InputViewFactory.WINNING_NUMBER_INPUT_REQUEST_MESSAGE,
            InputViewFactory.BONUS_NUMBER + "," + InputViewFactory.BONUS_NUMBER_INPUT_REQUEST_MESSAGE})
    void variousTypeOfInputViewFactoryCreateTest(String input, String expectedMessage) {
        assertThat(InputViewFactory.createInputViewOf(input))
                .extracting("requestMessage")
                .isEqualTo(expectedMessage);
    }
}