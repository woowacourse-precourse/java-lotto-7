package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGrade;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    Lotto winningLotto;
    int bonusNumber;

    @BeforeEach
    public void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
    }

    @DisplayName("1~45사이의 중복되지 않은 랜덤한 수 6개를 생성합니다.")
    @Test
    public void 로또_번호_생성기_테스트_입니다() {
        assertDoesNotThrow(() -> new Lotto(LottoService.makeLottoNumber()));
    }

    @DisplayName("1등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_1등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(LottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FIRST_GRADE);
    }

    @DisplayName("2등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_2등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(LottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.SECOND_GRADE);
    }

    @DisplayName("3등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_3등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        assertThat(LottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.THIRD_GRADE);
    }

    @DisplayName("4등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_4등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));

        assertThat(LottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FOURTH_GRADE);
    }

    @DisplayName("5등 로또의 당첨 결과를 반환하는 테스트입니다.")
    @Test
    public void 로또_번호_당첨_5등_결과_테스트_입니다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 30, 10, 20));

        assertThat(LottoService.checkLottoGrade(lotto, winningLotto, bonusNumber))
                .isEqualTo(LottoGrade.FIFTH_GRADE);
    }

}
