package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.input.UserLottoNumberInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserLottoNumberInputTest {

    @DisplayName("기능 테스트")
    @Test
    void 기능_테스트() {
        InputStream originalIn = System.in;
        try {
            String simulatedInput = "1,2,3,4,5,6";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            UserLottoNumberInput userLottoNumberInput = new UserLottoNumberInput();
            Lotto lotto = userLottoNumberInput.validation();

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            assertEquals(numbers, lotto.getNumbers());
        } finally {
            System.setIn(originalIn);
        }
    }
}
