package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.ResultRepository;
import lotto.repository.ResultRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class WinServiceTest {
    private static WinService winService;
    private static LottoRepository lottoRepository;
    private static ResultRepository resultRepository;

    @BeforeEach
    void setup(){
        lottoRepository = new LottoRepositoryImpl(new ArrayList<>());
        resultRepository = new ResultRepositoryImpl();
        winService = new WinService(lottoRepository, resultRepository);
    }

    @Test
    void 당첨_테스트(){
        // given
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winService.win(List.of(4, 5, 6, 7, 8, 9), 10);

        // when
        Map<Rank, Integer> result = resultRepository.getResult();

        // then
        assertThat(result)
                .extracting(Rank.FIFTH)
                .isEqualTo(1);

    }

    @Test
    void 총_수익률_반환_테스트(){
        // given
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winService.win(List.of(4, 5, 6, 7, 8, 9), 10);  // 3개만 일치

        // when
        double profit = resultRepository.calculate(new Money(5000));

        // then
        assertThat(profit)
                .isEqualTo(100.0);
    }
}
