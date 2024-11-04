package lotto.util.validationTest;

import lotto.enumValue.CommonMessage;
import lotto.validation.WinningNumberValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningNumberValidationTest {
    private final String errorMessage = CommonMessage.ERROR.getMessange();
    private final List[] exception = new ArrayList[]{
            new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
            new ArrayList<>(Arrays.asList(0, 2, 13, 45, 8, 40)),
            new ArrayList<>(Arrays.asList(46, 5, 4, 7, 23, 10)),
            new ArrayList<>(Arrays.asList(1, 1, 3, 7, 23, 10)),
            new ArrayList<>(Arrays.asList(46, 5, 4, 7, 23, 46))
    };
    private final String[] isIntegerTypeCorrect = new String[]{"1", "2", "3", "4", "5", "6"};
    private final String[] isIntegerTypeException = new String[]{"1", "a", " 3:3 ", "4", "5", "6"};

    @Test
    void 정수형_변환_정답_테스트() {
        List<Integer> result = WinningNumberValidation.isIntegerType(isIntegerTypeCorrect);
        assertEquals(result, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 정수형_변환_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinningNumberValidation.isIntegerType(isIntegerTypeException))
                .withMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void 입력값_6개_예외_테스트(int index) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinningNumberValidation.number6(exception[index]))
                .withMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void 리스트_요소_1_미만_45_초과_예외_테스트(int index) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinningNumberValidation.value1to45(exception[index]))
                .withMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void 중복_예외_테스트(int index) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> WinningNumberValidation.duplicateChecker(exception[index]))
                .withMessageContaining(errorMessage);
    }
}
