package lotto.service;

import lotto.model.LottoModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    LottoModel lottoModel = new LottoModel();
    LottoService lottoService = new LottoService(lottoModel);

    @DisplayName("로또 리스트들이 제대로 생성되었는지 확인")
    @Test
    void 로또_리스트들이_제대로_생성되었는지_확인() {
        lottoService.generateLottos(3);
        Assertions.assertThat(lottoModel.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        Double rate = lottoService.getRate(4, new int[]{0, 0, 0, 0, 1});
        Assertions.assertThat(String.format("%.1f", rate))
                .isEqualTo(String.format("%.1f", 50000000.0));
    }
}