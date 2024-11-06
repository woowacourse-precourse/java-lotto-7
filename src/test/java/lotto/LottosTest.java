package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.EnumMap;
import java.util.List;

import java.util.stream.Collectors;
import lotto.core.domain.model.GameResult;
import lotto.core.domain.model.Lotto;
import lotto.core.domain.model.Lottos;
import lotto.core.domain.model.PrizeOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottosTest extends NsTest {
    private Lottos lottos;
    private List<List<Integer>> arr;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos();
    }

    @Test
    public void buyLottosTest() {
        int ticketAmount = 5;
        assertThat(lottos.buyLottoByTicketAmount(ticketAmount).size()).isEqualTo(ticketAmount);
    }

    @Test
    public void buy8LottosPickedNumberTest() {
        assertRandomUniqueNumbersInRangeTest(
                this::runMainAndCaptureNumbers,
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    protected void runMain() {
        arr = lottos.buyLottoByTicketAmount(8).stream()
                .map(Lotto::getNumbersForMessage)
                .collect(Collectors.toList());
    }

    private void runMainAndCaptureNumbers() {
        run();
        assertThat(arr.toString()).contains(
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 45]",
                "[7, 11, 30, 40, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[1, 3, 5, 14, 22, 45]"
        );
    }

    @Test
    public void lottosMatchUpResult() {
        Lottos lottos = prepareLottos();
        Lotto answerLotto = Lotto.newInstance(List.of(1, 2, 5, 17, 22, 45));
        int bonusNumber = 3;

        List<PrizeOption> expectedResults = List.of(PrizeOption.FOUR_MATCHES, PrizeOption.SIX_MATCHES);
        assertThat(lottos.matchUp(answerLotto, bonusNumber)).isEqualTo(expectedResults);
    }

    @Test
    public void lottosMatchUpResultMessage() {
        Lottos lottos = prepareLottos();
        Lotto answerLotto = Lotto.newInstance(List.of(1, 2, 5, 17, 22, 45));
        int bonusNumber = 3;

        GameResult results = new GameResult(lottos.matchUp(answerLotto, bonusNumber));
        EnumMap<PrizeOption, Integer> expectedCounts = new EnumMap<>(PrizeOption.class);
        expectedCounts.put(PrizeOption.FOUR_MATCHES, 1);
        expectedCounts.put(PrizeOption.SIX_MATCHES, 1);

        assertThat(results.getResultCounts()).isEqualTo(expectedCounts);
    }

    private Lottos prepareLottos() {
        List<Lotto> userLottos = List.of(
                Lotto.newInstance(List.of(1, 3, 5, 14, 22, 45)),
                Lotto.newInstance(List.of(1, 2, 5, 17, 22, 45))
        );
        return new Lottos(userLottos);
    }
}
