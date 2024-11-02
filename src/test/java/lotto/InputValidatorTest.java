package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private InputValidator inputValidator;
    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {14237, 784132, 98745, 1410})
    void 금액이_1000원으로_떨어지지_않으면_예외를_반환한다(int amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAmount(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void 금액이_0이하이면_예외를_반환한다(int amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAmount(amount);
        });
    }

    @ParameterizedTest
    @MethodSource("inputValues")
    void 당첨번호가_6개가_아니면_오류를_반환한다(List<Integer> inputValues) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateWinNumber(inputValues);
        });
    }

    static Stream<List<Integer>> inputValues() {
        return Stream.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6, 7, 10),
                List.of(7, 100)
        );
    }
}
