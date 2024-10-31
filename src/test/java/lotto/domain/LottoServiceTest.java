package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @Test
    @DisplayName("당첨 금액을 올바르게 합산하는지 확인")
    void 당첨_금액_테스트() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto bonusNumber = new Lotto(Arrays.asList(7));

        Lotto random1 = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
        Lotto random2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto random3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto random4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        List<Lotto> lottoTickets = new ArrayList<>(Arrays.asList(random1, random2, random3, random4));

        lottoService = new LottoService(lottoTickets, winningNumbers, bonusNumber);
        int result = lottoService.calculateWinningAmount();

        assertThat(result).isEqualTo(2000000000 + 30000000 + 1500000);
    }
}
