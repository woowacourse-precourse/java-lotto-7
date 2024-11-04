package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewFactoryTest {

    @DisplayName("타입에 따른 인풋 뷰 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateTypeCase")
    void variousTypeOfInputViewFactoryCreateTest(InputViewType input, String expectedMessage) {
        assertThat(InputViewFactory.createInputViewOf(input))
                .extracting("requestMessage")
                .isEqualTo(expectedMessage);
    }

    static Stream<Arguments> generateTypeCase() {
        return Stream.of(
                Arguments.of(InputViewType.AMOUNT, InputViewFactory.AMOUNT_INPUT_REQUEST_MESSAGE),
                Arguments.of(InputViewType.WINNING_NUMBER, InputViewFactory.WINNING_NUMBER_INPUT_REQUEST_MESSAGE),
                Arguments.of(InputViewType.BONUS_NUMBER, InputViewFactory.BONUS_NUMBER_INPUT_REQUEST_MESSAGE)
        );
    }
}