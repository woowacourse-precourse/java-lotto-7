package lotto.domain.model.lotto.service;

import lotto.common.config.Factory;
import lotto.common.constant.LottoConst;
import lotto.domain.model.lotto.result.LottoSummary;
import lotto.domain.model.user.Lotto;
import lotto.domain.model.user.LottoRank;
import lotto.domain.model.user.User;
import lotto.domain.model.user.UserPurchasedLotto;
import lotto.domain.utils.TestLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;


class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        Factory factory = new Factory();
        lottoService = factory.lottoService();
    }


    @Nested
    @DisplayName("issueByAmount 메서드는")
    class IssueByAmountTest {

        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 3000, 4000})
        @DisplayName("금액에 맞게 로또를 발행하여 리턴한다.")
        void issueByAmount(int input) {
            //given
            //when
            List<Lotto> lottos = lottoService.issueByAmount(input);

            //then
            Assertions.assertThat(lottos).hasSize(input / LottoConst.LOTTO_PRICE);
        }
    }

    @Nested
    @DisplayName("evaluateUserLotto 메서드는")
    class evaluateUserLottoTest {

        @Test
        @DisplayName("유저가 구매한 로또와 당첨 번호를 비교한다.")
        void evaluateUserLotto() {
            //given
            int amount = 5000;
            Lotto lotto1 = TestLotto.createTestLotto(List.of(1, 2, 3, 4, 5, 6)); //1등
            Lotto lotto2 = TestLotto.createTestLotto(List.of(2, 3, 4, 5, 6, 7)); //2등
            Lotto lotto3 = TestLotto.createTestLotto(List.of(2, 3, 4, 5, 6, 8)); //3등
            Lotto lotto4 = TestLotto.createTestLotto(List.of(3, 4, 5, 6, 7, 8)); //4등
            Lotto lotto5 = TestLotto.createTestLotto(List.of(4, 5, 6, 7, 8, 9)); //5등

            List<Lotto> lottos = TestLotto.createTestLottos(lotto1, lotto2, lotto3, lotto4, lotto5);
            UserPurchasedLotto userPurchasedLotto = UserPurchasedLotto.create(lottos);

            User user = User.create(amount, userPurchasedLotto);
            Lotto winningLotto = TestLotto.createTestLotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;

            //when
            LottoSummary evaluatedSummary = lottoService.evaluateUserLotto(user, winningLotto, bonusNumber);

            //then
            LottoRank first = LottoRank.FIRST;
            LottoRank second = LottoRank.SECOND;
            LottoRank third = LottoRank.THIRD;
            LottoRank fourth = LottoRank.FOURTH;
            LottoRank fifth = LottoRank.FIFTH;
            HashMap<LottoRank, Long> resultMap = new HashMap<>();
            resultMap.put(first, 1L);
            resultMap.put(second, 1L);
            resultMap.put(third, 1L);
            resultMap.put(fourth, 1L);
            resultMap.put(fifth, 1L);
            LottoSummary testSummary = LottoSummary.create(resultMap);

            Assertions.assertThat(evaluatedSummary.getSize()).isEqualTo(testSummary.getSize());
        }
    }
}