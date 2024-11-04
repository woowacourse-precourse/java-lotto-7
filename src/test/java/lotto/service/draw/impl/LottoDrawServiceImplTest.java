package lotto.service.draw.impl;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoDrawServiceImplTest {

    private LottoDrawServiceImpl lottoDrawService;

    @BeforeEach
    void setUp() {
        lottoDrawService = new LottoDrawServiceImpl();
    }

    @Test
    @DisplayName("getLottoDrawResult는 올바른 LottoDrawResult 객체를 반환해야 한다.")
    void 로또_추첨_객체_반환_테스트() {

        //given
        Lotto drewLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        //when
        LottoDrawResult result = lottoDrawService.getLottoDrawResult(drewLotto, bonusNumber);

        // then
        assertNotNull(result);
        assertEquals(drewLotto, result.getDrewLotto());
        assertEquals(bonusNumber, result.getBonusNumber());
    }

    @Test
    @DisplayName("로또 당첨번호와 보너스 번호가 중복될 때 오류를 반환해야 한다")
    void 로또_추첨_당첨번호와_보너스_번호가_중복될_때_오류_반환() {

        Lotto drewLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LottoDrawResult result = lottoDrawService.getLottoDrawResult(drewLotto, bonusNumber);
        });
    }
}