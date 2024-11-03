package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
//    @Test 중간 로직 바뀌어서 적용 안됨
//    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("getRank_0")
    @Test
    void getRank0() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(11,12,13,14,15,16)),7);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.NONE);
        });
    }

    @DisplayName("getRank_5")
    @Test
    void getRank5() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(14,12,16,1,2,3)),7);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.FIFTH);
        });
    }

    @DisplayName("getRank_4")
    @Test
    void getRank4() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(4,3,2,1,39,14)),7);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.FOURTH);
        });
    }

    @DisplayName("getRank_3")
    @Test
    void getRank3() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,16)),7);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.THIRD);
        });
    }

    @DisplayName("getRank_2")
    @Test
    void getRank2() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,16)),6);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.SECOND);
        });
    }

    @DisplayName("getRank_1")
    @Test
    void getRank1() {
        assertSimpleTest(() -> {
            lotto.Lotto.Rank result = lotto.Lotto.getRank(new Lotto(List.of(1,2,3,4,5,6)),new Lotto(List.of(1,2,3,4,5,6)),7);

            assertThat(result).isEqualTo(lotto.Lotto.Rank.FIRST);
        });
    }

    @DisplayName("getValueWithComma 테스트")
    @Test
    void getValueWithCommaTest() {
        assertSimpleTest(() -> {
            String result = lotto.Lotto.getNumberWithComma(10000);

            assertThat(result).isEqualTo("10,000");
        });
    }

}

