package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 목록을 생성한다")
    void generateLottos() {
        lottoService.generateLottos(3000);
        List<Lotto> lottos = lottoService.getLottos();
        assertThat(lottos).hasSize(3);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 설정하고 결과를 계산한다")
    void calculateResults() {
        lottoService.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoService.generateLottos(2000); // 2개의 로또 생성

        String result = lottoService.calculateResults();
        assertThat(result).isNotEmpty();
    }
}