package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("로또 결과가 정상적으로 생성되는지 확인한다.")
    void createLottoResult() {
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers, bonusNumber);

        assertThat(lottoResult).isNotNull();
    }

}