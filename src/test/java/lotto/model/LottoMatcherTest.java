package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.util.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 자동_로또와_정답_로또를_매칭한다() {

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), inputValidator);
        Integer bonusNumber = 7;

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6), inputValidator);
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12), inputValidator);

        List<Lotto> autoGeneratedLotto = new ArrayList<>();
        autoGeneratedLotto.add(lotto1);
        autoGeneratedLotto.add(lotto2);
        Lottos autoGeneratedLottos = new Lottos(autoGeneratedLotto);

        LottoMatcher lottoMatcher = new LottoMatcher();
        lottoMatcher.determineWinningDetails(autoGeneratedLottos, winningLotto, bonusNumber);
        int firstRankMatchedLottoCount = WinningDetails.FIRST_PRIZE.getMatchLottoCount();

        assertEquals(firstRankMatchedLottoCount, 1);

    }

}
