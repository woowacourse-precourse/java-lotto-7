package lotto.model;

import java.util.List;
import java.util.Map;
import lotto.constant.DrawType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    private Lottos lottos;
    private LottoGame lottoGame;

    @BeforeEach
    void 로또_실행_초기설정() {
        List<Lotto> allLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), new Lotto(List.of(2, 4, 5, 6, 7, 8)),
                new Lotto(List.of(2, 4, 6, 7, 8, 9)));
        lottos = new Lottos(allLotto);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoGame = new LottoGame(lottos, winningLotto, 7);

        lottoGame.draw();
    }

    @Test
    @DisplayName("전체 로또의 추첨 결과를 사용자에게 전달하는 형태로 생성한다.")
    void 로또_추첨_테스트() {
        // given & when
        Map<DrawType, Integer> result = lottoGame.generateDrawResult();

        // then
        Assertions.assertThat(result.get(DrawType.SIX_MATCH)).isEqualTo(1);
        Assertions.assertThat(result.get(DrawType.FIVE_MATCH_WITH_BONUS)).isEqualTo(1);
        Assertions.assertThat(result.get(DrawType.FIVE_MATCH_WITHOUT_BONUS)).isEqualTo(1);
        Assertions.assertThat(result.get(DrawType.FOUR_MATCH)).isEqualTo(1);
        Assertions.assertThat(result.get(DrawType.THREE_MATCH)).isEqualTo(1);
    }
}
