package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
// Test Case 구현

    @Test
    @DisplayName("set의 사이즈를 확인하는 테스트 케이스")
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest(name = "set에 {0}이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set의 contains메소드를 활용해 1,2,3의 값이 존재하는지 확인")
    void setContains(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "set에 {0}이 포함되어 있으면 {1} 반환")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    @DisplayName("set의 contains메소드를 활용해 false값도 확인가능")
    void setContains(int number, boolean expectedResult) {
        assertThat(numbers.contains(number)).isEqualTo(expectedResult);
    }
}
