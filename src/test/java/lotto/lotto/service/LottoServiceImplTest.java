package lotto.lotto.service;

import java.util.List;
import lotto.common.util.random.LottoRandomGenerator;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.LottoWinning;
import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.infrastructure.FakeLottoRepository;
import lotto.lotto.service.port.LottoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {

    private LottoFactory lottoFactory;
    private LottoRepository lottoRepository;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory(new LottoRandomGenerator());
        lottoRepository = new FakeLottoRepository();
        lottoService = new LottoServiceImpl(lottoRepository, lottoFactory);
    }

    @Test
    @DisplayName("count를 주면 해당하는 크기의 lottoResult를 갖는 lottoResults를 만든다")
    void createLottoResultTest() {
        // given
        long count = 1;

        // when
        LottoResults lottoResults = lottoService.createLottos(count);

        // then
        Assertions.assertThat(lottoResults.getResults()).hasSize((int) count);
    }

    @Test
    @DisplayName("당첨 로또 정보를 제공하면 구매한 로또의 rank를 업데이트 한다")
    void createLottoWinningAndUpdateRankTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        LottoResult lottoResult = LottoResult.create(new Lotto(numbers));
        LottoResults lottoResults = LottoResults.of(List.of(lottoResult));
        lottoRepository.save(lottoResults);

        // when
        lottoResults = lottoService.createLottoWinningAndUpdateRank(numbers, bonus, lottoResults.getId());

        // then
        Assertions.assertThat(lottoResults.getResults().getFirst().getLottoRank()).isEqualTo(LottoRank.MATCHED6);
    }

    @Test
    @DisplayName("WinningLotto 객체를 제작해 반환한다")
    void createLottoWinningTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        LottoWinning winningLotto = lottoService.createWinningLotto(numbers, bonus);

        // then
        Assertions.assertThat(winningLotto).isNotNull();
        Assertions.assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(numbers);
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(bonus);
    }

    @Test
    @DisplayName("lottoResult id를 주면 객체를 반환한다.")
    void getLottoResultsTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoResult lottoResult = LottoResult.create(new Lotto(numbers));
        LottoResults lottoResults = LottoResults.of(List.of(lottoResult));
        lottoRepository.save(lottoResults);

        // when
        LottoResults findLottoResults = lottoRepository.findById(lottoResults.getId());

        // then
        Assertions.assertThat(findLottoResults).isEqualTo(lottoResults).isNotNull();
    }

}