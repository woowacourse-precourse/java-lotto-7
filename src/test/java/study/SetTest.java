package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1
     */
    @Test
    @DisplayName("Set의 크기 확인")
    void Set의_크기_확인() {
        assertThat(numbers).size().isEqualTo(3);
    }

    /**
     * 요구사항 2
     */
    @ParameterizedTest
    @DisplayName("Set에 값이 들어갔는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void Set에_값이_들어갔는지_확인(int input) {
        assertTrue(numbers.contains(input));
    }

    /**
     * 요구사항 3
     */
    @ParameterizedTest
    @DisplayName("Set에 값이 들어갔는지 확인 - false 포함")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void Set에_값이_들어갔는지_확인_false포함(Integer input, Boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}


package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    /**
     * 요구사항 1
     */
    @Test
    void 쉼표를_기준으로_문자열_나누기() {
        String str = "1,2";
        String[] results = str.split(",");
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    void 쉼표를_기준으로_문자열_나누기_원소_한_개() {
        String str = "1";
        String[] results = str.split(",");
        assertThat(results).containsExactly("1");
    }

    /**
     * 요구사항 2
     */
    @Test
    void 문자열_앞뒤_자르기() {
        String str = "(1,2)";
        str = str.substring(1, str.length() - 1);
        assertThat(str).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     */
    @Test
    @DisplayName("String의 첫번째 문자를 가져온다.")
    void 첫번째_위치의_문자_가져오기() {
        String str = "abc";
        char ch = str.charAt(0);
        assertThat(ch).isEqualTo('a');
    }

    @Test
    @DisplayName("String의 마지막 문자를 가져온다.")
    void 마지막_위치의_문자_가져오기() {
        String str = "abc";
        char ch = str.charAt(str.length() - 1);
        assertThat(ch).isEqualTo('c');
    }

//    @Test
//    @DisplayName("String의 잘못된 인덱스에 접근하면 StringIndexOutOfBoundsException 예외가 발생한다.")
//    void charAt_인덱스_예외_테스트() {
//        assertThatThrownBy(() -> {
//            String str = "abc";
//            char ch = str.charAt(str.length());
//        }).isInstanceOf(StringIndexOutOfBoundsException.class);
//    }

    // assertThatExceptionOfType는 특정 예외가 발생하는지 확인하는지 판단하고자 하는 의도를 더 명확히 드러낸다.
    @DisplayName("String의 잘못된 인덱스에 접근하면 StringIndexOutOfBoundsException 예외가 발생한다.")
    void charAt_인덱스_예외_테스트() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                            String str = "abc";
                            char ch = str.charAt(str.length());
                        }
                );
    }
}
