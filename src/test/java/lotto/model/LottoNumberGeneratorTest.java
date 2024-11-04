package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("6개의 고유한 번호가 생성되는지 확인한다.")
    @Test
    void generateLottoNumbers_ShouldReturnSixUniqueNumbers() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        // 번호 개수 확인
        assertThat(lottoNumbers).hasSize(6);

        // 번호 중복 확인
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        assertThat(uniqueNumbers).hasSize(6);

        // 범위 확인
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("보너스 번호가 지정된 로또 번호에 포함되지 않는지 확인한다.")
    @Test
    void generateBonusNumber_ShouldNotBeInGivenNumbers() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
        int bonusNumber = LottoNumberGenerator.generateBonusNumber(lottoNumbers);

        // 보너스 번호가 로또 번호 리스트에 포함되지 않는지 확인
        assertThat(lottoNumbers).doesNotContain(bonusNumber);

        // 범위 확인
        assertThat(bonusNumber).isBetween(1, 45);
    }
}
