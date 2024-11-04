package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    static Lottos sampleLottos;

    @BeforeEach
    void setUpTest() {
        sampleLottos = new Lottos();
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 4, 12, 13)));
    }
    
    @Test
    @DisplayName("선택한 수에 따른 결과 테스트")
    void Lottos_getResultTest() {
        Lotto sampleLotto = new Lotto(List.of(1, 2, 3, 12, 13, 45));
        int bonusNumber = 4;

        Result sampleResult = sampleLottos.getResult(sampleLotto, bonusNumber);

        assertThat(sampleResult.toString())
                .contains(
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 0개"
                );
    }
}
