package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 결과 테스트")
public class LottoResultTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 번호 개수를 반환한다.")
    void 성공_당첨번호개수_유효한파라미터() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        String winningNumberList = "1, 2, 3, 20, 25, 36";

        WinningLottoNumbers winningNumbers = WinningLottoNumbers.from(winningNumberList);

        // when
        int matchCount = lotto.countMatchNumbers(winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는지 확인한다.")
    void 성공_보너스번호체크_유효한파라미터() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        String bonusNumber = "7";
        BonusNumber parsedBonusNumber = BonusNumber.from(bonusNumber);

        // when
        boolean hasBonus = lotto.matchBonusNumber(parsedBonusNumber);

        // then
        assertThat(hasBonus).isTrue();
    }

    @Test
    @DisplayName("당첨 등수를 계산한다.")
    void 성공_당첨등수_유효한파라미터() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("당첨 통계를 생성한다.")
    void 성공_당첨통계생성_유효한파라미터() {
        // given
        String winningNumberList = "1, 2, 3, 4, 5, 8";
        String bonusNumber = "7";

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        WinningNumbers winningNumbers = WinningNumbers.from(WinningLottoNumbers.from(winningNumberList),
                BonusNumber.from(bonusNumber));

        // when
        LottoResult result = LottoResult.of(lottos, winningNumbers);

        // then
        assertThat(result.getCountByRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCountByRank(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void 성공_수익률계산_유효한파라미터() {
        // given
        String winningNumberList = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "7";

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        WinningNumbers winningNumbers = WinningNumbers.from(WinningLottoNumbers.from(winningNumberList),
                BonusNumber.from(bonusNumber));

        LottoResult result = LottoResult.of(lottos, winningNumbers);

        // when
        double profitRate = result.calculateProfitRate();

        // then
        assertThat(profitRate).isEqualTo(0);
    }
}
