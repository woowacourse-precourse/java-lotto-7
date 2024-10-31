package lotto.study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {
    @Test
    @DisplayName("Stream의 sorted()로 리스트의 정수를 정렬할 수 있다")
    void streamCanSortIntegerList() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1));

        List<Integer> result = numbers.stream().sorted().toList();

        assertThat(result).containsExactly(1, 2, 3);
    }
}
