package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @Nested
    @DisplayName("객체 생성 테스트" )
    class CreateLottoGameTest {
        List<Lotto> lottoGroup;
        Lottos lottos;
        Lotto winningLotto;
        BonusNumber bonusNumber;

        @BeforeEach
        void setUp() {
            lottoGroup = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                    new Lotto(List.of(13, 14, 15, 16, 17, 18)));
            lottos = new Lottos(lottoGroup);

            winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            bonusNumber = new BonusNumber(winningLotto, "7" );
        }

        @Test
        void Lottos_반환_테스트() {
            // given
            LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);

            // when
            Lottos actual = lottoGame.getLottos();
            Lottos expected = lottos;

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void lottoGroup_반환_테스트() {
            // given
            LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);
            Lottos lottos = lottoGame.getLottos();

            // when
            List<Lotto> actual = lottos.getLottoGroup();
            List<Lotto> expected = lottoGroup;

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void winningLotto_반환_테스트() {
            // given
            LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);

            // when
            Lotto actual = lottoGame.getWinningLotto();
            Lotto expected = winningLotto;

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void winningNumbers_반환_태스트() {
            // given
            LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);
            Lotto winningLotto = lottoGame.getWinningLotto();

            // when
            List<Integer> actual = winningLotto.getNumbers();
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void bonusNumber_반환_테스트() {
            // given
            LottoGame lottoGame = new LottoGame(lottos, winningLotto, bonusNumber);
            BonusNumber bonusNumber = lottoGame.getBonusNumber();

            // when
            int actual = bonusNumber.getNumber();
            int expected = 7;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
