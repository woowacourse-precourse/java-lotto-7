package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NONE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningProcessorTest {

    @Test
    void 당첨_결과_계산_테스트() {
        //given
        WinningProcessor processor = getWinningProcessor();
        long buyAmount = 1_000L;

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(NONE, 1);
        result.put(FIFTH, 0);
        result.put(FOURTH, 0);
        result.put(THIRD, 0);
        result.put(SECOND, 1);
        result.put(FIRST, 0);

        //when
        WinningResult winningResult = processor.calculate(buyAmount);

        //then
        Assertions.assertThat(winningResult.getResult()).isEqualTo(result);
    }

    @Test
    void 당첨금_계산_테스트() {
        //given
        WinningProcessor processor = getWinningProcessor();
        long buyAmount = 1_000L;

        long prize = 30_000_000L;

        //when
        WinningResult winningResult = processor.calculate(buyAmount);

        //then
        Assertions.assertThat(winningResult.getPrize()).isEqualTo(prize);
    }

    @Test
    void 수익률_계산_테스트() {
        //given
        WinningProcessor processor = getWinningProcessor();
        long buyAmount = 1_000L;
        long prize = 30_000_000L;

        double rateOfReturn = 3000000.0;

        //when
        WinningResult winningResult = processor.calculate(buyAmount);

        //then
        Assertions.assertThat(winningResult.getRateOfReturn()).isEqualTo(rateOfReturn);
    }

    private WinningProcessor getWinningProcessor() {
        int lottoCount = 2;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        UserLotto userLotto = new UserLotto(lottoCount, lottos);

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        int bonusNumber = 6;

        return new WinningProcessor(userLotto, winningLotto, bonusNumber);
    }
}
