package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.FixedNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultCheckerTest {
    private LotteryMachine lotteryMachine;
    private LottoRaffle lottoRaffle;
    List<Lotto> lottos = new ArrayList<>();
    private int BONUS_NUMBER;
    private LottoResultChecker lottoResultChecker;

    @BeforeEach
    void createWinningLotto() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        BONUS_NUMBER = 7;
        lotteryMachine = new LotteryMachine(new FixedNumberGenerator(winningNumber));
        lottoRaffle = new LottoRaffle(lotteryMachine.createLottoTicket(), BONUS_NUMBER);
    }

    @BeforeEach
    void createLotto() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(10, 11, 12, 13, 14, 15)));
    }

    @Test
    void 로또_결과_확인() {
        lottoResultChecker = new LottoResultChecker(lottoRaffle, lottos);
        int matchCount = lottoResultChecker.findMatchCount(lottos.getFirst());
        Assertions.assertThat(matchCount).isEqualTo(6);
    }
}