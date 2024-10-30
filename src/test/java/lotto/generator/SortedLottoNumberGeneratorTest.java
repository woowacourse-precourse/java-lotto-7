package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortedLottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호를 6개 생성한다.")
    void generate() {
        // given
        NumberGenerator<List<Integer>> lottoNumberGenerator = new SortedLottoNumberGenerator();

        // when
        var lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호는 1에서 45사이의 값을 발급한다.")
    void generateRange() {
        // given
        NumberGenerator<List<Integer>> lottoNumberGenerator = new SortedLottoNumberGenerator();

        // when
        var lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("로또 넘버는 오름차순으로 정렬한다.")
    void sort() {
        // given
        NumberGenerator<List<Integer>> lottoNumberGenerator = new SortedLottoNumberGenerator();

        // when
        var lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).isSorted();
    }

    @Test
    @DisplayName("로또 넘버는 중복되지 않는다.")
    void distinct() {
        // given
        NumberGenerator<List<Integer>> lottoNumberGenerator = new SortedLottoNumberGenerator();

        // when
        var lottoNumbers = lottoNumberGenerator.generate();

        // then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

}