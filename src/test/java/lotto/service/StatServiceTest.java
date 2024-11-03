package lotto.service;

import static lotto.constant.WinningPrize.FIFTH_PRIZE;
import static lotto.constant.WinningPrize.FIRST_PRIZE;
import static lotto.constant.WinningPrize.FOURTH_PRIZE;
import static lotto.constant.WinningPrize.SECOND_PRIZE;
import static lotto.constant.WinningPrize.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.dto.WinningStat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatServiceTest {
    final StatService statService = new StatService();

    List<Lotto> lottoGroup;
    Lottos lottos;
    Lotto winningLotto;
    BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottoGroup = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)));
        lottos = new Lottos(lottoGroup);

        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        bonusNumber = new BonusNumber(winningLotto, "7" );
    }

    @Test
    void LottoGame_객체로_통계_정보를_구할_수_있다() {
        // given
        LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);

        // when
        List<WinningStat> expected = List.of(
                new WinningStat(3, false, FIFTH_PRIZE.getPrizeAmount(), 0),
                new WinningStat(4, false, FOURTH_PRIZE.getPrizeAmount(), 0),
                new WinningStat(5, false, THIRD_PRIZE.getPrizeAmount(), 0),
                new WinningStat(5, true, SECOND_PRIZE.getPrizeAmount(), 1),
                new WinningStat(6, false, FIRST_PRIZE.getPrizeAmount(), 1));
        List<WinningStat> actual = statService.getWinningStats(lottoGame);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
