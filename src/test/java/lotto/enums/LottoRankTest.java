package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankTest {

    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoRankTest() {
        winningLotto = WinningLotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 6), CONFIG);
        bonusNumber = BonusNumber.ofNumberAndWinningLottoAndConfig(7, winningLotto, CONFIG);
    }

    private static Stream<Lotto> provideLottoAndLottoRank() {
        return Stream.of(
                Lotto.ofNumbersAndConfig(List.of(1, 8, 9, 10, 11, 12), CONFIG),
                Lotto.ofNumbersAndConfig(List.of(1, 7, 8, 9, 10, 11), CONFIG),
                Lotto.ofNumbersAndConfig(List.of(1, 2, 8, 9, 10, 11), CONFIG),
                Lotto.ofNumbersAndConfig(List.of(1, 2, 7, 8, 9, 10), CONFIG),
                Lotto.ofNumbersAndConfig(List.of(8, 9, 10, 11, 12, 13), CONFIG),
                Lotto.ofNumbersAndConfig(List.of(7, 8, 9, 10, 11, 12), CONFIG)
        );
    }

    @Test
    @DisplayName("로또 번호가 6개 일치한다면, 1등을 반환한다.")
    void 로또_번호_6개_일치_테스트() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 6), CONFIG);

        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또 번호가 5개 일치하고, 보너스 번호가 일치한다면, 2등을 반환한다.")
    void 로또_번호_5개_일치_보너스번호_일치_테스트() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 7), CONFIG);

        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("로또 번호가 5개 일치한다면, 3등을 반환한다.")
    void 로또_번호_5개_일치_테스트() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 5, 8), CONFIG);

        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("로또 번호가 4개 일치한다면, 4등을 반환한다.")
    void 로또_번호_4개_일치_테스트() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 4, 8, 9), CONFIG);

        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("로또 번호가 3개 일치한다면, 5등을 반환한다.")
    void 로또_번호_3개_일치_테스트() {
        Lotto lotto = Lotto.ofNumbersAndConfig(List.of(1, 2, 3, 8, 9, 10), CONFIG);

        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH_PLACE);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 3개 미만으로 일치한다면, 탈락을 반환한다.")
    @MethodSource("provideLottoAndLottoRank")
    void 로또_번호_3개_미만_일치_테스트(Lotto lotto) {
        LottoRank lottoRank = LottoRank.ofLottoAndWinningLottoAndBonusNumber(lotto, winningLotto, bonusNumber);

        assertThat(lottoRank).isEqualTo(LottoRank.FAIL);
    }


}
