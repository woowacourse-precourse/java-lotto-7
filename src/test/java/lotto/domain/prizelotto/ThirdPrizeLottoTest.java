package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThirdPrizeLottoTest {

    @Test
    @DisplayName("3등 조건의 만족을 확인한다.")
    void isSatisfyPrizeRule() {
        //given
        ThirdPrizeLotto thirdPrizeLotto = new ThirdPrizeLotto();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 22);
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 10), 7);

        //when
        boolean satisfyPrizeRule = thirdPrizeLotto.isSatisfyPrizeRule(5, lottoNumbers, winNumbers);

        //then
        Assertions.assertThat(satisfyPrizeRule).isTrue();
    }
}