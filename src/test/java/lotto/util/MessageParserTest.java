package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MessageParserTest {

    @Test
    void parseLong_기능_테스트() {
        assertThat(MessageParser.getErrorMessage("에러입니다.")).isEqualTo("[ERROR] 에러입니다.");
    }

    @Test
    void getComma_기능_테스트() {
        assertThat(MessageParser.getComma(1234567)).isEqualTo("1,234,567");
        assertThat(MessageParser.getComma(1234567890000L)).isEqualTo("1,234,567,890,000");
    }
}
