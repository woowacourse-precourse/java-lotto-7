package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberFormatterTest {
    private LottoNumberFormatter lottoNumberFormatter;

    @BeforeEach
    void setUp() {
        lottoNumberFormatter = new LottoNumberFormatter();
    }

    @DisplayName("당첨 번호 String 입력을 ','로 나누는 메서드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void splitInputTest(String input) {
        List<Integer> splits = lottoNumberFormatter.splitInput(input);

        assertEquals(6, splits.size());
    }

    @DisplayName("당첨 번호 String 입력을 ', '로 나누는 메서드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void splitInputTest2(String input) {
        List<Integer> splits = lottoNumberFormatter.splitInput(input);

        assertEquals(6, splits.size());
    }

    @DisplayName("당첨 번호 String에서 int로 형변환하는 메서드")
    @ParameterizedTest
    @MethodSource("convertToNums")
    void convertToNumsTest(String[] inputNums) {
        List<Integer> result = lottoNumberFormatter.convertToNums(inputNums);
        assertEquals("[1, 2, 3, 4, 5, 6]", result.toString());
    }

    public static Stream<Arguments> convertToNums() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"})
        );
    }

    @DisplayName("당첨 번호 String에서 int로 형변환하는데 숫자 이외의 값 입력")
    @ParameterizedTest
    @MethodSource("convertToNumsException")
    void conerToNumsExceptionTest(String[] inputNums) {
        assertThatThrownBy(() -> lottoNumberFormatter.convertToNums(inputNums))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    public static Stream<Arguments> convertToNumsException() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "exception", "5", "6"})
        );
    }
}
