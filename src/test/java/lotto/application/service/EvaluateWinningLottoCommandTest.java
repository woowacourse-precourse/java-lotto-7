package lotto.application.service;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EvaluateWinningLottoCommand 클래스 테스트")
class EvaluateWinningLottoCommandTest {

    private EvaluateWinningLottoUsecase evaluateWinningLottoUsecase;

    @BeforeEach
    void setup() {
        this.evaluateWinningLottoUsecase = new EvaluateWinningLottoCommand();
    }

    @Test
    void 당첨_여부를_확인한다() {
        // given
        WinningNumber winningNumber = WinningNumber.of(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));

        // when
        List<LottoPrize> lottoPrizes = evaluateWinningLottoUsecase.execute(winningNumber, lottos);

        // then
        assertThat(lottoPrizes).containsExactly(LottoPrize.FIRST);
    }

}