package lotto.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LottoServiceImplTest {
    private final LottoServiceImpl lottoService = new LottoServiceImpl();

    @Test
    void 구입_금액에_해당하는_만큼_로또_발행() {
        int price = 10000;
        int expectedResult = 10;

        int actualCount = lottoService.calculateLottoCount(price);

        assertEquals(expectedResult, actualCount);
    }
}