package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또가 하나도 없으면 예외가 발생한다.")
    @Test
    void 로또가_하나도_없으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> Lottos.of(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 1000개를 넘으면 예외가 발생한다")
    @Test
    void 로또가_1000개를_넘으면_예외가_발생한다() throws Exception {
        assertThatThrownBy(() -> Lottos.of(overThousandLottos()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Lotto> overThousandLottos() {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, 1001)
            .forEach(sequence -> lottos.add(new Lotto(List.of(1, 9, 18, 27, 36, 45))));

        return lottos;
    }
}