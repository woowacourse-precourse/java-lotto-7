package lotto.controller.winningLottoController;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.testUtil.testDouble.InputHandlerStub;
import org.junit.jupiter.api.Test;

class DefaultWinningLottoControllerTest {

    @Test
    void 당첨번호를_반환한다() {
        //given
        InputHandlerStub inputHandlerStub = new InputHandlerStub();
        DefaultWinningLottoController sut = new DefaultWinningLottoController(inputHandlerStub);
        inputHandlerStub.stubWinningNumbers(1, 2, 3, 4, 5, 6);

        //when
        Lotto result = sut.readWinningNumbers();

        //then
        assertThat(result.contains(Number.from(1))).isTrue();
        assertThat(result.contains(Number.from(2))).isTrue();
        assertThat(result.contains(Number.from(3))).isTrue();
        assertThat(result.contains(Number.from(4))).isTrue();
        assertThat(result.contains(Number.from(5))).isTrue();
        assertThat(result.contains(Number.from(6))).isTrue();
    }

    @Test
    void 당첨로또를_반환한다() {
        //given
        InputHandlerStub inputHandlerStub = new InputHandlerStub();
        DefaultWinningLottoController sut = new DefaultWinningLottoController(inputHandlerStub);
        inputHandlerStub.stubBonusNumber(7);
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when
        WinningLotto result = sut.createWinningLotto(winningNumbers);

        //then
        assertThat(result.matchLotto(winningNumbers).isPresent()).isTrue();
        assertThat(result.matchLotto(winningNumbers).get()).isEqualTo(LottoPrize.FRIST_PRIZE);
    }
}
