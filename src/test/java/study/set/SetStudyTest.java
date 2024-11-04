package study.set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetStudyTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1: size() 메서드 활용해 크기 확인, Set은 중복을 허용하지 않는 자료구조다")
    @Test
    void size() {
        // 검증하고자 하는 size() 메서드 직접 호출: 요구사항에 더 부합
        assertThat(numbers.size()).isEqualTo(3);

        // 라이브러리의 기능 활용
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항 2: contains() 메서드 활용해 존재 확인, 중복 코드 제거")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항 3: contains() 메서드 활용해 존재 확인, 중복 코드 제거")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @ParameterizedTest
    void contains_실패_추가(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
