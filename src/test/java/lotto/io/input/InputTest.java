package lotto.io.input;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @AfterEach
    void close() {
        Input.close();
    }

    @Test
    @DisplayName("당첨 번호를 입력 할 시 ,를 기준으로 구분")
    void getWinningNumbersInput() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);

        // when
        List<Integer> winningNumbers = Input.getWinningNumbersInput();

        // then
        Assertions.assertEquals(winningNumbers, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("구입 가격은 1000원으로 나누어진다.")
    void getPriceInput() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("3000".getBytes());
        System.setIn(in);

        // when
        int priceInput = Input.getPriceInput();

        // then
        Assertions.assertEquals(priceInput, 3000);
    }

    @Test
    @DisplayName("입력이 숫자가 아니라면 예외가 발생한다.")
    void validateIsNumber() {
        // given
        String number = "abc123";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateIsNumber(number);
        });
    }

    @Test
    @DisplayName("입력이 되지 않은 경우 예외가 발생한다.")
    void hasInput() {
        // given
        String input = null;

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> InputValidator.hasInput(input));
    }
}