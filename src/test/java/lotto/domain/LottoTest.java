package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_생성시_오름차순으로_정렬된다(){
        Lotto lotto=new Lotto(List.of(6,5,4,3,2,1));

        Lotto expected=new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto).usingRecursiveComparison().isEqualTo(expected);
    }

   @Test
    void 보너스_여부에_따라_서로_다른_enum을_반환한다(){
        Lotto lotto=new Lotto(List.of(6,5,4,3,2,1));

        assertAll(
                ()->assertEquals(lotto.findBonus(5,6), BonusExistence.HAVE_BONUS),
                ()->assertEquals(lotto.findBonus(5,10), BonusExistence.NO_BONUS),
                ()->assertEquals(lotto.findBonus(4,10), BonusExistence.IRRELEVANT)
        );

    }
}
