package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class RandomUtilTest {

    @Test
    void 뽑은_로또_번호_숫자의_범위는_1부터_45_사이이다() {
        List<Integer> number = RandomUtil.getLottoNumbers(1);
        assertThat(number.getFirst()).isBetween(1, 45);
    }
}
