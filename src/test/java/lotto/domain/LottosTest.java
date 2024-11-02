package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("로또 목록 생성 성공 검증")
    void 로또_목록_생성_검증() {
        //given
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        //when
        Lottos lottos = new Lottos(validLottos);

        //then
        assertThat(lottos.getLottos()).isEqualTo(validLottos);
    }

    @Test
    @DisplayName("로또 목록 크기 반환 검증")
    void 로또_목록_크기_반환_검증() {
        //given
        List<Lotto> validLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );

        //when
        Lottos lottos = new Lottos(validLottos);

        //then
        assertThat(lottos.getLottoCount()).isEqualTo(3);
    }
}
