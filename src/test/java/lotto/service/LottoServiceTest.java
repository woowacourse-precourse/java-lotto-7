package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void testInit(){
        lottoService = new LottoService();
    }


    @Test
    void 로또_생성_테스트(){
        // given, when
        List<Integer> published = lottoService.publishLotto();

        // then
        assertEquals(6, published.size());
        assertTrue(published.stream()
                .allMatch(num -> num >= 1 && num <= 45));
        assertEquals(6, published.stream()
                .distinct().count());
    }

    @Test
    void 로또_결과_테스트(){
        // given
        List<Integer> published = lottoService.publishLotto();

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        Integer bonusNumber = 7;

        lottoService.setNumbers(winningNumbers, bonusNumber);

        // when : calcLottoResults()
        List<LottoResult> results = lottoService.calcLottoResults();

        // then
        System.out.println(published);
        System.out.println(results);

        assertNotNull(results);
        assertNotEquals(results.size(), 0);

        boolean lottoResultInValue = results.contains(LottoResult.NO_MATCH) ||
                results.contains(LottoResult.THREE_MATCH) ||
                results.contains(LottoResult.FOUR_MATCH) ||
                results.contains(LottoResult.FIVE_MATCH) ||
                results.contains(LottoResult.FIVE_MATCH_BONUS) ||
                results.contains(LottoResult.SIX_MATCH);

        assertTrue(lottoResultInValue);
    }

    @Test
    void 로또_수익율_테스트(){
        // given
        List<Integer> published = lottoService.publishLotto();

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        Integer bonusNumber = 7;

        lottoService.setNumbers(winningNumbers, bonusNumber);

        // when : calcLottoResults()
        List<LottoResult> results = lottoService.calcLottoResults();
        System.out.println(results);

        Integer profit = lottoService.getSumLottoProfits(results);
        System.out.println(String.format("총 얻은 수익은 %s입니다.",profit));

        //then
        boolean isNegative = profit < 0;
        assertFalse(isNegative);
    }

}
