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
    void 당첨_결과_확인_() {
        // given & when
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5+i);
            lottos.add(new Lotto(numbers));
        }

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Game game = new Game(lottos);
        game.compareNumbers(winningNumbers);
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

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;
        Game game = new Game(lottos, winningNumbers, bonusNumber);

        // when
        int[] results = game.compareNumbers(winningNumbers);

        // then
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, results);
    }


    @Test
    void 당첨_결과_확인_5개_일치() {

    }

    @Test
    void 당첨_결과_확인_6개_일치() {

    }

    @Test
    void 당첨_결과_확인_5개_보너스번호_일치() {

    }

    @Test
    void 수익률_계산_테스트() {

    }
}
