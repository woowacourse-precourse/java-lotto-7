package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.validator.NumberValidator;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateWinningNumberTest {

    @Test
    @DisplayName("당첨 번호를 입력받으면 List로 만드는지 테스트한다.")
    void createWinningNumberTest() {
        String inputWinningNumber = "1, 2, 3, 4, 5, 6";

        List<Integer> winningNumber = CreateWinningNumber.create(inputWinningNumber);

        assertThat(winningNumber).hasSize(6);
    }
}