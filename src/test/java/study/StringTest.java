package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {


    /**
     * "1,2"을 ,로 split했을때 1과 2로 잘분리되는 지 확인하는 학습테스트 구현
     *  "1"을 ,로 split했을때 1만 포함하는 배열이 반환되는지에 대한 학습테스트 구현
     */


    @Test
    void split테스트(){
        String value = "1,2";
        String[] split = value.split(",");
        assertThat(split).contains("1", "2");
    }


    @Test
    void split단위테스트(){
        String value = "1";
        String[] split = value.split(",");
        assertThat(split).containsExactly("1");
    }


    @Test
    void substring테스트(){
        String value = "(1,2)";
        String result = value.substring(1,4);
        assertThat(result).contains("1,2");
    }


    private final String str = "abc";

    @Test
    @DisplayName("charAt() 메소드를 사용하여 특정 위치의 문자를 가져온다.")
    void testGetCharAt() {
        assertEquals('a', str.charAt(0));
        assertEquals('b', str.charAt(1));
        assertEquals('c', str.charAt(2));
    }

    @Test
    @DisplayName("charAt() 메소드에 유효하지 않은 위치 값을 전달하면 StringIndexOutOfBoundsException이 발생한다.")
    void testInvalidIndex() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(3));
        assertThrows(StringIndexOutOfBoundsException.class, () -> str.charAt(-1));
    }





}
