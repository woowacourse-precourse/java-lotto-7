package lotto.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitComma(String string){
        String[] splitResult = string.split(",");
        assertThat(splitResult).contains("1","2");
    }

    @Test
    void splitCommaWhenTheStringEndsWithComma(){
        String testString = "1,";
        String[] splitResult = testString.split(",");
        assertThat(splitResult).containsExactly("1");
    }

    String eliminateParenthesis(String string){
        return string.substring(1, string.length()-1);
    }

    @Test
    void eliminateParenthesisTest(){
        String testString = "(1,2)";
        String result = eliminateParenthesis(testString);
        assertThat(result).isEqualTo("1,2");
    }

    Character getCharacterFromString(String string, int index){
        if(index<0 || index>=string.length()){
            throw new StringIndexOutOfBoundsException("Index: " + index + ", Size: " + string.length());
        }
        return string.charAt(index);
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져온다")
    void getCharacterFromStringTest(){
        String testString = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    Character characterFromString = getCharacterFromString(testString, 4);
                })
                .withMessageMatching("Index: \\d+, Size: \\d+");
    }

}
