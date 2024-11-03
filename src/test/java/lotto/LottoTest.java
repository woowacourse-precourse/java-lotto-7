package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void WinningNumbersRangeCheck() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 맞는 로또의 개수를 반환 하는지 확인")
    @Test
    void lottoCountTest(){
        assertThat(Lotto.lottoCount(5000)).isEqualTo(5);
        assertThat(Lotto.lottoCount(8000)).isEqualTo(8);
    }


    @DisplayName("구매한 로또 번호를 담은 리스트의 사이즈 확인")
    @Test
    void purchaseLottoNumbersCountTest(){
        assertThat(Lotto.purchaseLottoNumbers(8).length).isEqualTo(8);
    }

    @DisplayName("구매한 로또 번호의 길이 확인")
    @Test
    void purchaseLottoNumbersSizeTest(){
        int[][] lottoNumbers = Lotto.purchaseLottoNumbers(8);
        for(int[] lottoNumber: lottoNumbers){
            assertThat(lottoNumber.length).isEqualTo(6);
        }
    }

    // 구매한 로또 번호의 범위 확인
    private boolean lottoNumberRangeCheck(int[] lottoNumbers){
        for(int lottoNumber: lottoNumbers){
            if(lottoNumber<1 || lottoNumber>45){
                return false;
            }
        }
        return true;
    }

    @DisplayName("구매한 로또 번호가 1- 45 사이인지 확인")
    @Test
    void purchaseLottoNumbersRangeTest(){
        int[][] lottoNumbers = Lotto.purchaseLottoNumbers(8);
        for(int[] lottoNumber: lottoNumbers){
            assertThat(lottoNumberRangeCheck(lottoNumber)).isTrue();
        }
    }

    // 구매한 로또 번호 중복 확인
    private boolean lottoNumbersUniqueCheck(int[] lottoNumbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int number: lottoNumbers){
            uniqueNumbers.add(number);
        }
        return uniqueNumbers.size() == lottoNumbers.length;
    }

    @DisplayName("구매한 로또 번호가 중복되는지 확인")
    @Test
    void purchaseLottoNumbersUniqueTest(){
        int[][] lottoNumbers = Lotto.purchaseLottoNumbers(8);
        for(int[] lottoNumber: lottoNumbers){
            assertThat(lottoNumbersUniqueCheck(lottoNumber)).isTrue();
        }
    }
}
