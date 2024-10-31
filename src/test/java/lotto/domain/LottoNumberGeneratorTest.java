package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("로또 숫자 6개가 정상적으로 생성된다.")
    @Test
    void generate_testSize() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).hasSize(6);
    }

    @DisplayName("로또 숫자가 중복되지 않는다.")
    @Test
    void generate_testDuplicate() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        // then
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertThat(uniqueNumbers).hasSize(6);
    }

    @DisplayName("로또 숫자 범위가 1부터 45 사이이다.")
    @Test
    void generate_range() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("로또 숫자가 오름차순으로 정렬된다.")
    @Test
    void generate_testSorted() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        // then
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
    }

}