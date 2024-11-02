package lotto;

import lotto.util.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    void divideByThousand_예외_메시지_테스트_숫자만_입력() {
        Parser parser = new Parser();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            parser.stringToInt("abc");
        });

        Assertions.assertEquals("[ERROR] 숫자만 입력해 주세요.", exception.getMessage());
    }
}
