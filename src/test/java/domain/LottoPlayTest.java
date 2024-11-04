package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPlayTest {


    @DisplayName("로또를 추첨한다.")
    @Test
    void drawLotto() {
        // given
        User user = new User(3000);
        Lotto lotto = generateLotto(List.of(1, 2, 3, 10, 11, 12));
        user.updateLottos(List.of(lotto));

        LottoMachine lottoMachine = new LottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPlay lottoPlay = new LottoPlay(user, lottoMachine);

        // when
        lottoPlay.drawLottos();

        // then
        assertAll(
                () -> assertEquals(user.getLottos().size(), user.getRanks().size()),
                () -> assertThat(user.getRanks()).containsExactlyInAnyOrder(
                        Rank.FIFTH
                )
        );
    }

    @DisplayName("로또 번호가 3개 미만으로 일치할 때, 아무 당첨도 없다.")
    @Test
    void determineNoRankWhenAllLottoMatchLessThanThreeNumber() {
        // given
        User user = new User(3000);
        Lotto lotto1 = generateLotto(List.of(11, 12, 13, 10, 16, 22));
        Lotto lotto2 = generateLotto(List.of(13, 14, 15, 16, 17, 18));
        Lotto lotto3 = generateLotto(List.of(19, 20, 21, 22, 23, 24));
        user.updateLottos(List.of(lotto1, lotto2, lotto3));

        LottoMachine lottoMachine = new LottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPlay lottoPlay = new LottoPlay(user, lottoMachine);

        // when
        lottoPlay.drawLottos();

        // then
        assertAll(
                () -> assertEquals(user.getLottos().size(), user.getRanks().size()),
                () -> assertThat(user.getRanks()).containsExactlyInAnyOrder(
                        Rank.NO_RANK,
                        Rank.NO_RANK,
                        Rank.NO_RANK
                )
        );
    }

    @DisplayName("5개가 일치하고, 보너스 번호가 일치할 때 2등으로 결정된다.")
    @Test
    void determineSecondRankWhenFiveNumberMatchAndBonusNumberMatch() {
        // given
        User user = new User(3000);
        Lotto lotto1 = generateLotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto2 = generateLotto(List.of(13, 14, 15, 16, 17, 18));
        Lotto lotto3 = generateLotto(List.of(19, 20, 21, 22, 23, 24));
        user.updateLottos(List.of(lotto1, lotto2, lotto3));

        LottoMachine lottoMachine = new LottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPlay lottoPlay = new LottoPlay(user, lottoMachine);

        // when
        lottoPlay.drawLottos();

        // then
        assertAll(
                () -> assertEquals(user.getLottos().size(), user.getRanks().size()),
                () -> assertThat(user.getRanks()).containsExactlyInAnyOrder(
                        Rank.NO_RANK,
                        Rank.NO_RANK,
                        Rank.SECOND
                )
        );
    }

    @DisplayName("5개가 일치하고, 보너스 번호가 일치하지 않을 때 3등으로 결정된다.")
    @Test
    void determineThirdRankWhenFiveNumberMatchAndBonusNumberMisMatch() {
        // given
        User user = new User(3000);
        Lotto lotto1 = generateLotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto2 = generateLotto(List.of(13, 14, 15, 16, 17, 18));
        Lotto lotto3 = generateLotto(List.of(19, 20, 21, 22, 23, 24));
        user.updateLottos(List.of(lotto1, lotto2, lotto3));

        LottoMachine lottoMachine = new LottoMachine(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPlay lottoPlay = new LottoPlay(user, lottoMachine);

        // when
        lottoPlay.drawLottos();

        // then
        assertAll(
                () -> assertEquals(user.getLottos().size(), user.getRanks().size()),
                () -> assertThat(user.getRanks()).containsExactlyInAnyOrder(
                        Rank.NO_RANK,
                        Rank.NO_RANK,
                        Rank.THIRD
                )
        );
    }

    private Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
