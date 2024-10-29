package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoServiceTest {

    private static LottoService lottoService;

    @Test
    void 로또_발행_개수_테스트() {
        int cost = 8000;
        int expectedCount = cost / lottoService.getLottoCost();
        assertEquals(expectedCount, lottoService.issueRottoCount(cost));
    }


    @Test
    void 로또_발행_개수_예외_테스트() {
        int cost = 1799;
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.issueRottoCount(cost);
        });
    }

    @BeforeAll
    static void beforeAll() {
        lottoService = new LottoService();
    }
}
