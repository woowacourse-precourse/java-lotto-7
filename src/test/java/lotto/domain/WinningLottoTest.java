package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void init(){
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        winningLotto = new WinningLotto(winningNumbers,bonusNumber);
    }


    @DisplayName("List와 int를 생성자에 넣어주어 WinningLotto 객체 생성")
    @Test
    void 당첨번호_보너스번호_담은_객체_생성(){
        Assertions.assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("보너스 숫자와 비교하여 같은 숫자라면 True를 반환해줍니다")
    @Test
    void 보너스_숫자_일치(){
        Assertions.assertThat(winningLotto.isBonusNumber(7)).isTrue();
    }

    @DisplayName("보너스 숫자와 비교하여 다른 숫자라면 False를 반환해줍니다")
    @ParameterizedTest
    @ValueSource(ints = {23,31,41,29,16})
    void 보너스_숫자_불일치(int input){
        Assertions.assertThat(winningLotto.isBonusNumber(input)).isFalse();
    }
}
