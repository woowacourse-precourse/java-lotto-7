package lotto.application.service;

import lotto.application.dto.request.ManageLottoRequest;
import lotto.application.dto.response.ManageLottoResponse;
import lotto.application.port.inbound.ManageLottoUseCase;
import lotto.domain.cost.Cost;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManageLottoUseCaseTest {
    private final ManageLottoUseCase manageLottoUseCase = new ManageLottoUseCaseImpl();
    private final List<Lotto> lottos = List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
    );
    private final WinningLotto winningLotto = new FixedWinningLotto();

    @Test
    @DisplayName("주어진 입력에 대해 올바른 결과를 도출할 수 있다.")
    void 정상_동작_테스트() {
        // given
        ManageLottoRequest request = new ManageLottoRequest(Cost.of(8000), lottos, winningLotto);

        // when
        ManageLottoResponse response = manageLottoUseCase.getResult(request);

        // then
        assertThat(response.rankResult().toString()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
        assertThat(response.revenueRate().toString()).isEqualTo("62.5%");
    }
}