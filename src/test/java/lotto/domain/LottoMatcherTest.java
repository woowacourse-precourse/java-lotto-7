package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import lotto.application.service.vo.MatchingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    private final LottoMatcher lottoMatcher = new LottoMatcher();

    @DisplayName("당첨로또와 구매로또를 비교하여 맞춘 개수와 보너스번호 맞춤 여부를 가진 객체를 반환한다.")
    @Test
    void checkMatchCount() {
        assertSimpleTest(() -> {
            Lotto lotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
            WinLotto winLotto = WinLotto.of(
                    new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                    13
            );
            MatchingInfo matchingInfo = lottoMatcher.checkMatchCount(winLotto, lotto);

            assertThat(matchingInfo.count()).isEqualTo(4);
            assertThat(matchingInfo.isEqualBonusNumber()).isEqualTo(false);
        });
    }
}
