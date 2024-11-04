package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class LottoGetResultTest {
    @Test
    @DisplayName("당첨 없을 때")
    void noMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoAnswer answer = new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 13);

        Optional<LottoResult> result = lotto.getResult(answer);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("당첨 없을 때 (2개 매칭, 보너스 1)")
    void noMatch2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 13, 7, 8));
        LottoAnswer answer = new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 13);

        Optional<LottoResult> result = lotto.getResult(answer);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("당첨 (3개 매칭, 보너스 1)")
    void match3() {
        Lotto lotto = new Lotto(List.of(1, 2, 9, 13, 7, 8));
        LottoAnswer answer = new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 13);

        Optional<LottoResult> result = lotto.getResult(answer);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(LottoResult.FIFTH, result.get());
    }

    @Test
    @DisplayName("당첨 (5개 매칭, 보너스 1)")
    void match5bonus() {
        Lotto lotto = new Lotto(List.of(11, 10, 9, 13, 7, 8));
        LottoAnswer answer = new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 13);

        Optional<LottoResult> result = lotto.getResult(answer);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(LottoResult.SECOND, result.get());
    }

    @Test
    @DisplayName("당첨 (6개 매칭)")
    void match6() {
        Lotto lotto = new Lotto(List.of(11, 10, 9, 12, 7, 8));
        LottoAnswer answer = new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 13);

        Optional<LottoResult> result = lotto.getResult(answer);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(LottoResult.FIRST, result.get());
    }
}