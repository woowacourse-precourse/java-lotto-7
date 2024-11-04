package lotto.util;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMakerTest {

    @Test
    @DisplayName("무작위로 뽑은 숫자는 서로 중복되지 않는다")
    void pick_unique_numbers_without_duplication() {
        List<LottoNumber> numbers = LottoMaker.make();

        Set<LottoNumber> deleted_duplication = new HashSet<>(numbers);

        Assertions.assertEquals(numbers.size(), deleted_duplication.size());
    }

    @Test
    @DisplayName("숫자는 지정된 갯수만큼 뽑는다")
    void pick_numbers_as_fix_size() {
        int fixedSize = 6;

        List<LottoNumber> numbers = LottoMaker.make();

        Assertions.assertEquals(numbers.size(), fixedSize);
    }

    @Test
    @DisplayName("뽑은 숫자들을 오름차순으로 정렬한다")
    void sort_random_numbers() {
        List<LottoNumber> numbers = LottoMaker.make();

        org.assertj.core.api.Assertions.assertThat(numbers)
                .isSortedAccordingTo(Comparator.comparing(LottoNumber::getNumber));
    }
}
