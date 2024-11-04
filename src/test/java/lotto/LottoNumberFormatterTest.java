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

    @DisplayName("보너스 번호 String에서 int로 형변환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"7"})
    void converToBoolTest(String input) {
        int result = lottoNumberFormatter.convertToBonusNum(input);
        assertEquals(7, result);
    }

    @DisplayName("보너스 번호 String에서 int로 형변환할 때 숫자 이외의 입력일 시의 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"bonus"})
    void converToBoolExceptionTest(String input) {
        assertThatThrownBy(() -> lottoNumberFormatter.convertToBonusNum(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨 번호가 6개가 아닐 경우")
    @ParameterizedTest
    @MethodSource("validateWinningNumsException")
    void validateWinningNumsExceptionTest(String[] inputNums) {
        assertThatThrownBy(() -> lottoNumberFormatter.validateWinningNums(inputNums)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }


    public static Stream<Arguments> validateWinningNumsException() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"})
        );
    }

    @DisplayName("당첨 번호와 보너스 번호가 겹칠 경우")
    @ParameterizedTest
    @MethodSource("hasDuplicateNumException")
    void hasDuplicateNumExceptionTest(List<Integer> winningNums, int bonusNum) {
        assertThatThrownBy(() -> lottoNumberFormatter.hasDuplicateNum(winningNums, bonusNum)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    public static Stream<Arguments> hasDuplicateNumException() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 1, 2, 3, 4, 5), 7)
        );
    }

    @DisplayName("로또 번호가 1~45 사이의 범위 외의 숫자일 경우")
    @ParameterizedTest
    @ValueSource(ints = {48, 0, -1})
    void outOfBoundsExceptionTest(int bonus) {
        assertThatThrownBy(() -> lottoNumberFormatter.outOfBounds(bonus)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
