package lotto.util;

import static lotto.util.RandomUtil.LOTTO_NUMBER_COUNT;
import static lotto.util.RandomUtil.LOTTO_NUMBER_RANGE_MAX;
import static lotto.util.RandomUtil.LOTTO_NUMBER_RANGE_MIN;
import static lotto.util.RandomUtil.generateLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomUtilTest {

    @Test
    void 로또_번호는_갯수가_항상_6개다() {
        // given
        List<Integer> lottoNumbers = generateLottoNumbers();

        // when & then
        assertThat(lottoNumbers)
                .hasSize(LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_번호는_설정한_범위내_값이다() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        assertThat(lottoNumbers)
                .allMatch(number ->
                        number >= LOTTO_NUMBER_RANGE_MIN &&
                        number <= LOTTO_NUMBER_RANGE_MAX
                );
    }

    @Test
    void 로또_번호는_중복되지_않는다() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        assertThat(new HashSet<>(lottoNumbers))
                .hasSize(LOTTO_NUMBER_COUNT);
    }
}