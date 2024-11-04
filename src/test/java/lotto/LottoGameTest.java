package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    void 로또_갯수_출력() {
        lottoGame.setBuyQuantity(7000);
        int purchaseCount = lottoGame.getPurchaseCount();
        assertThat(purchaseCount)
                .isEqualTo(7);
    }
    @Test
    void 로또_번호_생성() {
        Lotto lotto = lottoGame.generateLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertThat(new HashSet<>(numbers)).hasSize(6); // 중복 생성 확인
        assertThat(numbers).hasSize(6); // 사이즈 확인
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45); // 범위확인

    }


}