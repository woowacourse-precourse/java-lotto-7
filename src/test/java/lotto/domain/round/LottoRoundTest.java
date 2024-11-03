package lotto.domain.round;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.core.Lotto;
import lotto.domain.core.LottoRank;
import lotto.domain.input.BonusNumber;
import lotto.domain.input.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRoundTest {

    @Test
    @DisplayName("로또 회차를 생성할 수 있다.")
    void 로또_회차를_생성할_수_있다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(10, 11, 12, 13, 14, 15),
                new Lotto(20, 21, 22, 23, 24, 25),
                new Lotto(30, 31, 32, 33, 34, 35)
        );

        // When
        LottoRound round = new LottoRound(lottos);

        // Then
        assertThat(round).isNotNull();
        assertThat(round.getLottoCount()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("로또 회차는 올바른 출력 형식을 가진다.")
    void 로또_회차는_올바른_출력_형식을_가진다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(10, 11, 12, 13, 14, 15),
                new Lotto(20, 21, 22, 23, 24, 25),
                new Lotto(30, 31, 32, 33, 34, 35)
        );

        // When
        LottoRound round = new LottoRound(lottos);

        // Then
        assertThat(round).isNotNull();
        assertThat(round.toString()).isNotNull()
                .isEqualTo("""
                        [10, 11, 12, 13, 14, 15]
                        [20, 21, 22, 23, 24, 25]
                        [30, 31, 32, 33, 34, 35]""");
    }

    @Test
    @DisplayName("맞춘 번호가 0개이면 결과는 꽝이다.")
    void 맞춘_번호가_0개이면_결과는_꽝이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(11, 12, 13, 14, 15, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsOnlyNulls();
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 1개이면 결과는 꽝이다.")
    void 맞춘_번호가_1개이면_결과는_꽝이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 12, 13, 14, 15, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsOnlyNulls();
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 2개이면 결과는 꽝이다.")
    void 맞춘_번호가_2개이면_결과는_꽝이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 13, 14, 15, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsOnlyNulls();
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 3개이면 결과는 5등이다.")
    void 맞춘_번호가_3개이면_결과는_5등이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 14, 15, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsExactly(LottoRank.MATCH_THREE_NUMBER);
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 4개이면 결과는 4등이다.")
    void 맞춘_번호가_4개이면_결과는_4등이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 4, 15, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsExactly(LottoRank.MATCH_FOUR_NUMBER);
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 5개이고 보너스 번호를 맞추지 못했다면 결과는 3등이다.")
    void 맞춘_번호가_5개이고_보너스_번호를_맞추지_못했다면_결과는_3등이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 4, 5, 16)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsExactly(LottoRank.MATCH_FIVE_NUMBER);
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 5개이고 보너스 번호도 맞췄다면 결과는 2등이다.")
    void 맞춘_번호가_5개이고_보너스_번호를_맞추지_못했다면_결과는_2등이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 4, 5, 10)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsExactly(LottoRank.MATCH_FIVE_NUMBER_WITH_BONUS_NUMBER);
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }

    @Test
    @DisplayName("맞춘 번호가 6개이면 결과는 1등이다.")
    void 맞춘_번호가_6개이면_결과는_1등이다() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(1, 2, 3, 4, 5, 6)
        );
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(10);

        // When
        LottoRound round = new LottoRound(lottos);
        List<LottoRank> matchResult = round.getMatchResult(winningNumber, bonusNumber);

        // Then
        assertThat(round).isNotNull();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult).containsExactly(LottoRank.MATCH_SIX_NUMBER);
        assertThat(matchResult.size()).isEqualTo(lottos.size());
    }
}