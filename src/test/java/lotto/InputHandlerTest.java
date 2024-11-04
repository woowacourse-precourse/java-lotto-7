package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @Test
    void 정수변형테스트1() {
        String[] testValue = {"12", "23", "34"};
        List<Integer> correctResult = new ArrayList<>(Arrays.asList(12,23,34));
        InputHandler inputHandler = new InputHandler();
        List<Integer> result = inputHandler.integerInverter(testValue);
        assertEquals(result,correctResult);
    }

    @Test
    void 정수변형테스트2() {
        String[] testValue = {"12", "23", "a"};
        assertThatThrownBy(() -> new InputHandler().integerInverter(testValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}