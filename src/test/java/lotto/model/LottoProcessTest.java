package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoProcessTest {

    @Test
    void getLottoNumbers() {
        LottoProcess lottoProcess = new LottoProcess();
        List<Integer> lottoNumbers = lottoProcess.getRandomLottoNumbers();
        System.out.println(lottoNumbers);
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);

    }
}