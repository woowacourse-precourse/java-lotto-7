package study;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("Set::size - size 메소드를 통해 컬렉션의 값 개수를 알 수 있다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set::contains - contains 메소드를 통해 해당 값이 존재하는지 알 수 있다.(반복된 코드 문제 발생)")
    void containsTestWithTestAnnotation() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set::contains - contains 메소드를 통해 해당 값이 존재하는지 알 수 있다.(반복된 코드 문제 해결, 파라미터에 따른 다른 결과 문제 발생)")
    void containsTestWithParameterizedTestAnnotation(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    @DisplayName("Set::contains - contains 메소드를 통해 해당 값이 존재하는지 알 수 있다.(반복된 코드 문제 해결, 파라미터에 따른 다른 결과 문제 해결)")
    void containsTestWithCsvSourceAnnotation(int value, boolean excepted) {
        assertThat(numbers.contains(value)).isEqualTo(excepted);
    }

}


