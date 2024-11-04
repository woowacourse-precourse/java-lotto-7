package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinMatherTest {

    private static final int MONEY = 1000;

    private final NumberGenerate numberGenerate = new LottoGeneratorTest();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerate);
    private final LottoWinMather lottoWinMather = new LottoWinMather();

    @ParameterizedTest
    @MethodSource("lottoArgsGenerate")
    void 로또_1개_당첨_테스트(List<Integer> numbers, int bonus, Rank win) {
        // given
        PurchasedLottos purchasedLottos = lottoMachine.issueLotto(MONEY);
        WinningLotto winningLotto = winningLottoMake(numbers, bonus);

        // when
        LottoResult lottoResult = lottoWinMather.calculateLottoWins(purchasedLottos, winningLotto);

        // then
        Assertions.assertThat(lottoResult.calculateProfit(MONEY))
                .isEqualTo(((double) win.getPrize() / MONEY) * 100.0);
    }

    private static Stream<Arguments> lottoArgsGenerate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 20, 34, 5, 4, 3), 11, Rank.NO5),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 4, 3), 11, Rank.NO4),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 3), 11, Rank.NO3),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 3), 6, Rank.NO2),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 6), 11, Rank.NO1)
        );
    }

    private WinningLotto winningLottoMake(List<Integer> numbers, int bonus) {
        Lotto lotto = new Lotto(numbers);
        BonusBall bonusBall = new BonusBall(bonus);
        return new WinningLotto(lotto, bonusBall);
    }

}