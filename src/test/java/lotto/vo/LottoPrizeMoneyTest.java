package lotto.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPrizeMoneyTest {

    @Test
    void hitCount가_3개면_THREE_MATCHES_반환(){
        LottoPrizeMoney result = LottoPrizeMoney.findByHitCount(3, 0);

        Assertions.assertThat(result).isEqualTo(LottoPrizeMoney.THREE_MATCHES);
    }
    @Test
    void hitCount가_4개면_FOUR_MATCHES_반환(){
        LottoPrizeMoney result = LottoPrizeMoney.findByHitCount(4, 0);

        Assertions.assertThat(result).isEqualTo(LottoPrizeMoney.FOUR_MATCHES);
    }

    @Test
    void hitCount가_5개면_FIVE_MATCHES_반환(){
        LottoPrizeMoney result = LottoPrizeMoney.findByHitCount(5, 0);

        Assertions.assertThat(result).isEqualTo(LottoPrizeMoney.FIVE_MATCHES);
    }

    @Test
    void hitCount가_5개_bonusCount가_1개면_FIVE_AND_BONUS_MATCHES_반환(){
        LottoPrizeMoney result = LottoPrizeMoney.findByHitCount(5, 1);

        Assertions.assertThat(result).isEqualTo(LottoPrizeMoney.FIVE_AND_BONUS_MATCHES);
    }
    @Test

    void hitCount가_6개면_SIX_MATCHES_반환(){
        LottoPrizeMoney result = LottoPrizeMoney.findByHitCount(6, 0);

        Assertions.assertThat(result).isEqualTo(LottoPrizeMoney.SIX_MATCHES);
    }



}