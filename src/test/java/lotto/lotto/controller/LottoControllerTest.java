package lotto.lotto.controller;

import java.util.List;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.service.MockLottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(new MockLottoService());
    }

    @Test
    @DisplayName("controller를 통해 lottoResults를 호출한다.")
    void getLottosInfoTest() {
        // given
        String lottoId = "lottoID";

        // when
        LottoResults lottosInfo = lottoController.getLottosInfo(lottoId);

        // then
        Assertions.assertThat(lottosInfo).isNotNull().isInstanceOf(LottoResults.class);
    }

    @Test
    @DisplayName("controller를 통해 winningLotto를 만들고 기존의 lotto를 평가하여 반환한다.")
    void createWinningLottoTest() {
        // given
        String lottoResultId = "lottoID";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoResults lottoResults = lottoController.createWinningLotto(lottoResultId, numbers, bonus);

        // then
        Assertions.assertThat(lottoResults).isNotNull().isInstanceOf(LottoResults.class);
    }
}