package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new lotto.Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new lotto.Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("구매 금액에 따른 올바른 로또 개수를 생성한다")
    void 구매_금액에_따라_올바른_로또_개수_생성() {
        // 정상적인 입력을 제공하기 위해 입력 스트림을 설정합니다.
        System.setIn(new ByteArrayInputStream("3000\n".getBytes())); // 예시 구매 금액

        List<lotto.Lotto> lottos = Application.generateLottos(3000);
        assertThat(lottos.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스_번호_중복시_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // System.in에 중복된 보너스 번호 입력을 설정
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));

        assertThatThrownBy(() -> Application.inputBonusNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복되지 않아야 합니다.");
    }


    @Test
    @DisplayName("총 수익률을 올바르게 계산한다")
    void 총_수익률_계산_정상_작동() {
        int[] matchCounts = new int[Prize.values().length];
        matchCounts[Prize.SIX_MATCHES.ordinal()] = 1; // 1등 1개
        matchCounts[Prize.FIVE_MATCHES_WITH_BONUS.ordinal()] = 0;
        matchCounts[Prize.FIVE_MATCHES.ordinal()] = 0;
        matchCounts[Prize.FOUR_MATCHES.ordinal()] = 0;
        matchCounts[Prize.THREE_MATCHES.ordinal()] = 0;

        double profitRate = Application.calculateProfitRate(matchCounts, 5); // 5장을 구매했다고 가정

        assertThat(profitRate).isEqualTo(40000000.0); // 총 상금 2,000,000,000 / (5 * 1,000) * 100
    }


}
