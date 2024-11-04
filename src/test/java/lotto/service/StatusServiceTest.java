package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.WinnerLotto;
import lotto.repository.impl.LottoTicketsRepository;
import lotto.repository.impl.WinnerStatusRepository;
import lotto.repository.mock.MockWinnerLottoRepository;
import lotto.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusServiceTest {

    @Test
    @DisplayName("보너스 번호가 없으면 에러를 발생한다.")
    void test1() {
        WinnerLotto winnerLotto = WinnerLotto.create("1,2,3,4,5,6");
        MockWinnerLottoRepository mockWinnerLottoRepository = new MockWinnerLottoRepository(winnerLotto);
        LottoTicketsRepository mockLottoTicketsRepository = new LottoTicketsRepository();
        WinnerStatusRepository mockWinnerStatusRepository = new WinnerStatusRepository();

        StatusService statusService = new StatusServiceImpl(mockWinnerLottoRepository, mockLottoTicketsRepository,
                mockWinnerStatusRepository);

        assertThatThrownBy(statusService::calculateStatus).isInstanceOf(IllegalStateException.class);
    }
}
