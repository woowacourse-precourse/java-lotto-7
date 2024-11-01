package lotto.util;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 생성 개수 테스트")
    void generateLottoNumberCount() {
        // when
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void generateLottoNumberRange() {
        // when
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers)
                .allMatch(number -> number >= Integer.parseInt(LottoNumberGenerator.MIN_LOTTO_NUMBER)
                        && number <= Integer.parseInt(LottoNumberGenerator.MAX_LOTTO_NUMBER));
    }

    @Test
    @DisplayName("로또 번호 중복 검사")
    void generateUniqueLottoNumbers() {
        // when
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        HashSet<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);

        // then
        assertThat(uniqueNumbers).hasSize(6);
        assertThat(uniqueNumbers).containsAll(lottoNumbers);
    }
}
