package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.lottoController.LottoController;
import lotto.controller.lottoStaticsController.LottoStaticsController;
import lotto.controller.moneyController.DefaultMoneyController;
import lotto.controller.moneyController.MoneyController;
import lotto.controller.winningLottoController.DefaultWinningLottoController;
import lotto.controller.winningLottoController.WinningLottoController;
import lotto.io.OutputHandler;
import lotto.io.OutputParser;
import lotto.testUtil.testDouble.InputHandlerStub;
import lotto.testUtil.testDouble.NumberPickerFake;
import lotto.testUtil.testDouble.WriterFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoApplicationFacadeTest {

    private InputHandlerStub inputHandlerStub;
    private WriterFake writerFake;
    private NumberPickerFake numberPickerFake;
    private LottoApplicationFacade sut;

    @BeforeEach
    void setUp() {
        this.inputHandlerStub = new InputHandlerStub();
        this.writerFake = new WriterFake();
        OutputHandler outputHandler = new OutputHandler(writerFake, new OutputParser());
        this.numberPickerFake = new NumberPickerFake();

        MoneyController moneyController = new DefaultMoneyController(inputHandlerStub);
        LottoController lottoController = new LottoController(outputHandler, numberPickerFake);
        WinningLottoController winningLottoController = new DefaultWinningLottoController(inputHandlerStub);
        LottoStaticsController lottoStaticsController = new LottoStaticsController(outputHandler);

        this.sut = new LottoApplicationFacade(
                moneyController,
                lottoController,
                winningLottoController,
                lottoStaticsController
        );
    }

    @Test
    void 로또_애플리케이션을_실행한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //when
        sut.run();

        //then
        assertThat(writerFake.getOutputs().get(0)).contains(
                "3개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]"
        );
        assertThat(writerFake.getOutputs().get(1)).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
        assertThat(writerFake.getOutputs().get(2)).contains(
                "총 수익률은 1,666.7%입니다."
        );
    }

    @Test
    void 구매금액이_1000보다_작으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(999);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상, 100000원 이하 입니다.");
    }

    @Test
    void 구매금액이_100000보다_크면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(1000001);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상, 100000원 이하 입니다.");
    }

    @Test
    void 구매금액이_1000단위가_아니면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(1001);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 단위입니다.");
    }

    @Test
    void 당첨번호에_1보다_낮은_숫자가_있으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(0, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 당첨번호에_45보다_큰_숫자가_있으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(46, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 당첨번호에_중복된_숫자가_있으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(3, 3, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(9);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    void 보너스번호에_1보다_작은_숫자가_있으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(0);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 보너스번호에_15보다_큰_숫자가_있으면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(0);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        //given
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18
        );
        inputHandlerStub.stubPurchaseCost(3000);
        inputHandlerStub.stubWinningNumbers(3, 4, 5, 6, 7, 8);
        inputHandlerStub.stubBonusNumber(3);

        //expected
        assertThatThrownBy(() -> sut.run())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 당첨 번호와 중복되었습니다.");
    }
}
