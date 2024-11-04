package lotto.application.service;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoRank;
import lotto.domain.WinLotto;
import lotto.domain.WinResult;
import lotto.domain.repository.InMemoryLottoRepository;
import lotto.domain.repository.InMemoryWinLottoRepository;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.domain.repository.WinResultHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {

    private final WinLottoRepository winLottoRepository = InMemoryWinLottoRepository.getInstance();
    private final WinResultHistory winResultHistory = WinResultHistory.getInstance();
    private final LottoRepository lottoRepository = InMemoryLottoRepository.getInstance();
    private final LottoMatcher lottoMatcher = new LottoMatcher();
    private LottoResultService lottoResultService = new LottoResultService(
            winLottoRepository,
            winResultHistory,
            lottoRepository,
            lottoMatcher);

    @BeforeEach
    void setUp() {
        winLottoRepository.clear();
        lottoRepository.clear();
        winResultHistory.clear();
    }

    @DisplayName("번호리스트와 보너스번호로 당첨로또를 생성하고 저장할 수 있다.")
    @Test
    void createWinLotto() {
        assertSimpleTest(() -> {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 10;

            lottoResultService.createWinLotto(numbers, bonusNumber);

            WinLotto winLotto = winLottoRepository.getRecent();
            assertThat(winLotto.getLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            assertThat(winLotto.getBonusNumber()).isEqualTo(bonusNumber);
        });
    }

    @DisplayName("당첨로또와 구매로또들을 비교하여 당첨 결과를 계산하고 저장한다.")
    @Test
    void checkWinning() {
        //given
        Lotto lotto1 = Lotto.create(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto2 = Lotto.create(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = Lotto.create(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto4 = Lotto.create(List.of(1, 2, 3, 4, 9, 10));
        WinLotto winLotto = WinLotto.of(
                Lotto.create(List.of(1, 2, 3, 4, 5, 7)),
                8
        );
        winLottoRepository.save(winLotto);
        lottoRepository.saveAll(List.of(lotto1, lotto2, lotto3, lotto4));

        //when
        lottoResultService.checkWinning();

        //then
        WinResult winResult = winResultHistory.getRecent();
        assertThat(winResult.getMatchCount(LottoRank.SECOND.name())).isEqualTo(1);
        assertThat(winResult.getMatchCount(LottoRank.FIRST.name())).isEqualTo(2);
        assertThat(winResult.getMatchCount(LottoRank.FOURTH.name())).isEqualTo(1);

    }
}
