package lotto.application.service;


import static lotto.domain.lotto.vo.LottoPrize.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.repository.FakeLottoRepository;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.WinningLottoEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EvaluateWinningLottoCommand 클래스 테스트")
class EvaluateWinningLottoCommandTest {

    private EvaluateWinningLottoUsecase evaluateWinningLottoUsecase;
    private LottoRepository lottoRepository;

    @BeforeEach
    void setup() {
        this.lottoRepository = new FakeLottoRepository();
        this.evaluateWinningLottoUsecase = new EvaluateWinningLottoCommand(
            new WinningLottoEvaluator(), new FakeLottoRepository());
    }

    @Test
    void 당첨_여부를_확인한다() {
        // given
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));

        EvaluateWinningLottoRequest evaluateWinningLottoRequest = new EvaluateWinningLottoRequest(winningNumber);

        lottoRepository.saveAll(lottos);

        // when
        EvaluateWinningLottoResponse evaluateWinningLottoResponse = evaluateWinningLottoUsecase.execute(evaluateWinningLottoRequest);

        // then
        assertThat(evaluateWinningLottoResponse.winningResult().get(FIRST)).isEqualTo(1);
        assertThat(evaluateWinningLottoResponse.earningRate()).isGreaterThan(100.0);
    }

}