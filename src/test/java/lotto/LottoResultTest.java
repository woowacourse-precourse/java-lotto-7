package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumbers;
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
}
