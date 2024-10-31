package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<LottoNum> lottoNums = toLottoNumList(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> new Lotto(lottoNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<LottoNum> lottoNums = toLottoNumList(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new Lotto(lottoNums))
                .isInstanceOf(IllegalArgumentException.class);
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
        List<LottoNum> lottoNums = toLottoNumList(numList);
        Lotto lotto = new Lotto(lottoNums);

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            assertThatThrownBy(() -> lotto
                    .validBonusNum(new LottoNum(finalI)))
                    .as(String.valueOf(finalI))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    @DisplayName("null 테스트")
    void test3() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }


    private List<LottoNum> toLottoNumList(List<Integer> integerList) {
        return integerList.stream().map(LottoNum::new).toList();
    }
}
