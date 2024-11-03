package lotto.util;

import static lotto.constant.LottoConstant.NUMBER_LENGTH;
import static lotto.constant.LottoConstant.NUMBER_RANGE_MAX;
import static lotto.constant.LottoConstant.NUMBER_RANGE_MIN;
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
                .hasSize(NUMBER_LENGTH.getValue());
    }

    @Test
    void 로또_번호는_설정한_범위내_값이다() {
        // given
        List<Integer> lottoNumbers = generateLottoNumbers();

        // when & then
        assertThat(lottoNumbers)
                .allMatch(number ->
                        number >= NUMBER_RANGE_MIN.getValue() &&
                                number <= NUMBER_RANGE_MAX.getValue()
                );
    }

    @Test
    void 로또_번호는_중복되지_않는다() {
        // given
        List<Integer> lottoNumbers = generateLottoNumbers();

        // when & then
        assertThat(new HashSet<>(lottoNumbers))
                .hasSize(NUMBER_LENGTH.getValue());
    }
}