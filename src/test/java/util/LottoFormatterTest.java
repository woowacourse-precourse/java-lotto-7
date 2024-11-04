package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFormatterTest {

    @DisplayName("로또 번호 출력 테스트")
    @Test
    void formatLottoTest() {
        List<Integer> numbers = Arrays.asList(8, 21, 23, 41, 42, 43);
        String formattedLotto = LottoFormatter.formatLotto(numbers);

        assertThat(formattedLotto).isEqualTo("[8, 21, 23, 41, 42, 43]");
    }
}