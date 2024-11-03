package lotto.model;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        winningLotto = WinningLotto.create("1,2,3,4,5,6");
        winningLotto.addBonusNumber("7");
    }

    @Test
    @DisplayName("5등 당첨 테스트")
    public void winningLottoCompareTest_5th() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        ));

        lottoResult.compare(lottoTicket, winningLotto);
        Map<LottoRank, Integer> results = lottoResult.getRankResults();

        assertThat(results.get(LottoRank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 테스트")
    public void winningLottoCompareTest_4th() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 9, 10))
        ));

        lottoResult.compare(lottoTicket, winningLotto);
        Map<LottoRank, Integer> results = lottoResult.getRankResults();

        assertThat(results.get(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 테스트")
    public void winningLottoCompareTest_3th() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 10))
        ));

        lottoResult.compare(lottoTicket, winningLotto);
        Map<LottoRank, Integer> results = lottoResult.getRankResults();

        assertThat(results.get(LottoRank.THIRD)).isEqualTo(1);
    }
}
