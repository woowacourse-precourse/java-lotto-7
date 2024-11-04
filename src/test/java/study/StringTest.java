package study;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JFormattedTextField;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"를 ,로 split했을때 잘 분리 되는지 확인하기 ")
    void 기능_테스트1(){
        String input = "1,2";

        String[] result = input.split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\" ,로 split 했을 때, 1만 포함하는 배열이 반되는지 ..")
    void 기능_테스트2(){
        String input = "1";

        String[] result = input.split(",");
        Assertions.assertThat(result).containsExactly("1");
    }

    @Test
    void 기능_테스트3(){
        String input = "1,2";

        String[] result = input.split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을때 괄호 제거하고 1,2만 반환하기")
    void 기능_테스트4(){
        String input = "(1,2)";
        String newInput = input.substring(1,input.length()-1);
        // String은 불변이기 때문에 !! 불변인 이유 ! 문자열 풀을 사용하기 때문에

        Assertions.assertThat(newInput).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메서드를 통해 특정 위치의 문자열을 가져온다. 위치값을 벗어났을때 에러가 떠야함")
    void 기능_테스트5(){
        String str = "hi";
        Assertions.assertThatThrownBy(()-> {
            str.charAt(2);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index 2 out of bounds for length 2");
    }



}
