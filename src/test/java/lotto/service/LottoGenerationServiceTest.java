package lotto.service;

import lotto.dto.LottoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGenerationServiceTest {

    private final LottoGenerationService generationService = new LottoGenerationService();

    @Test
    @DisplayName("구입 금액에 따른 로또 생성 개수 확인")
    void generateLottos_validAmount_shouldGenerateCorrectNumberOfLottos() {
        int purchaseAmount = 5000;
        List<LottoDTO> lottos = generationService.generateLottos(purchaseAmount);
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("생성된 로또 번호의 개수 및 범위 확인")
    void generateLottos_generatedLottoNumbers_shouldBeValid() {
        int purchaseAmount = 1000;
        List<LottoDTO> lottos = generationService.generateLottos(purchaseAmount);
        LottoDTO lottoDTO = lottos.get(0);
        assertThat(lottoDTO.getNumbers()).hasSize(6);
        assertThat(lottoDTO.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }
}
