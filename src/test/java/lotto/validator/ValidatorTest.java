package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 구입_금액_검증_테스트() {
        String moneyAmount = "10000";
        boolean result = validator.validateMoneyAmount(moneyAmount);
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 구입_금액_검증_예외_테스트() {
        String moneyAmount = "999";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean result = validator.validateMoneyAmount(moneyAmount);

        Assertions.assertThat(result).isEqualTo(false);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("[ERROR] 최소 구매 금액은 1000원부터 입니다.");
    }
}