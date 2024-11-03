package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @DisplayName("priceToLottoCount_메서드_테스트_01")
    @Test
    void 기능_테스트() {
        String input = "11000";
        int expected = 11;

        assertThat(Converter.priceToLottoCount(input)).isEqualTo(expected);
    }

    @DisplayName("StringToLottoNumbers_메서드_테스트_01")
    @Test
    void stringToLottoNumbers_기능_테스트() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(Converter.StringToLottoNumbers(input)).isEqualTo(expected);
    }
}
