package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 원하는_개수만큼_랜덤된_숫자_리스트를_반환한다() {
        //given & when
        List<Integer> numbers = RandomNumber.getUniqueNumbers(0, 45, 6);

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 범위_내의_랜덤된_숫자_리스트를_반환한다() {
        //given & when
        List<Integer> numbers = RandomNumber.getUniqueNumbers(0, 45, 6);

        //then
        assertThat(numbers.size()).isBetween(0, 45);
    }

}
