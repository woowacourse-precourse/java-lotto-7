package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨번호 및 보너스번호 테스트")
class CorrectLottoTest {

    @Test
    void 당첨번호와_보너스번호가_중복되는_경우() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        // when & then
        assertThatThrownBy(() -> BonusNumber.from("6", lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또가_2등에_당첨된다() {
        // given
        Lotto inputLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto correctNumbers = new Lotto(Arrays.asList(1,2,4,5,6,7));
        BonusNumber bonusNumber = BonusNumber.from("3", correctNumbers);
        CorrectLotto correctLotto = new CorrectLotto(
                correctNumbers, bonusNumber);

        // when
        Rank rank = correctLotto.match(inputLotto);

        // then
        assertThat(rank.getMatchCount()).isEqualTo(5);
        assertThat(rank.isContainBonusNumber()).isEqualTo(true);
    }
}