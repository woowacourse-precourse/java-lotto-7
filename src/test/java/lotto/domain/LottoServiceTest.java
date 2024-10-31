package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto bonusNumber = new Lotto(Arrays.asList(7));

        Lotto random1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));    // 3등
        Lotto random2 = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10));    // 4등

        List<Lotto> lottoTickets = new ArrayList<>(Arrays.asList(random1, random2));
        lottoService = new LottoService(lottoTickets, winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("당첨 금액을 올바르게 합산하는지 확인")
    void 당첨_금액_테스트() {
        lottoService.calculateWinningAmount();
        BigDecimal result = lottoService.getWinningAmount();
        assertThat(result).isEqualTo(BigDecimal.valueOf(1500000 + 50000));
    }

    @Test
    @DisplayName("수익률을 올바르게 계산하는지 확인")
    void 수익률_테스트() {
        lottoService.calculateWinningAmount();
        lottoService.calculateRateOfReturn();
        BigDecimal result = lottoService.getEarningsRate();
        assertThat(result).isEqualTo(BigDecimal.valueOf(77500.0));
    }
}
