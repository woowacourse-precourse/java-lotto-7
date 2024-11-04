package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberFormatterTest {
    private LottoNumberFormatter lottoNumberFormatter;

    @BeforeEach
    void setUp() {
        lottoNumberFormatter = new LottoNumberFormatter();
    }


    @DisplayName("String 입력을 ,로 나누는 메서드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void splitInputTest(String input) {
        List<Integer> splits = lottoNumberFormatter.splitInput(input);

        assertEquals(6, splits.size());
    }
}
