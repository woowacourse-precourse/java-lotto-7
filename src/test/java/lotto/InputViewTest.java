package lotto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testInputPurchaseAmount_ValidInput() {
        // Given
        String validInput = "10000";
        setInput(validInput); // 입력값 설정

        // When
        String result = inputView.inputPurchaseAmount();

        // Then
        assertEquals(validInput, result);
    }

    @Test
    public void testInputPurchaseAmount_InvalidInput() {
        // Given
        String invalidInput = "invalid\n10000"; // 잘못된 입력 후 올바른 입력
        setInput(invalidInput);

        // When
        String result = inputView.inputPurchaseAmount();

        // Then
        assertEquals("10000", result); // 두 번째 입력이 반환되어야 함
    }

    @Test
    public void testInputWinningLotto_ValidInput() {
        // Given
        String validInput = "1,2,3,4,5,6";
        setInput(validInput); // 입력값 설정

        // When
        String[] result = inputView.inputWinningLotto();

        // Then
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);
    }

    @Test
    public void testInputWinningLotto_InvalidInput() {
        // Given
        String invalidInput = "1,2,3,4,5\n1,2,3,4,5,6"; // 잘못된 입력 후 올바른 입력
        setInput(invalidInput);

        // When
        String[] result = inputView.inputWinningLotto();

        // Then
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);
    }

    @Test
    public void testInputBonusNumber_ValidInput() {
        // Given
        String validInput = "7";
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        setInput(validInput); // 입력값 설정

        // When
        String result = inputView.inputBonusNumber(winningNumbers);

        // Then
        assertEquals(validInput, result);
    }

    @Test
    public void testInputBonusNumber_DuplicateInput() {
        // Given
        String invalidInput = "1\n7"; // 중복된 번호 후 올바른 번호
        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        setInput(invalidInput); // 입력값 설정

        // When
        String result = inputView.inputBonusNumber(winningNumbers);

        // Then
        assertEquals("7", result); // 두 번째 입력이 반환되어야 함
    }
}
