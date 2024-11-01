package lotto;

import lotto.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputTest {

    @Nested
    class 입력_오류_테스트 {

        private Validator validator;

        @BeforeEach
        void setUp(){
            validator = new Validator();
        }

        @DisplayName("숫자가 아닌 가격이 입력되면 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"a", ",", ";", "?", "'", ":", "ㅁ", "=", "as", " ", "\n"})
        void 숫자가_아닌_가격이_입력되면_예외처리를_한다(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validatePrice(input);
            });
        }

        @DisplayName("null 인 가격이 입력되면 예외 처리를 한다")
        @Test
        void 널인_가격이_입력되면_예외처리를_한다(){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validatePrice(null);
            });
        }

        @DisplayName("양수가 아닌 가격이 입력되면 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"-1", "0", "-999999999", "-100000000"})
        void 양수가_아닌_가격이_입력되면_예외처리를_한다(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validatePrice(input);
            });
        }

        @DisplayName("1000으로 나누어 떨어지지 않는 가격 입력시 예외 처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1", "10", "100", "1001", "987654321"})
        void 천원으로_나누어_떨어지지_않는_가격_예외(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validatePrice(input);
            });
        }
    }

}
