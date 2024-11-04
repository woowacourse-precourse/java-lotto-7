package study;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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


    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    /**
     * 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려고 한다.
     * 다음 중복 코드를 ParameterizedTest를 사용해 제거해 본다.
     * assertThat(numbers.contains(1)).isTrue();
     * assertThat(numbers.contains(2)).isTrue();
     * assertThat(numbers.contains(3)).isTrue();
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containTest_1(int number) {
        assertTrue(numbers.contains(number));
    }

    /**
     containTest_1은 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과
     값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
     예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스
     트를 하나의 Test Case로 구현한다.
     */
    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    void containTest_2(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}
