package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.Constants.LOTTO_COUNT;
import static lotto.constants.Constants.LOTTO_STARTING_RANGE;
import static lotto.constants.Constants.LOTTO_END_RANGE;
import static org.assertj.core.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성 시 6개의 숫자가 포함되는지 테스트")
    @Test
    void 로또_번호_개수_테스트() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(LOTTO_COUNT.getValue());
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자인지 테스트")
    @Test
    void 로또_번호_범위_테스트() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        boolean allInRange = lottoNumbers.stream()
                .allMatch(number ->
                        number >= LOTTO_STARTING_RANGE.getValue() && number <= LOTTO_END_RANGE.getValue());
        assertThat(allInRange).isTrue();
    }

}
