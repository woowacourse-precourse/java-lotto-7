package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoListTest {

    @Test
    void 로또_구매갯수_테스트(){
        int lottoNum = LottoList.lottoNumber(15000);

        assertEquals(lottoNum, 15);
    }

}