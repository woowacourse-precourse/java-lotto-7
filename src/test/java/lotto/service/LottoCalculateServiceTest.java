package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoCalculateServiceTest {
    private final LottoCalculateService lottoCalculateService = new LottoCalculateService();

    @Test
    void 로또_당첨금이_상금과_같은지_테스트한다() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 10;
        Assertions.assertThat(lottoCalculateService.calculatePrize(userLotto, winningLotto, bonusNumber)).isEqualTo(
                Winning.FIFTH_WITH_BONUS.getPrice());
    }
}