package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @DisplayName("priceToLottoCount_메서드_테스트_01")
    @Test
    void 기능_테스트() {
        String input = "11000";
        int expected = 11;

        assertThat(Counter.priceToLottoCount(input)).isEqualTo(expected);
    }
}
