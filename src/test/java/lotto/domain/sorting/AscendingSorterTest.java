package lotto.domain.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AscendingSorterTest {

    @Test
    void 숫자는_오름차순_정렬되어야_한다() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(5, 4, 3, 2, 1));
        AscendingSorter sorter = new AscendingSorter();

        //when
        sorter.sort(numbers);

        //then
        assertThat(numbers.getFirst()).isEqualTo(1);
        assertThat(numbers.getLast()).isEqualTo(5);
    }

}
