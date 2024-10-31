package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @Test
    void 구매할_로또_장수를_계산합니다() {
        assertEquals(3, LottoService.calculateLottoCount(3000));
        assertEquals(5, LottoService.calculateLottoCount(5000));
    }
}
