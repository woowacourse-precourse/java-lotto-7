package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.message.InputMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    // 요구사항 1
    @Test
    @DisplayName("\"1, 2\"을 ,로 split했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    public void testSplitNumbersTest() {
        // given
        String numbers = "1,2";

        // when
        String[] number = numbers.split(",");

        // then
        assertThat(number).contains("1", "2");
    }

}
