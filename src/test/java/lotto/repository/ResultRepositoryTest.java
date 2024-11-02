package lotto.repository;

import lotto.domain.Money;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ResultRepositoryTest {

    private static ResultRepository resultRepository;
    @BeforeEach
    void setup(){
        resultRepository = new ResultRepositoryImpl();
    }

    @Test
    void 생성자_테스트(){
        Map<Rank, Integer> result = resultRepository.getResult();

        assertThat(result)
                .containsKey(Rank.FIFTH);

        assertThat(result.values())
                .hasSize(5)
                .containsOnly(0);
    }

    @Test
    void 결과_반환_테스트(){
        // given
        resultRepository.addResult(Rank.FIFTH);
        resultRepository.addResult(Rank.FIFTH);
        resultRepository.addResult(Rank.FIRST);

        // when
        Map<Rank, Integer> result = resultRepository.getResult();

        // then
        assertThat(result)
                .hasSize(5)  // 전체 크기 확인
                .containsAllEntriesOf(Map.of(
                        Rank.FIRST, 1,
                        Rank.FIFTH, 2,
                        Rank.SECOND, 0,
                        Rank.THIRD, 0,
                        Rank.FOURTH, 0
                ));
    }

    @Test
    void 총_수익률_반환_테스트(){
        // given
        resultRepository.addResult(Rank.FIFTH);
        resultRepository.addResult(Rank.FIFTH);

        // when
        double profit = resultRepository.calculate(new Money(10000));

        // then
        assertThat(profit).isEqualTo(100.0);
    }
}
