package lotto.model;

import lotto.utils.constants.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMemberTest {

    private LottoMember lottoMember;

    @BeforeEach
    void setUp() {
        lottoMember = new LottoMember();
    }

    @Test
    void 로또를_구매하고_확인할_수_있다() {
        // given: 로또 객체 두 개 생성
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when: 로또를 구매 목록에 추가
        lottoMember.setPurchasedLotto(lotto1);
        lottoMember.setPurchasedLotto(lotto2);

        // then: 구매한 로또 목록이 정확히 두 개의 로또를 포함해야 함
        List<Lotto> purchasedLotto = lottoMember.getPurchasedLotto();
        assertThat(purchasedLotto).hasSize(2);
        assertThat(purchasedLotto).containsExactly(lotto1, lotto2);
    }

    @Test
    void 로또_결과를_저장하고_확인할_수_있다() {
        // given: 로또 결과 리스트 생성
        List<LottoPrize> results = Arrays.asList(LottoPrize.LOTTO_MATCH_1ST, LottoPrize.LOTTO_MATCH_2ND);

        // when: 로또 결과를 LottoMember에 저장
        lottoMember.setLottoResult(results);

        // then: 저장된 로또 결과가 올바른지 확인
        List<LottoPrize> lottoResults = lottoMember.getLottoResult();
        assertThat(lottoResults).hasSize(2);
        assertThat(lottoResults).containsExactly(LottoPrize.LOTTO_MATCH_1ST, LottoPrize.LOTTO_MATCH_2ND);
    }

    @Test
    void 구입한_로또_목록이_비어있으면_확인할_수_있다() {
        // given: LottoMember 객체는 초기화 상태
        // when: 구입한 로또 목록을 가져옴
        List<Lotto> purchasedLotto = lottoMember.getPurchasedLotto();

        // then: 구입한 로또 목록은 비어 있어야 함
        assertThat(purchasedLotto).isEmpty(); // 초기에는 구입한 로또 목록이 비어있어야 함
    }

}
