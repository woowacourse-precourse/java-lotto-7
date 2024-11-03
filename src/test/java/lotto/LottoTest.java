package lotto;

import java.util.stream.Stream;
import lotto.constant.PrizeTier;
import lotto.utils.NumberList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("Lotto should return matched Prize tier")
    @ParameterizedTest()
    @MethodSource("verifyLottoPrizeTier")
    void verifyLottoGetPrizeTier(List<Integer> userLottoNumbers, List<Integer> winLottoNumbers, int bonusNumber, PrizeTier result ){
        Lotto userLotto = new Lotto(userLottoNumbers);
        Lotto winLotto = new Lotto(winLottoNumbers);

        assertThat(userLotto.checkPrizeTier(winLotto,bonusNumber)).isEqualTo(result);
    }

    static Stream<Arguments> verifyLottoPrizeTier(){
        return Stream.of(
                Arguments.arguments(List.of(1,2,3,4,5,6),List.of(1,2,3,4,5,6), 7 ,PrizeTier.FIRST),
                Arguments.arguments(List.of(1,2,3,4,5,7),List.of(1,2,3,4,5,6), 7 ,PrizeTier.SECOND),
                Arguments.arguments(List.of(1,2,3,4,5,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.THIRD),
                Arguments.arguments(List.of(1,2,3,4,44,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.FORTH),
                Arguments.arguments(List.of(1,2,3,4,7,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.FORTH),
                Arguments.arguments(List.of(1,2,3,43,44,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.FIFTH),
                Arguments.arguments(List.of(1,2,3,7,44,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.FIFTH),
                Arguments.arguments(List.of(1,2,42,43,44,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.NONE),
                Arguments.arguments(List.of(1,2,7,43,44,45),List.of(1,2,3,4,5,6), 7 ,PrizeTier.NONE)
        );
    }
}
