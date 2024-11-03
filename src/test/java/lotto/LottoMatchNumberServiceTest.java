package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.service.LottoMatchNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchNumberServiceTest {

    private LottoMatchNumberService lottoMatchNumberService;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoMatchNumberService = new LottoMatchNumberService(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("1등 당첨 - 6개 일치")
    void 로또_1등_당첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("2등 당첨 - 5개 일치 + 보너스 번호")
    void 로또_2등_당첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.SECOND, 0)).isEqualTo(1);
        assertThat(results.getOrDefault(WinningRank.FIRST, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("3등 당첨 - 5개 일치")
    void 로또_3등_당첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 - 4개 일치")
    void 로또_4등_당첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("5등 당첨 - 3개 일치")
    void 로또_5등_당첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.FIFTH, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 X - 2개 이하 일치")
    void 로또_낙첨을_계산합니다() {
        List<Lotto> userLottos = List.of(
                new Lotto(Arrays.asList(1, 2, 12, 13, 14, 15))
        );

        Map<WinningRank, Integer> results = lottoMatchNumberService.calculateResults(userLottos);

        assertThat(results.getOrDefault(WinningRank.NONE, 0)).isEqualTo(1);
    }
}
