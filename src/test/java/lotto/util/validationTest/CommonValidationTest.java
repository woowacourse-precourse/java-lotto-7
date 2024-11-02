package lotto.util.validationTest;

import lotto.enumValue.CommonMessage;
import lotto.validation.CommonValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonValidationTest {
    private final String errorMessage = CommonMessage.ERROR.getMessange();
    private final String[] exceptionValues = new String[]{"", "a", ":", "3.4"};
    private final String[] correctValues = new String[]{" 1,2,3 ", "5"};
    private final int[] exceptionValues1to45 = new int[]{0, -1, 46, 100};

    @Test
    void 공백_입력_정답_케이스() {
        String result = CommonValidation.isEmpty(correctValues[0]);
        assertEquals(result, "1,2,3");
    }

    @Test
    void 공백_입력_예외_케이스() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CommonValidation.isEmpty(exceptionValues[0]))
                .withMessageContaining(errorMessage);
    }

    @Test
    void 정수_변환_정답_케이스() {
        int result = CommonValidation.isIntegerType(correctValues[1]);
        assertEquals(result, 5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 정수_변환_예외_케이스(int index) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CommonValidation.isIntegerType(exceptionValues[index]))
                .withMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 범위_예외_케이스(int index) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CommonValidation.value1to45(exceptionValues1to45[index]))
                .withMessageContaining(errorMessage);
    }

}
