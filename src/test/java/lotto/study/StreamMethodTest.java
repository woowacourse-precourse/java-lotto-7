package lotto.study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamMethodTest {
 
    @Test
    @DisplayName("sorted()로 리스트의 정수를 정렬할 수 있다")
    void streamCanSortIntegerList() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1));

        List<Integer> result = numbers.stream().sorted().toList();

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("distinct()는 중복된 요소를 제거한다")
    void distinctTest() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

        List<Integer> distinctNumbers = numbers.stream()
            .distinct()
            .collect(Collectors.toList());

        assertThat(distinctNumbers).containsExactly(1, 2, 3, 4);
        assertThat(distinctNumbers).hasSize(4);
    }

    @Test
    @DisplayName("forEach()는 각 요소에 대해 주어진 동작을 수행한다")
    void forEachTest() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> result = new ArrayList<>();

        numbers.stream()
            .forEach(result::add);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("peek()은 요소를 확인하면서 중간 연산을 수행할 수 있다")
    void peekTest() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> peekedNumbers = new ArrayList<>();

        List<Integer> result = numbers.stream()
            .peek(peekedNumbers::add)
            .map(n -> n * 2)
            .collect(Collectors.toList());

        assertThat(peekedNumbers).containsExactly(1, 2, 3); // peek으로 확인된 원본 값
        assertThat(result).containsExactly(2, 4, 6); // 최종 변환된 값
    }

    @Test
    @DisplayName("map()은 각 요소를 변환한다")
    void mapTest() {
        List<String> words = List.of("a", "bb", "ccc");

        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());

        List<String> upperCase = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        assertThat(lengths).containsExactly(1, 2, 3);
        assertThat(upperCase).containsExactly("A", "BB", "CCC");
    }

    @Test
    @DisplayName("generate()는 무한 스트림을 생성할 수 있다")
    void generateTest() {
        List<Integer> randomNumbers = Stream.generate(Math::random)
            .map(d -> (int)(d * 100))
            .limit(5)
            .collect(Collectors.toList());

        List<Integer> constantNumbers = Stream.generate(() -> 1)
            .limit(3)
            .collect(Collectors.toList());

        assertThat(randomNumbers).hasSize(5);
        assertThat(constantNumbers).containsOnly(1);
        assertThat(constantNumbers).hasSize(3);
    }

    @Test
    @DisplayName("generate()로 생성한 스트림은 limit()을 사용하지 않으면 무한하다")
    void generateInfiniteStreamTest() {
        Stream<Integer> infiniteStream = Stream.generate(() -> 1);

        assertThatCode(() -> {
            List<Integer> numbers = infiniteStream
                .limit(1000)
                .collect(Collectors.toList());
            assertThat(numbers).hasSize(1000);
        }).doesNotThrowAnyException();
    }
}
