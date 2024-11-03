package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PurchaseAmount;
import lotto.model.lotto.Lottos;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.winningResult.WinningRank;
import lotto.model.winningResult.WinningResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    WinningResults setUpDefaultWinningResults() {
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 8, 9))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 8, 9, 10))),
                new Lotto(new ArrayList<>(List.of(1, 2, 8, 9, 10, 11))),
                new Lotto(new ArrayList<>(List.of(1, 8, 9, 10, 11, 12))),
                new Lotto(new ArrayList<>(List.of(8, 9, 10, 11, 12, 13)))
        )));
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningResults winningResults = lottoMachine.checkLottoWinningResult(
                lottos, winningNumber, bonusNumber
        );
        return winningResults;
    }

    @Test
    @DisplayName("[success] 구매 금액에 맞는 구매 개수만큼 로또를 생성한다.")
    void createLottosByPurchaseAmount() {
        PurchaseAmount lottoAmount = new PurchaseAmount(2000);

        Lottos lottos = lottoMachine.issueLottos(lottoAmount);

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("[success] 각 등수 별로 몇 개의 로또가 당첨되었는지 확인하여 WinningResults를 생성한다.")
    @CsvSource(value = {"FIRST:1", "SECOND:1", "THIRD:1", "FOURTH:1", "FIFTH:1", "FAIL:3"}
            , delimiter = ':')
    void checkWinningResultsOfAllWinningRanks(WinningRank winningRank, int expectedLottoAmount) {
        WinningResults winningResults = setUpDefaultWinningResults();

        assertThat(winningResults.findLottoAmountByRank(winningRank))
                .isEqualTo(expectedLottoAmount);
    }

    @ParameterizedTest
    @DisplayName("[success] 총 당첨 금액을 계산하여 수익률을 계산한다.")
    @CsvSource(value = {"1000000000:203.1555", "55283055:3674.8240487071494", "180000:1128641.6666666665"}
            , delimiter = ':')
    void calculateEarningsRate(int expense, double expectedEarningsRate) {
        WinningResults winningResults = setUpDefaultWinningResults();

        assertThat(lottoMachine.calculateEarningsRate(winningResults, expense))
                .isEqualTo(expectedEarningsRate);
    }
}
