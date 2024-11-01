package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FifthPrizeLottoTest {

    @Test
    @DisplayName("5등 조건의 만족을 확인한다.")
    void isSatisfyPrizeRule() {
        //given
        FifthPrizeLotto fifthPrizeLotto = new FifthPrizeLotto();
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinNumbers winNumbers = new WinNumbers(List.of(1, 2, 3, 9, 10, 11), 7);

        //when
        boolean satisfyPrizeRule = fifthPrizeLotto.isSatisfyPrizeRule(3, lottoNumbers, winNumbers);

        //then
        Assertions.assertThat(satisfyPrizeRule).isTrue();
    }
}