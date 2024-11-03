package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {




    @Test
    void 로또_구매_금액에_따른_개수_생성_테스트(){
        //given
        LottoGame lottoGame = new LottoGame(5000);

        //when
        List<Lotto> userLottoList = lottoGame.generateUserLotto();

        //then
        assertEquals(5, userLottoList.size());
    }


}
