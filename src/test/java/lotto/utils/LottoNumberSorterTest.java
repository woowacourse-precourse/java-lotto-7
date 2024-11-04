package lotto.utils;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberSorterTest {
    @Test
    void 로또_번호가_오름차순으로_정렬된다() {
        //given
        List<Integer> list = Arrays.asList(43, 15, 5, 11, 23, 7);

        //when
        LottoNumberSorter.sortAscending(list);

        //then
        Assertions.assertThat(list).containsExactly(5, 7, 11, 15, 23, 43);
    }
}