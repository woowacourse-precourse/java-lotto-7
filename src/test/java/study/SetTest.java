package study;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void 기능_테스트1(){
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void 기능_테스트2(){
        Assertions.assertThat(numbers).contains(1);
        Assertions.assertThat(numbers).contains(2);
        Assertions.assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 기능_테스트2_1(int arguments){
        Assertions.assertThat(numbers.contains(arguments)).isTrue();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    void 기능_테스트_2_2(String arguments){
        Set<String> set = new HashSet<>();
        set.add(arguments);

        Assertions.assertThat(set).contains(arguments);
    }

}
