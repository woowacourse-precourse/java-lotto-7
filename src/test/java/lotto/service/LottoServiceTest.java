package lotto.service;

import java.util.ArrayList;
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
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto bonusNumber = new Lotto(List.of(7));

        Lotto random1 = new Lotto(List.of(1, 2, 3, 4, 5, 10));    // 3등
        Lotto random2 = new Lotto(List.of(1, 2, 3, 4, 9, 10));    // 4등

        List<Lotto> lottoTickets = new ArrayList<>(List.of(random1, random2));
        lottoService = new LottoService(lottoTickets, winningNumbers, bonusNumber, 2000);
    }

    @Test
    @DisplayName("당첨 금액을 올바르게 합산하는지 확인")
    void 당첨_금액_테스트() {
        String result = lottoService.getWinningAmount();
        assertThat(result).isEqualTo("1550000");
    }

    @Test
    @DisplayName("수익률을 올바르게 계산하는지 확인")
    void 수익률_테스트() {
        String result = lottoService.getEarningsRate();
        assertThat(result).isEqualTo("77500.0");
    }
}
