package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.lottoNumber.RandomNumberPicker;
import lotto.model.lotto.winningResult.rank.DefaultRankDeterminer;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.lotto.lottoNumber.Lotto;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import lotto.model.lotto.lottoNumber.Lottos;
import lotto.model.winningNumber.MainNumber;
import lotto.model.lotto.winningResult.rank.Rank;
import lotto.model.lotto.winningResult.WinningResults;
import lotto.service.lotto.DefaultLottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DefaultLottoMachineTest {
    private final DefaultLottoMachine defaultLottoMachine = new DefaultLottoMachine(new DefaultRankDeterminer(),
            new RandomNumberPicker());

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
        MainNumber mainNumber = new MainNumber(new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningResults winningResults = defaultLottoMachine.checkWinningResults(
                lottos, mainNumber, bonusNumber
        );
        return winningResults;
    }

    @Test
    @DisplayName("[success] 구매 금액에 맞는 구매 개수만큼 로또를 생성한다.")
    void createLottosByPurchaseAmount() {
        PurchaseAmount lottoAmount = new PurchaseAmount(2000);

        Lottos lottos = defaultLottoMachine.issueLottos(lottoAmount);

        assertThat(lottos.lottos().size()).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("[success] 각 등수 별로 몇 개의 로또가 당첨되었는지 확인하여 WinningResults를 생성한다.")
    @CsvSource(value = {"FIRST:1", "SECOND:1", "THIRD:1", "FOURTH:1", "FIFTH:1", "FAIL:3"}
            , delimiter = ':')
    void checkWinningResultsOfAllWinningRanks(Rank rank, int expectedLottoAmount) {
        WinningResults winningResults = setUpDefaultWinningResults();

        assertThat(winningResults.findLottoAmountByRank(rank))
                .isEqualTo(expectedLottoAmount);
    }

    @ParameterizedTest
    @DisplayName("[success] 총 당첨 금액을 계산하여 수익률을 계산한다.")
    @CsvSource(value = {"1000000000:203.1555", "55283000:3674.8277047193533", "180000:1128641.6666666665"}
            , delimiter = ':')
    void calculateEarningsRate(int expense, double expectedEarningsRate) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(expense);
        WinningResults winningResults = setUpDefaultWinningResults();

        assertThat(defaultLottoMachine.calculateEarningsRate(winningResults, purchaseAmount))
                .isEqualTo(expectedEarningsRate);
    }
}
