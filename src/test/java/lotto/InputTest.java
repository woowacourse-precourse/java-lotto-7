package lotto;

import lotto.parser.WinningNumberParser;
import lotto.validator.PriceValidator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputTest {

    @Nested
    class 가격_입력_오류_테스트 {

        private PriceValidator validator;

        @BeforeEach
        void setUp(){
            validator = new PriceValidator();
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

    @Nested
    class 당첨_번호_입력_오류_테스트{

        private WinningNumberValidator validator;

        @BeforeEach
        void setUp(){
            validator = new WinningNumberValidator();
        }

        @DisplayName("숫자가 아닌 당첨번호 입력시 예외처리를 한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,a,4,5,6", ".,1,2,3,4,5", "1,2,3,4,5,:", "1,,2,3,4,5,6"})
        void 숫자가_아닌_당첨번호_예외(String input){

            WinningNumberParser parser = new WinningNumberParser();
            List<String> parsedInput = parser.parseWinningNumber(input);

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateWinningNumber(parsedInput);
            });
        }

        @DisplayName("비었거나 null 인 당첨번호 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {" ", "1, ,3,4,5", ""})
        void 비었거나_널_당첨번호_예외(String input){
            WinningNumberParser parser = new WinningNumberParser();
            List<String> parsedInput = parser.parseWinningNumber(input);

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateWinningNumber(parsedInput);
            });
        }

        @DisplayName("콤마 외의 구분자 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {"1.2.3.4.5.6", "1:2:3:4:5:6", "1;2;3;4;5;6"})
        void 콤마_외의_구분자_예외_처리(String input){
            WinningNumberParser parser = new WinningNumberParser();
            List<String> parsedInput = parser.parseWinningNumber(input);

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateWinningNumber(parsedInput);
            });
        }

        @DisplayName("범위 외의 숫자 예외 처리")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5", "1,2,3,-4,5,6"})
        void 범위_외의_숫자_예외(String input){
            WinningNumberParser parser = new WinningNumberParser();
            List<String> parsedInput = parser.parseWinningNumber(input);

            assertThrows(IllegalArgumentException.class, () -> {
                validator.validateWinningNumber(parsedInput);
            });
        }
    }

    @Nested
    class 당첨_번호_파싱_테스트{
        private WinningNumberParser parser;

        @BeforeEach
        void setUp(){
            parser = new WinningNumberParser();
        }

        @DisplayName("콤마를 기준으로 입력을 파싱한다")
        @ParameterizedTest()
        @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,6,", "1 ,2 ,3,4, 5, 6            ,"})
        void 당첨번호_콤마기준_파싱(String input){
            List<String> parsedInput = parser.parseWinningNumber(input);
            assertThat(parsedInput).containsExactly("1","2","3","4","5","6");
        }
    }



}
