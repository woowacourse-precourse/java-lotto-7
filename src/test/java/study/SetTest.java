package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest { 
    private Set<Integer> numbers;
    
    @BeforeEach 
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @DisplayName("set 자료구조의 size 메서드 학습")
    @Test
    void size_테스트() {
        assertEquals(3, numbers.size());
    }
    
    @ParameterizedTest(name = "[Legacy] Set contains 테스트 [{index}] : contains({0})")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
    
    @ParameterizedTest(name = "Set contains 테스트 [{index}] : contains({0}) -> {1}")
    @CsvSource({
                "1, true",
                "2, true",
                "3, true",
                "4, false",
                "5, false"
            })
    void contains2(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}
