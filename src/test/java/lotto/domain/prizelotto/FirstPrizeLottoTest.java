package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstPrizeLottoTest {

    @Test
    @DisplayName("1등 조건의 만족을 확인한다.")
    void isSatisfyPrizeRule() {
        //given
        FirstPrizeLotto fifthPrizeLotto = new FirstPrizeLotto();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        boolean satisfyPrizeRule = fifthPrizeLotto.isSatisfyPrizeRule(6, lottoNumbers, winNumbers);

        //then
        Assertions.assertThat(satisfyPrizeRule).isTrue();
    }
}