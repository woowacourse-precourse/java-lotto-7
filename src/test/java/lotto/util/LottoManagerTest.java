package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @DisplayName("당첨 로또 발급")
    @Test
    void getWinningLotto(){
        LottoManager lottoManager = new LottoManager();
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));
        assertThatThrownBy(()->lottoManager.getWinningLotto(numbers, 7)).isInstanceOf(IllegalArgumentException.class);

        numbers.add(6);
        assertThatThrownBy(()->lottoManager.getWinningLotto(numbers, 6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoManager.getWinningLotto(numbers, 0)).isInstanceOf(IllegalArgumentException.class);

        Lotto lotto = lottoManager.getWinningLotto(numbers, 7);
        assertThat(lotto.getNumbers()).containsExactly(1,2,3,4,5,6);
        assertThat(lotto.getBonusNumber()).isEqualTo(7);

    }

    @DisplayName("금액에 따라 로또 구입")
    @Test
    void purchaseLotto(){
        LottoManager lottoManager = new LottoManager();
        int amount = 0;

        assertThatThrownBy(()->lottoManager.purchaseLotto(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoManager.purchaseLotto(-1000)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoManager.purchaseLotto(5001)).isInstanceOf(IllegalArgumentException.class);

        ArrayList<Lotto> lottos = lottoManager.purchaseLotto(5000);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("랜덤으로 로또 하나 발급")
    @Test
    void draqLotto(){
        LottoManager lottoManager = new LottoManager();

        Lotto lotto = lottoManager.drawLotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        HashSet<Integer> set = new HashSet<>();
        for (int n : lotto.getNumbers()){
            set.add(n);
        }
        assertThat(set.size()).isEqualTo(6);
    }

    @DisplayName("당첨 결과를 HashMap으로 구하기")
    @Test
    void getWinningResult(){
        LottoManager lottoManager = new LottoManager();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,31)));
        lottos.add(new Lotto(List.of(1,2,3,4,31,32)));
        lottos.add(new Lotto(List.of(1,2,3,31,32,33)));
        Lotto winningLotto = lottoManager.getWinningLotto(List.of(1,2,3,4,5,6), 7);

        HashMap<LottoPrize, Integer> result = lottoManager.getWinningResult(lottos, winningLotto);
        assertThat(result.get(LottoPrize.FIFTH)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoPrize.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(1);

        lottos.clear();
        assertThatThrownBy(()->lottoManager.getWinningResult(lottos, winningLotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률으로 구하기")
    @Test
    void getProfitRate(){
        LottoManager lottoManager = new LottoManager();
        HashMap<LottoPrize, Integer> result = new HashMap<>();
        result.put(LottoPrize.FIFTH, 1);

        double profitRate = lottoManager.getProfitRate(result, 8000);
        assertThat(profitRate).isEqualTo(62.5);


        result.put(LottoPrize.THIRD, 1);
        profitRate = lottoManager.getProfitRate(result, 8000);
        assertThat(profitRate).isEqualTo(18812.5);

        result.clear();
        profitRate = lottoManager.getProfitRate(result, 8000);
        assertThat(profitRate).isEqualTo(0);

        assertThatThrownBy(()->lottoManager.getProfitRate(result, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoManager.getProfitRate(result, 0)).isInstanceOf(IllegalArgumentException.class);
    }

}