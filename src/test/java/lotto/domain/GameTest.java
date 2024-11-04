package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 로또_등록_테스트_성공() {
        // given & when
        List<Integer> lottoNumbers1 = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumbers2 = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers1));
        lottos.add(new Lotto(lottoNumbers2));

        // then
        assertEquals(lottos.size(), 2);
    }

    @Test
    void 로또_등록_테스트_실패_100개_초과() {
        // given & when
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < 102; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        // when
        IllegalArgumentException exception =
                assertThrowsExactly(IllegalArgumentException.class, () -> new Game(lottos));

        // Then
        assertEquals("[ERROR] 로또는 최대 100개까지만 발행할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 당첨_결과_확인() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),  // correct 3
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),  // correct 4
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // correct 5
                new Lotto(List.of(1, 2, 3, 4, 5, 10)), // correct 5 + bonus
                new Lotto(List.of(1, 2, 3, 4, 5, 6))   // correct 6
        );

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        Game game = new Game(lottos, winningLotto, bonusNumber);

        // when
        int[] results = game.compareNumbers(winningLotto);

        // then
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, results);
    }

    @Test
    void 수익률_계산_테스트_100_이상() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        int purchaseAmount = 1000;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        Game game = new Game(lottos, winningLotto, bonusNumber);

        // when
        int[] results1 = game.compareNumbers(winningLotto);
        double rateOfReturn = game.calculateRateOfReturn(purchaseAmount, results1);

        // then
        assertEquals(rateOfReturn, 500);
    }

    @Test
    void 수익률_계산_테스트_100() {
        // 수익률 100%
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11))
                );
        int purchaseAmount = 5000;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        Game game = new Game(lottos, winningLotto, bonusNumber);

        // when
        int[] results = game.compareNumbers(winningLotto);
        double rateOfReturn = game.calculateRateOfReturn(purchaseAmount, results);

        // then
        assertEquals(rateOfReturn, 100);
    }

    @Test
    void 수익률_계산_테스트_100_미만() {
        // 수익률 100% 미만
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 11)),
                new Lotto(List.of(1, 2, 3, 8, 9, 11))
                );

        int purchaseAmount = 10000;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        Game game = new Game(lottos, winningLotto, bonusNumber);

        // when
        int[] results = game.compareNumbers(winningLotto);
        double rateOfReturn = game.calculateRateOfReturn(purchaseAmount, results);

        // then
        assertEquals(rateOfReturn, 50.0);
    }
}
