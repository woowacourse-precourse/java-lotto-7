package lotto.domain.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Nested
    @DisplayName("사용자에게 입력을 받으면")
    class WhenInputFromUser {

        @ParameterizedTest
        @ValueSource(strings = {"8000"})
        @DisplayName("숫자일 시 해당 금액을 반환해야 한다.")
        void getUserPurchaseAmount(String input) {
            //given
            setUserInput(input);

            //when
            int amount = inputView.getUserPurchaseAmount();

            //then
            assertEquals(Integer.parseInt(input), amount);
        }

    }

    private static void setUserInput(String testInput) {
        System.setIn(new ByteArrayInputStream((testInput + "\n").getBytes()));
    }
}