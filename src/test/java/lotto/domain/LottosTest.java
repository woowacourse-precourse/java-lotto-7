package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Nested
    @DisplayName("객체 생성 테스트" )
    class CreateLottosTest {
        @Test
        void Lottos_는_로또_리스트를_가진다() {
            // given
            List<Lotto> lottoGroup = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(7, 8, 9, 10, 11, 12)));

            Lottos lottos = new Lottos(lottoGroup);

            // when
            List<Lotto> actual = lottos.getLottoGroup();
            List<Lotto> expected = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(7, 8, 9, 10, 11, 12)));

            // then
            assertThat(actual)
                    .usingRecursiveFieldByFieldElementComparator()
                    .containsExactlyInAnyOrderElementsOf(expected);
        }

        @Test
        void Lottos_의_lottoQuantity_는_로또_리스트의_크기이다() {
            // given
            List<Lotto> lottoGroup = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(7, 8, 9, 10, 11, 12)), new Lotto(List.of(13, 14, 15, 16, 17, 18)));

            Lottos lottos = new Lottos(lottoGroup);

            // when
            int actual = lottos.getLottoQuantity();
            int expected = 3;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
