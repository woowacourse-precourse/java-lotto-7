package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    /**
     *
     *
     */
    @Test
    @DisplayName(" `1,2`을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split_Test_1() {
        String str = "1,2";
        String[] splitStrings = str.split(",");
        assertThat(splitStrings).contains("1","2");
    }

    @Test
    @DisplayName(" `1`을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void split_Test_2() {
        String str = "1";
        String[] splitStrings = str.split(",");
        assertThat(splitStrings).containsExactly("1");
    }

    @Test
    @DisplayName(" `containsExactly 실패 테스트 : 모든 값이 다있어야 한다.")
    void split_Error_Test_1() {
        String str = "1,2,3";
        String[] splitStrings = str.split(",");

        assertThatThrownBy(()-> {
            assertThat(splitStrings).containsExactly("1","3")
                    .isInstanceOf(AssertionError.class);
        });
    }

    @Test
    @DisplayName(" `containsExactly 실패 테스트 : 모든 값이 다있고 순서도 같아야한다")
    void split_Error_Test_2() {
        String str = "1,2,3";
        String[] splitStrings = str.split(",");

        assertThatThrownBy(()-> {
            assertThat(splitStrings).containsExactly("3","1","2")
                    .isInstanceOf(AssertionError.class);
        });
    }

    @Test
    @DisplayName(" '(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 '1,2'를 반환하도록 구현한다." )
    void substring_Test_1() {
        String str = "(1,2)";
        String[] splitStrings = str.substring(1, 4).split(",");

        assertThat(splitStrings).containsExactly("1","2");
    }

    @Test
    @DisplayName(" `abc` 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAtTest_1() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtTest_2() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(5);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtTest_3() {
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    str.charAt(5);
                });
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAtTest_3_Junit사용() {
        String str = "abc";

        org.junit.jupiter.api.Assertions.assertThrows(StringIndexOutOfBoundsException.class,()->{
            str.charAt(5);
        });
    }
}
