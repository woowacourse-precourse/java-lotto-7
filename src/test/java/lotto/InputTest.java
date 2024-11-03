package lotto;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputTest {

    @Nested
    class 가격_입력_오류_테스트 {

        private Validator validator;

        @BeforeEach
        void setUp(){
            validator = new PriceValidator();
        }

        @DisplayName("숫자가 아닌 가격이 입력되면 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"a", ",", ";", "?", "'", ":", "ㅁ", "=", "as", " ", "\n"})
        void 숫자가_아닌_가격이_입력되면_예외처리를_한다(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("null 인 가격이 입력되면 예외 처리를 한다")
        @Test
        void 널인_가격이_입력되면_예외처리를_한다(){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(null);
            });
        }

        @DisplayName("양수가 아닌 가격이 입력되면 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"-1", "0", "-999999999", "-100000000"})
        void 양수가_아닌_가격이_입력되면_예외처리를_한다(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("1000으로 나누어 떨어지지 않는 가격 입력시 예외 처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1", "10", "100", "1001", "987654321"})
        void 천원으로_나누어_떨어지지_않는_가격_예외(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }
    }

    @Nested
    class 당첨_번호_입력_오류_테스트{

        private Validator validator;

        @BeforeEach
        void setUp(){
            validator = new WinningNumberValidator();
        }

        @DisplayName("숫자가 아닌 당첨번호 입력시 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,a,4,5,6", ".,1,2,3,4,5", "1,2,3,4,5,:", "1,2,3,4,5,b"})
        void 숫자가_아닌_당첨번호_예외(String input){

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("비었거나 null 인 당첨번호 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {" ", "1, ,3,4,5", ""})
        void 비었거나_널_당첨번호_예외(String input){

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("콤마 외의 구분자 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {"1.2.3.4.5.6", "1:2:3:4:5:6", "1;2;3;4;5;6"})
        void 콤마_외의_구분자_예외_처리(String input){

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("범위 외의 숫자 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5", "1,2,3,-4,5,6"})
        void 범위_외의_숫자_예외(String input){

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("6개 미만의 당첨 번호")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,3,4,5", "", " ", "1", "1,2,3"})
        void 당첨_번호_기준_미만(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }
    }

    @Nested
    class 보너스_숫자_예외_테스트{

        private Validator validator;

        @BeforeEach
        void setUp(){
            this.validator = new BonusNumberValidator();
        }

        @DisplayName("비어있는 경우 예외")
        @ParameterizedTest()
        @ValueSource(strings = {" ", ""})
        void 비어있는_보너스_숫자_예외(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("null 인 경우 예외")
        @Test
        void 널_보너스_숫자_예외(){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(null);
            });
        }

        @DisplayName("숫자가 아닌경우 예외")
        @ParameterizedTest()
        @ValueSource(strings = {"a","aa"," ", "a b", ":", ","})
        void 숫자가_아닌_보너스_숫자(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }

        @DisplayName("범위를 벗어난 숫자 예외")
        @ParameterizedTest()
        @ValueSource(strings = {"-1", "-999999999", "0", "46","9999999999"})
        void 범위를_벗어난_숫자_예외(String input){
            assertThrows(IllegalArgumentException.class, () -> {
                validator.validate(input);
            });
        }
    }
}
