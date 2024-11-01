package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondPrizeLottoTest {

    @Test
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