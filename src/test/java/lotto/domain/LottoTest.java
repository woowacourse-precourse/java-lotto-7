package lotto.domain;

import static lotto.utils.Constants.END_NUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    public static List<LottoNumber> toLottoNumList(List<Integer> integerList) {
        return integerList.stream().map(LottoNumber::new).toList();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 6개 미만 테스트")
    void 개수_부족_테스트() {
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                list.add(j + 1);
            }
            List<LottoNumber> lottoNumbers = toLottoNumList(list);
            assertThatThrownBy(() -> new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호 오름차순 확인")
    void test1() {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> reversedList = numList.stream().sorted(Comparator.reverseOrder()).toList();

        Lotto expected = new Lotto(toLottoNumList(numList));
        Lotto result = new Lotto(toLottoNumList(reversedList));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 넘버 중복 불가 확인")
    void test2() {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNumber> lottoNumbers = toLottoNumList(numList);
        Lotto lotto = new Lotto(lottoNumbers);

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            assertThatThrownBy(() -> lotto
                    .validBonusNum(new LottoNumber(finalI)))
                    .as(String.valueOf(finalI))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    @DisplayName("null 주입 테스트")
    void test3() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("toString 동작 테스트")
    void test4() {
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.toString()).hasToString("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("숫자 포함 테스트")
    void test5() {
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        for (int i = 1; i < 7; i++) {
            assertTrue(lotto.hasNumber(new LottoNumber(i)));
        }
    }

    @Test
    @DisplayName("숫자 미포함 테스트")
    void test6() {
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        for (int i = 7; i < END_NUM; i++) {
            assertFalse(lotto.hasNumber(new LottoNumber(i)));
        }
    }

    @Test
    @DisplayName("맞은 개수 확인 테스트")
    void test7() {
        // given
        List<LottoNumber> lottoNumbers = toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        List<LottoNumber> compareLottoNumbers = toLottoNumList(List.of(6, 5, 4, 3, 2, 45));
        Lotto compareLotto = new Lotto(compareLottoNumbers);

        int expected = 5;

        // when
        int matchedCount = lotto.matchCount(compareLotto);

        assertThat(matchedCount).isEqualTo(expected);
    }
}
