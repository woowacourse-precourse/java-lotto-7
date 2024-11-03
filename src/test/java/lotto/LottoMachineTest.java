package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 로또_생성_테스트(){
        int quantity = 5;

        List<Lotto> lottos = lottoMachine.createLotto(quantity);

        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @Test
    public void 로또_당첨_개수_카운드_테스트(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Map<LottoRank, Integer> answer = Map.of(
                LottoRank.FIFTH, 1,
                LottoRank.FOURTH, 1,
                LottoRank.THIRD, 1,
                LottoRank.SECOND, 2,
                LottoRank.FIRST, 1
        );

        Map<LottoRank, Integer> rankCounts = lottoMachine.getRankCounts(lottos, winningNumbers, bonusNumber);

        for (int i = 0; i < lottos.size(); i++)
            assertThat(rankCounts).isEqualTo(answer);
    }

    @Test
    public void 당첨_결과_출력_테스트(){
        Map<LottoRank, Integer> rankCounts = Map.of(
                LottoRank.FIFTH, 1,
                LottoRank.FOURTH, 0,
                LottoRank.THIRD, 0,
                LottoRank.SECOND, 0,
                LottoRank.FIRST, 0
        );
        List<String> answer = List.of(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );

        List<String> result = lottoMachine.getWinningStatistics(rankCounts);

        assertThat(result).isEqualTo(answer);
    }
}