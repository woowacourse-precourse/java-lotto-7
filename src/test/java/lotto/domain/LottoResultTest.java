package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private WinningChecker checker;
    private List<Lotto> lottos;
    private int purchaseAmount;

    @BeforeEach
    void setUp(){
        checker = new WinningChecker(List.of(1, 2, 3, 4, 5, 6), 7);
        purchaseAmount = 10000;
        lottos = LottoGenerator.generateLottos(10);
    }

    @Test
    void 당첨_통계_계산_테스트(){
        LottoResult result = new LottoResult(lottos, checker, purchaseAmount);
        assertThat(result.calculateYield()).isNotNull();
    }
}
