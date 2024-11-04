package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void removeSpace_문자열_공백제거() {
        String input = "  Hello World  ";
        String result = Parser.removeSpace(input);
        assertThat(result).isEqualTo("Hello World");
    }

    @Test
    void removeSpace_공백만_포함된_문자열() {
        String input = "   ";
        String result = Parser.removeSpace(input);
        assertThat(result).isEqualTo("");
    }

    @Test
    void convertStrToInt_유효한_숫자문자열_정수변환() {
        String input = "123";
        int result = Parser.convertStrToInt(input);
        assertThat(result).isEqualTo(123);
    }

    @Test
    void convertStrToInt_공백제거_후_정수변환() {
        String input = " 456 ";
        int result = Parser.convertStrToInt(input);
        assertThat(result).isEqualTo(456);
    }

}