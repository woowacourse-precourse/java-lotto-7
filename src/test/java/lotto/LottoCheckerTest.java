package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCheckerTest {

    @DisplayName("발행 번호와 당첨 번호를 비교해 일치하는 수를 테스트한다.")
    @Test
    void 발행_번호와_당첨_번호를_비교해_일치하는_수를_테스트한다() {
        Lotto issuedLotto = new Lotto(List.of(1, 2, 11, 12, 13, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int result = LottoChecker.getMatchCount(issuedLotto, winningLotto);
        assertEquals(3, result);
    }

}