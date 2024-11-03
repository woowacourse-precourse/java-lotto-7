package console;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

    private Input input;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        input = new Input();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3", ",1,"})
    @DisplayName("String값을_IntArray로_변환할수있는지_확인한다")
    void 콤마_단위로_구분할수없는_문자열은_에러발생(String inputValue) {
        assertThatThrownBy(() -> input.changeStrToIntList(inputValue))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @DisplayName("int값이_넘어가면_에러발생_확인")
    @Test
    void int값이_넘어가면_에러발생_확인() {
        String number = "2222222222222222222222222222";
        assertThatThrownBy(() -> input.changeStrToIntList(number))
                .isInstanceOf(IllegalArgumentException.class);
    }


}