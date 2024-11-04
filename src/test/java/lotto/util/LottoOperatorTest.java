package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.util.LottoOperator.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoOperatorTest {

    @BeforeEach
    @DisplayName("enum count 초기화")
    void enum_count_초기화() {
        for (LottoOperator lottoOperator : LottoOperator.values()) {
            lottoOperator.setCount(0);
        }
    }

    @Test
    @DisplayName("로또 번호 2개 이하 맞으면 당첨 아님")
    void 로또_번호_2개_이하_맞으면_당첨_아님() {
        //given
        boolean isMatchBonusNumber = false;
        int matchCount = 2;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().orElse(null);

        //then
        assertThat(lottoOperator).isEqualTo(null);
    }

    @Test
    @DisplayName("로또 번호 3개 맞으면 5,000원")
    void 로또_번호_3개_맞으면_5000원() {
        //given
        boolean isMatchBonusNumber = false;
        int matchCount = 3;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().get();

        int rateOfReturn = lottoOperator.getRateOfReturn();

        //then
        assertThat(lottoOperator).isEqualTo(THREE_AGREEMENT);
        assertThat(rateOfReturn).isEqualTo(THREE_AGREEMENT.getRateOfReturn());
    }

    @Test
    @DisplayName("로또 번호 4개 맞으면 50,000원")
    void 로또_번호_4개_맞으면_50000원() {
        //given
        boolean isMatchBonusNumber = false;
        int matchCount = 4;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().get();

        int rateOfReturn = lottoOperator.getRateOfReturn();

        //then
        assertThat(lottoOperator).isEqualTo(FOUR_AGREEMENT);
        assertThat(rateOfReturn).isEqualTo(FOUR_AGREEMENT.getRateOfReturn());
    }


    @Test
    @DisplayName("로또 번호 5개 맞고 보너스 볼 다르면 1,500,000원")
    void 로또_번호_5개_맞고_보너스_볼_다르면_1500000원() {
        //given
        boolean isMatchBonusNumber = false;
        int matchCount = 5;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().get();

        int rateOfReturn = lottoOperator.getRateOfReturn();

        //then
        assertThat(lottoOperator).isEqualTo(FIVE_AGREEMENT);
        assertThat(rateOfReturn).isEqualTo(FIVE_AGREEMENT.getRateOfReturn());
    }

    @Test
    @DisplayName("로또 번호 5개, 보너스 볼 까지 맞으면 30,000,000원")
    void 로또_번호_5개_보너스_볼_까지_맞으면_30000000원() {
        //given
        boolean isMatchBonusNumber = true;
        int matchCount = 5;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().get();

        int rateOfReturn = lottoOperator.getRateOfReturn();

        //then
        assertThat(lottoOperator).isEqualTo(FIVE_AND_BONUS_AGREEMENT);
        assertThat(rateOfReturn).isEqualTo(FIVE_AND_BONUS_AGREEMENT.getRateOfReturn());
    }

    @Test
    @DisplayName("로또 번호 6개 맞으면 2,000,000,000원")
    void 로또_번호_6개_맞으면_2000000000원() {
        //given
        boolean isMatchBonusNumber = false;
        int matchCount = 6;

        //when
        LottoOperator.addCount(isMatchBonusNumber, matchCount);

        LottoOperator lottoOperator = Arrays.stream(LottoOperator.values())
                .filter(number -> number.getCount() > 0)
                .findFirst().get();

        int rateOfReturn = lottoOperator.getRateOfReturn();

        //then
        assertThat(lottoOperator).isEqualTo(SIX_AGREEMENT);
        assertThat(rateOfReturn).isEqualTo(SIX_AGREEMENT.getRateOfReturn());
    }

    @Test
    @DisplayName("로또 번호 3개, 4개, 6개 맞으면 2,000,055,000원")
    void 로또_번호_3개_4개_6개_맞으면_2000055000원() {
        //given
        LottoOperator.addCount(false, 3);
        LottoOperator.addCount(false, 4);
        LottoOperator.addCount(false, 6);


        //when
        int sumRateOfReturn = Arrays.stream(values())
                .filter(number -> number.getCount() > 0)
                .mapToInt(LottoOperator::getRateOfReturn)
                .sum();

        //then
        assertThat(sumRateOfReturn).isEqualTo(
                THREE_AGREEMENT.getRateOfReturn() +
                        FOUR_AGREEMENT.getRateOfReturn() +
                        SIX_AGREEMENT.getRateOfReturn());
    }

    @Test
    @DisplayName("로또 번호 5개, 5개+보너스볼 맞으면 31,500,000원")
    void 로또_번호_5개_5개_보너스볼_맞으면_31500000원() {
        //given
        LottoOperator.addCount(false, 5);
        LottoOperator.addCount(true, 5);

        //when
        int sumRateOfReturn = Arrays.stream(values())
                .filter(number -> number.getCount() > 0)
                .mapToInt(LottoOperator::getRateOfReturn)
                .sum();

        //then
        assertThat(sumRateOfReturn).isEqualTo(
                FIVE_AGREEMENT.getRateOfReturn() +
                        FIVE_AND_BONUS_AGREEMENT.getRateOfReturn());
    }

}