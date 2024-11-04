package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import lotto.Model.Service.LottoNumbers;
import java.util.List;

class LottoNumberTest {

    @Test
    void generateLottoNumbers_createsValidLottoNumbers() {
        List<Integer> lottoNumbers = LottoNumbers.generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}

