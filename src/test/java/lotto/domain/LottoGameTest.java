package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGameTest {

    @Test
    @DisplayName("로또 랭킹 계산 테스트")
    void lottoRankCalculateTest(){
        //given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        CustomLotto customLotto = new CustomLotto(numbers,19);
        LottoGame lottoGame = LottoGame.of(5000, customLotto);

        lottoGame.calculateLottoRank();
    }
}