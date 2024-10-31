package io.lotto;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

class OutPutLottoHandlerTest {

    private final OutPutLottoHandler outPutLottoHandler = new OutPutLottoHandler();

    @DisplayName("생성된 로또 번호들 출력 확인")
    @Test
    void test() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        Lotto lotto3 = new Lotto(List.of(20, 21, 22, 23, 24, 25));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        // when
        List<String> lottoNumbers = outPutLottoHandler.showLottos(lottos);

        // then
        assertThat(lottoNumbers).hasSize(3)
                .containsExactlyInAnyOrder(
                        "1, 2, 3, 4, 5, 6",
                        "40, 41, 42, 43, 44, 45",
                        "20, 21, 22, 23, 24, 25"
                );
    }
}