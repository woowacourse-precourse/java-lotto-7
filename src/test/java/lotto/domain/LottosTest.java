package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void 로또_리스트로부터_객체를_만들수_있다() {
        //given
        List<Lotto> lottos = List.of(Lotto.from("1,2,3,4,5,6"), Lotto.from("12,13,14,15,16,17"), Lotto.from("21,22,23,24,45,44"));

        //then
        assertThat(Lottos.of(lottos).getValue()).isEqualTo(lottos);
    }

    @Test
    void 로또가_하나도_없다면_예외_발생() {
        assertThatThrownBy(() -> Lottos.of(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}