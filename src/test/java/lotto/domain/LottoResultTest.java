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

    @Test
    @DisplayName("1등 당첨 여부를 확인한다.")
    void firstPlace() {
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers, bonusNumber);
        List<LottoRankType> ranks = lottoResult.getLottoRankTypes();

        assertThat(ranks.getFirst()).isEqualTo(LottoRankType.FIRST);
    }

    @Test
    @DisplayName("2등 당첨 여부를 확인한다.")
    void secondPlace() {
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers, bonusNumber);
        List<LottoRankType> ranks = lottoResult.getLottoRankTypes();

        assertThat(ranks.getFirst()).isEqualTo(LottoRankType.SECOND);
    }

    @Test
    @DisplayName("당첨되지 않는 경우를 확인한다.")
    void noPrize() {
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers, bonusNumber);
        List<LottoRankType> ranks = lottoResult.getLottoRankTypes();

        assertThat(ranks.getFirst()).isEqualTo(LottoRankType.NONE);
    }

}