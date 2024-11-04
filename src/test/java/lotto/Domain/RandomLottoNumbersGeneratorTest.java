package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumbersGeneratorTest {

    private final RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();

    @DisplayName("생성된 로또의 개수와 범위, 중복 여부를 확인한다.")
    @Test
    void createRandomLotto_생성된_번호_범위_및_중복_검사() {
        // when: 랜덤 로또 번호 생성
        List<Integer> lottoNumbers = generator.createRandomLotto();

        // then: 생성된 번호의 개수, 범위 및 중복 여부를 확인
        assertThat(lottoNumbers).hasSize(6); // 6개 번호인지 확인
        assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45); // 범위 내 번호인지 확인

        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertThat(uniqueNumbers).hasSize(6); // 중복 없이 6개의 고유 번호인지 확인
    }
}
