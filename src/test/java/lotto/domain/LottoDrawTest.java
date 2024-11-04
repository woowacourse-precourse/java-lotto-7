package lotto.domain;

import lotto.enums.LottoPrice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoDrawTest {
    @Test
    void purchasesCount_초기화_테스트() {
        int purchaseAmount = 5000;
        List<Lotto> lotto = new ArrayList<>(Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        LottoDraw lottoDraw = new LottoDraw(purchaseAmount, lotto);

        assertEquals(
                purchaseAmount / LottoPrice.LOTTO_PRICE_UNIT.getPrice(),
                lottoDraw.getPurchasesCount()
        );
    }

    @Test
    void lottoDrawNumbers_초기화_테스트() {
        List<Lotto> lotto = new ArrayList<>(Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        LottoDraw lottoDraw = new LottoDraw(2000, lotto);

        assertEquals(lotto, lottoDraw.getLottoDrawNumbers());
    }
}