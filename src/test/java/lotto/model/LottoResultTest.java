package lotto.model;

import lotto.constant.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 일치하는_번호의_개수를_전달하면_해당_타입의_개수가_증가한다() {
        //given
        int count = 6;
        CorrectCount correctCount = CorrectCount.from(count);
        LottoResult lottoResult = LottoResult.create();

        //when
        lottoResult.update(correctCount);

        //then
        Assertions.assertThat(lottoResult.getResult().get(WinningType.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨금과_구입한_금액을_바탕으로_수익률을_계산한다() {
        //given
        int count = 6;
        String price = "1000";
        CorrectCount correctCount = CorrectCount.from(count);
        LottoResult lottoResult = LottoResult.create();
        LottoPurchase lottoPurchase = LottoPurchase.from(price);

        //when
        lottoResult.update(correctCount);

        //then
        Assertions.assertThat(lottoResult.getIncomeRatio(lottoPurchase))
                .isEqualTo((double) WinningType.FIRST.getPrice() / Long.parseLong(price));
    }
}
