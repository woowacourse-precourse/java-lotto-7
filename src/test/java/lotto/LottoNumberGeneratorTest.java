package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import lotto.service.LottoNumberGeneratorService;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        List<Integer> randomLottoNumbers = lottoNumberGeneratorService.generateRandomLottoNumbers();

        assertThat(randomLottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_숫자가_1부터_45까지의_숫자들로_구성되어있는지_확인한다() {
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        List<Integer> randomLottoNumbers = lottoNumberGeneratorService.generateRandomLottoNumbers();

        assertThat(randomLottoNumbers).allMatch(lottoNumber -> lottoNumber >= 1 && lottoNumber <= 45);
    }

    @Test
    void 로또_번호_숫자가_1부터_45까지의_숫자들_중_중복된_숫자가_있는지_확인한다() {
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        List<Integer> randomLottoNumbers = lottoNumberGeneratorService.generateRandomLottoNumbers();

        assertThat(randomLottoNumbers.size()).isEqualTo(Set.copyOf(randomLottoNumbers).size());
    }


}
