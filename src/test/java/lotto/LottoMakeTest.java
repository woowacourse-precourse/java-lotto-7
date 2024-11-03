package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class LottoMakeTest {
    @Test
    void test() {
        //given
        LottoMaker lottoMaker = new LottoMaker();

        //when
        Lotto lotto = lottoMaker.createLotto();

        //then
        List<Integer> numbers = lotto.getNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertAll(
                () -> assertThat(numbers.size()).isEqualTo(6),
                () -> assertThat(uniqueNumbers.size()).isEqualTo(6)

        );
    }
}
