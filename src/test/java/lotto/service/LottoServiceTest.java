package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp(){
        lottoService = new LottoService();
    }

    @Test
    void 로또_발급(){
        int count = 3;
        Lottos lottos = lottoService.issueLottos(count);

        assertNotNull(lottos);
        assertEquals(count, lottos.getLottos().size());

        lottos.getLottos()
                .stream()
                .peek(lotto -> {
                    lotto.getNumbersValue()
                            .forEach(number -> assertTrue(0<number && number<46) );
                })
                .forEach(lotto -> assertEquals(6, lotto.getNumbersValue().size()));
    }

    @Test
    void 로또_당첨(){
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1,2,3,4,5,6));
        winningNumbers.setBonusNumber(7);

        Lotto first_prize_lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto second_prize_lotto = new Lotto(List.of(1,2,3,4,5,7));

        Lottos lottos = new Lottos(List.of(first_prize_lotto, second_prize_lotto));

        LottoResult result = lottoService.getLottoResult(lottos, winningNumbers);

        assertEquals(result.prizeCount(LottoPrize.FIRST), 1);
        assertEquals(result.prizeCount(LottoPrize.SECOND), 1);

    }

}