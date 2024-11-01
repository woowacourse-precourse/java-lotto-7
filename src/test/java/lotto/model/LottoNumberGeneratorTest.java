package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성 시 6개의 숫자가 포함되는지 테스트")
    @Test
    void 로또_번호_개수_테스트() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자인지 테스트")
    @Test
    void 로또_번호_범위_테스트() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        boolean allInRange = lottoNumbers.stream().allMatch(number -> number >= 1 && number <= 45);
        assertThat(allInRange).isTrue();
    }
}
