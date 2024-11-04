package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

    @ParameterizedTest
    @CsvSource({"4", "5", "6"})
    @DisplayName("랜덤 숫자들을 가지는 로또를 원하는 갯수만큼 생성할 수 있다.")
    void 원하는_갯수만큼_로또_생성_테스트(int size) {
        // given, when
        Lottos lottos = Lottos.randomFrom(size);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("각 로또에 대한 추첨 결과들을 통해 전체 추첨 결과를 생성한다.")
    void 전체_추첨_결과_생성_테스트() {
        // given
        List<Lotto> allLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 3, 5, 7, 9, 11)),
                new Lotto(List.of(2, 4, 5, 6, 7, 8)));
        Lottos lottos = new Lottos(allLotto);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        DrawResults result = lottos.getDrawResult(winningLotto, 7);

        // then
        assertThat(result.getDrawResults()).isEqualTo(
                List.of(new DrawResult(6, false), new DrawResult(3, false), new DrawResult(4, false)));
    }
}
