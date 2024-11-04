package lotto.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void hitCount가_3개면_THREE_MATCHES_반환(){
        LottoResult result = LottoResult.findByHitCount(3, 0);

        Assertions.assertThat(result).isEqualTo(LottoResult.THREE_MATCHES);
    }
    @Test
    void hitCount가_4개면_FOUR_MATCHES_반환(){
        LottoResult result = LottoResult.findByHitCount(4, 0);

        Assertions.assertThat(result).isEqualTo(LottoResult.FOUR_MATCHES);
    }

    @Test
    void hitCount가_5개면_FIVE_MATCHES_반환(){
        LottoResult result = LottoResult.findByHitCount(5, 0);

        Assertions.assertThat(result).isEqualTo(LottoResult.FIVE_MATCHES);
    }

    @Test
    void hitCount가_5개_bonusCount가_1개면_FIVE_AND_BONUS_MATCHES_반환(){
        LottoResult result = LottoResult.findByHitCount(5, 1);

        Assertions.assertThat(result).isEqualTo(LottoResult.FIVE_AND_BONUS_MATCHES);
    }
    @Test

    void hitCount가_6개면_SIX_MATCHES_반환(){
        LottoResult result = LottoResult.findByHitCount(6, 0);

        Assertions.assertThat(result).isEqualTo(LottoResult.SIX_MATCHES);
    }



}