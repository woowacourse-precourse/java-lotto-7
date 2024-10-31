package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void Lottos_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        assertThat(lottos).isEqualTo(new Lottos(List.of(lotto)));
    }

    @Test
    void 모든_로또_출력() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }
}
