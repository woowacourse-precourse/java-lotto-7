package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FourthPrizeLottoTest {

    @Test
    void isSatisfyPrizeRule() {
        //given
        FourthPrizeLotto fourthPrizeLotto = new FourthPrizeLotto();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 4, 9, 10), 7);

        //when
        boolean satisfyPrizeRule = fourthPrizeLotto.isSatisfyPrizeRule(4, lottoNumbers, winNumbers);

        //then
        Assertions.assertThat(satisfyPrizeRule).isTrue();
    }
}