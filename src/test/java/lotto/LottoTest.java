package lotto;

import lotto.enumerate.Rank;
import lotto.model.Lotto;
import lotto.model.WinNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enumerate.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 로또가1등인경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,5,6","7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(FIRST);
    }
    @Test
    void 로또가2등인경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,5,9","6");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(SECOND);
    }
    @Test
    void 로또가3등인경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,5,8","7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(THIRD);
    }
    @Test
    void 로또가4등인경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,8,9","7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(FOURTH);
    }@Test
    void 로또가5등인경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,8,9,10","7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(FIFTH);
    }

    @Test
    void 로또가당첨안된경우테스트() {
        // given
        WinNumber winNumber = new WinNumber("8,9,10,11,12,13","7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        System.out.println("=====Logic Start=====");

        Rank actual = lotto.findRank(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertThat(actual).isEqualTo(NONE);
    }
}
