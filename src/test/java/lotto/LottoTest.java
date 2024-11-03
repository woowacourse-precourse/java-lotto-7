package lotto;

import lotto.utils.NumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("Lotto data should be same to input ")
    @Test
    void verifyAccessingLottoData(){

        NumberList numberList = new NumberList();
        numberList.generateRandomNumberList();

        Lotto lotto = new Lotto(numberList);

        List<Integer> lottoNumber = lotto.getNumbers();

        assertThat(lottoNumber.size()).isEqualTo(numberList.size());
        for(int i = 0; i < lottoNumber.size(); ++i){
            assertThat(lottoNumber.get(i)).isEqualTo(numberList.get(i));
        }
    }

    @DisplayName("Lotto should return deep copied")
    @Test
    void verifyLottoDataNotShallowCopy(){

        NumberList numberList = new NumberList();
        numberList.generateRandomNumberList();

        Lotto lotto = new Lotto(numberList);

        List<Integer> lottoNumber = lotto.getNumbers();
        int size = lottoNumber.size();

        assertThat(size).isEqualTo(numberList.size());
        lottoNumber.clear();

        assertThat(lotto.getNumbers().size()).as("Internal numbers is not cleared").isEqualTo(numberList.size());

    }
}
