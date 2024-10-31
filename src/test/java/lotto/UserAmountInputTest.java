package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.input.UserAmountInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserAmountInputTest {

    @DisplayName("기능 테스트")
    @Test
    void 기능_테스트() {
        InputStream originalIn = System.in;

        try {
            String simulatedInput = "30,000\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            UserAmountInput userAmountInput = new UserAmountInput();
            int amount = userAmountInput.validation();

            assertEquals(30000, amount);
        } finally {
            System.setIn(originalIn);
        }
    }
}
