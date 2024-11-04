package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.lottoNumber.Lotto;
import lotto.model.lotto.lottoNumber.Lottos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    private static Lottos lottos;

    @BeforeAll
    static void setUp() {
        lottos = new Lottos(new ArrayList<>(Arrays.asList(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8)))
        )));
    }

    @Test
    @DisplayName("[success] 로또 개수만큼 로또 객체를 리스트에 담아 저장한다.")
    void saveLottosList() {
        assertThat(lottos.lottos().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[fail] getter로 반환한 로또 리스트를 수정할 경우 예외가 발생한다.")
    void fail_IfModifyLottos() {
        Lotto newLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8)));
        List<Lotto> lottoList = lottos.lottos();

        assertThatThrownBy(() -> lottoList.add(newLotto))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
