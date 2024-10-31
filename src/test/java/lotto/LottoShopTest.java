package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @Test
    public void 천원_단위가_아니면_오류(){
        assertThrows(IllegalArgumentException.class, () -> {
            LottoShop lottoShop = new LottoShop(11300);
        });
    }

    @Test
    public void 카운트테스트(){
        LottoShop lottoShop = new LottoShop(2000);
        assertEquals(lottoShop.getCount(), 2);
    }

    @Test
    public void issueLottoTest(){
        LottoShop lottoShop = new LottoShop(2000);
        lottoShop.issueLotto();
        assertEquals(lottoShop.getLottos().size(),2);
    }

}