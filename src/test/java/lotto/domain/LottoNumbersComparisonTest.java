package lotto.domain;

import lotto.dto.CountMatchNumbers;
import lotto.dto.GeneratedNumbers;
import lotto.dto.InputNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersComparisonTest {

    LottoNumbersComparison lottoNumbersComparison = new LottoNumbersComparison();

    @DisplayName("입력 받은 (당첨 번호와 보너스 번호)를 생성한 로또 번호와 비교하여 몇 개 일치하는지 파악하는 기능 테스트")
    @Test
    void 입력_받은_로또_번호만_일치하는_경우() {

        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))
        );
        InputNumbers inputNumbers = new InputNumbers(Arrays.asList(1, 2, 3, 11, 12, 13), 15);

        List<CountMatchNumbers> result = lottoNumbersComparison.countingWinning(generatedNumbers, inputNumbers);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getWinningNumbers()).isEqualTo(3);
        assertThat(result.get(0).getWinningBonusNumber()).isEqualTo(0);
        assertThat(result.get(1).getWinningNumbers()).isEqualTo(1);
        assertThat(result.get(1).getWinningBonusNumber()).isEqualTo(0);
    }

    @DisplayName("입력 받은 (당첨 번호와 보너스 번호)를 생성한 로또 번호와 비교하여 몇 개 일치하는지 파악하는 기능 테스트")
    @Test
    void 일치하는_경우가_없을_경우() {

        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                List.of(new Lotto(Arrays.asList(10, 20, 30, 40, 41, 42)),
                        new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)))
        );
        InputNumbers inputNumbers = new InputNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<CountMatchNumbers> result = lottoNumbersComparison.countingWinning(generatedNumbers, inputNumbers);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getWinningNumbers()).isEqualTo(0);
        assertThat(result.get(0).getWinningBonusNumber()).isEqualTo(0);
        assertThat(result.get(1).getWinningNumbers()).isEqualTo(0);
        assertThat(result.get(1).getWinningBonusNumber()).isEqualTo(0);
    }

    @DisplayName("입력 받은 (당첨 번호와 보너스 번호)를 생성한 로또 번호와 비교하여 몇 개 일치하는지 파악하는 기능 테스트")
    @Test
    void 보너스_번호만_일치하는_경우() {

        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(6, 8, 9, 10, 11, 12)))
        );
        InputNumbers inputNumbers = new InputNumbers(Arrays.asList(13, 14, 15, 16, 17, 18), 6);

        List<CountMatchNumbers> result = lottoNumbersComparison.countingWinning(generatedNumbers, inputNumbers);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getWinningNumbers()).isEqualTo(0);
        assertThat(result.get(0).getWinningBonusNumber()).isEqualTo(1);
        assertThat(result.get(1).getWinningNumbers()).isEqualTo(0);
        assertThat(result.get(1).getWinningBonusNumber()).isEqualTo(1);
    }

    @DisplayName("입력 받은 (당첨 번호와 보너스 번호)를 생성한 로또 번호와 비교하여 몇 개 일치하는지 파악하는 기능 테스트")
    @Test
    void 로또_번호와_보너스_번호가_일치하는_경우() {

        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)), new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 11, 12, 13, 14, 15)))
        );
        InputNumbers inputNumbers = new InputNumbers(Arrays.asList(1, 2, 3, 4, 7, 14), 11);

        List<CountMatchNumbers> result = lottoNumbersComparison.countingWinning(generatedNumbers, inputNumbers);

        assertThat(result).hasSize(3);
        assertThat(result.get(0).getWinningNumbers()).isEqualTo(4);
        assertThat(result.get(0).getWinningBonusNumber()).isEqualTo(1);
        assertThat(result.get(1).getWinningNumbers()).isEqualTo(1);
        assertThat(result.get(1).getWinningBonusNumber()).isEqualTo(1);
        assertThat(result.get(2).getWinningNumbers()).isEqualTo(2);
        assertThat(result.get(2).getWinningBonusNumber()).isEqualTo(1);
    }
}
