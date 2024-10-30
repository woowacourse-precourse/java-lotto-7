package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottos.Lotto;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호_개수_미달_예외_처리(){
        List<Integer> result = new ArrayList<>(List.of(
                1,2,3,4,5
        ));
        assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_개수_초과_예외_처리(){
        List<Integer> result = new ArrayList<>(List.of(
                1,2,3,4,5,6,7,8
        ));
        assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_범위_예외_처리(){
        List<Integer> result = new ArrayList<>(List.of(
                48,1,2,3,4,5
        ));
        assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_로또_번호_예외_처리(){
        List<Integer> result = new ArrayList<>(List.of(
                1,1,2,3,4,5
        ));
        assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

}