package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.LottoRank;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoStatistic;
import lotto.model.vo.WinningNumber;
import lotto.repository.InMemoryLottoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStatisticServiceImplTest {
    LottoStatisticServiceImpl lottoStatisticService;

    @BeforeEach
    void setUp() {
        lottoStatisticService = new LottoStatisticServiceImpl(InMemoryLottoRepository.getInstance());
    }

    @AfterEach
    void cleanUp() {
        InMemoryLottoRepository.getInstance().clear();
    }

    @Test
    void 일등인_경우_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        InMemoryLottoRepository.getInstance().save(lotto);

        //when
        LottoStatistic lottoStatistic = lottoStatisticService.calculateStatistic(winningNumber);

        //then
        assertThat(1)
                .isEqualTo(lottoStatistic.getCountByLottoRank(LottoRank.FIRST));
    }

    @Test
    void 이등인_경우_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        InMemoryLottoRepository.getInstance().save(lotto);

        //when
        LottoStatistic lottoStatistic = lottoStatisticService.calculateStatistic(winningNumber);

        //then
        assertThat(1)
                .isEqualTo(lottoStatistic.getCountByLottoRank(LottoRank.SECOND));
    }

    @Test
    void 삼등인_경우_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 15));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        InMemoryLottoRepository.getInstance().save(lotto);

        //when
        LottoStatistic lottoStatistic = lottoStatisticService.calculateStatistic(winningNumber);

        //then
        assertThat(1)
                .isEqualTo(lottoStatistic.getCountByLottoRank(LottoRank.THIRD));
    }

    @Test
    void 사등인_경우_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 7));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        InMemoryLottoRepository.getInstance().save(lotto);

        //when
        LottoStatistic lottoStatistic = lottoStatisticService.calculateStatistic(winningNumber);

        //then
        assertThat(1)
                .isEqualTo(lottoStatistic.getCountByLottoRank(LottoRank.FOURTH));
    }

    @Test
    void 오등인_경우_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 10, 7));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        InMemoryLottoRepository.getInstance().save(lotto);

        //when
        LottoStatistic lottoStatistic = lottoStatisticService.calculateStatistic(winningNumber);

        //then
        assertThat(1)
                .isEqualTo(lottoStatistic.getCountByLottoRank(LottoRank.FIFTH));
    }
}
