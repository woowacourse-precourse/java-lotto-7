package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SecondPrizeLottoTest {

    @Test
    @DisplayName("2등 조건의 만족을 확인한다.")
    void isSatisfyPrizeRule() {
        //given
        SecondPrizeLotto secondPrizeLotto = new SecondPrizeLotto();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 5, 10), 7);

        //when
        boolean satisfyPrizeRule = secondPrizeLotto.isSatisfyPrizeRule(5, lottoNumbers, winNumbers);

        //then
        Assertions.assertThat(satisfyPrizeRule).isTrue();
    }
}