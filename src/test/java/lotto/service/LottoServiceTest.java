package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.domains.Lotto;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoServiceTest {

    private static LottoService lottoService;

    @Test
    void 로또_발행_개수_테스트() {
        int cost = 8000;
        int expectedCount = cost / lottoService.getLottoCost();
        assertEquals(expectedCount, lottoService.issueLottoCount(cost));
    }


    @Test
    void 로또_발행_개수_예외_테스트() {
        int cost = 1799;
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.issueLottoCount(cost);
        });
    }

    @Test
    void 로또_발행_테스트() {
        int cost = 8000;
        assertEquals(cost / lottoService.getLottoCost(), lottoService.issueLotto(cost).size());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/winningLottoTestFile.csv")
    void 당첨_번호_입력_테스트(String inputValue, String expected) {
        Lotto winningLotto = lottoService.setWinningLotto(inputValue);
        assertEquals(expected, winningLotto.getNumbersString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/winningLottoExceptionTestFile.csv")
    void 당첨_번호_입력_예외_테스트(String inputValue) {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.setWinningLotto(inputValue);
        });
    }

    @Test
    void 당첨_금액_테스트() {
        int[] counts = {0, 2, 3, 1, 0, 0};
        long cost = 0L;
        for (LottoRank rank : LottoRank.values()) {
            cost += (long)counts[rank.ordinal()] * rank.getGetPrize();
        }
        assertEquals(cost, lottoService.getWinningCost(counts));
    }

    @Test
    void 로또_당첨_테스트() {
        Lotto issueLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertEquals(LottoRank.SECOND, lottoService.getLottoRank(issueLotto, winningLotto, bonusNumber));
    }

    @BeforeAll
    static void beforeAll() {
        lottoService = new LottoService();
    }
}
