package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGrade;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    Lotto winningLotto;
    int bonusNumber;
    LottoResult lottoResult;
    LottoService lottoService;

    @BeforeEach
    public void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        lottoResult = new LottoResult();
        lottoService = new LottoService();
    }

    @DisplayName("1~45사이의 중복되지 않은 랜덤한 수 6개를 생성합니다.")
    @Test
    public void 로또_번호_생성기_테스트_입니다() {
        assertDoesNotThrow(() -> new Lotto(lottoService.makeLottoNumber()));
    }

    @DisplayName("1등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_1등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FIRST_GRADE);
    }

    @DisplayName("2등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_2등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.SECOND_GRADE);
    }

    @DisplayName("3등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_3등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        assertThat(lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.THIRD_GRADE);
    }

    @DisplayName("4등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_4등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));

        assertThat(lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FOURTH_GRADE);
    }

    @DisplayName("5등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_5등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 30, 10, 20));

        assertThat(lottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FIFTH_GRADE);
    }

    @DisplayName("다른 로또 번호와의 중복되는 번호 개수를 반환한다.")
    @Test
    void 중복_로또_번호_개수_반환_테스트입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        int expected = 5;
        assertThat(lottoService.getCorrectNumberCount(lotto, winningLotto)).isEqualTo(expected);
    }

    @DisplayName("수익률 계산이 올바르게 수행되는지 테스트합니다.")
    @Test
    public void 수익률_계산_테스트_입니다() {
        double rateOfReturn = lottoService.calculateRateOfReturn(200000, 100000);
        assertThat(rateOfReturn).isEqualTo(200.0);

        rateOfReturn = lottoService.calculateRateOfReturn(150000, 100000);
        assertThat(rateOfReturn).isEqualTo(150.0);
    }

    @DisplayName("로또 당첨금 총합 계산이 올바르게 수행되는지 테스트합니다.")
    @Test
    public void 로또_당첨금_총합_계산_테스트_입니다() {
        lottoResult.addGrade(LottoGrade.FIRST_GRADE);
        lottoResult.addGrade(LottoGrade.SECOND_GRADE);
        lottoResult.addGrade(LottoGrade.THIRD_GRADE);
        lottoResult.addGrade(LottoGrade.FOURTH_GRADE);
        lottoResult.addGrade(LottoGrade.FIFTH_GRADE);

        int totalPrize = lottoService.sumLottoPrize(lottoResult);
        assertThat(totalPrize).isEqualTo(
                LottoGrade.FIRST_GRADE.getPrize() +
                        LottoGrade.SECOND_GRADE.getPrize() +
                        LottoGrade.THIRD_GRADE.getPrize() +
                        LottoGrade.FOURTH_GRADE.getPrize() +
                        LottoGrade.FIFTH_GRADE.getPrize()
        );
    }
}
