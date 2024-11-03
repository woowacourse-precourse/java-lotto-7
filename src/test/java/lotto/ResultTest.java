package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {

    Map<Rank, Integer> winningDetail = new HashMap<>();

    @BeforeEach
    void setUp(){
        Rank[] ranks = Rank.values();
        for (int i = 3; i <= 7; i++) {
            winningDetail.put(ranks[i], 0);
        }
    }

    @ParameterizedTest
    @CsvSource({"3, 1, 10, 50.0", "4, 1, 10, 500.0"})
    void 당첨내역에_따라_수익률을_계산한다(int rank, int count, int lottoCount, double rateOfReturn) {
        //given
        Rank[] ranks = Rank.values();
        winningDetail.put(ranks[rank], count);
        //when
        Result result = new Result(winningDetail, lottoCount);
        //then
        Assertions.assertThat(result.getRateOfReturn())
                .isEqualTo(rateOfReturn);
    }
}