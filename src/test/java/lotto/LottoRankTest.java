package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void 상금테스트(){
        LottoRank lottoRank = LottoRank.FIRST;
        assertEquals(lottoRank.getPrice(),2000000000);
    }
    @Test
    void 이름테스트(){
        LottoRank lottoRank = LottoRank.SECOND;
        assertEquals(lottoRank.getName(),"2등");
    }


}