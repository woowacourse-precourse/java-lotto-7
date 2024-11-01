package lotto.basic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class test  {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 금액_입력_테스트() {
        // given
        InputView inputView =  new InputView();
        Money expectInput = new Money("14000");

        // when
        System.setIn(new ByteArrayInputStream(String.valueOf(expectInput.value())
                .getBytes()));
        Money actualInput = inputView.getMoney();

        // then
        assertThat(actualInput.value()).isEqualTo(expectInput.value());
    }

    @Test
    void 로또_발행_개수_테스트() {
        // given
        Money money = new Money("6000");
        FortuneMachine fortuneMachine = new FortuneMachine();

        // when
        Lottos actualValues = fortuneMachine.buyLotto(money);

        // then
        assertThat(actualValues.size()).isEqualTo(6);
    }

    @Test
    void 당첨_번호_입력_테스트() {
        // given
        InputView inputView = new InputView();
        List<Integer> expectedValues = List.of(1, 2, 3, 4, 5, 6); // 정수형으로 변경

        // when
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));
        WinningNumbers actualInput = inputView.getWinningNumbers();

        // then
        assertThat(actualInput.stream().toList()).isEqualTo(expectedValues); // getNumbers() 메서드 사용
    }


    @Test
    void 당첨_번호_오류_공백_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("1, ,3,4,5,6".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(inputView::getWinningNumbers);
    }

    @Test
    void 당첨_번호_오류_음수_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("-1,2,3,4,5,6".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(inputView::getWinningNumbers);
    }

    @Test
    void 당첨_번호_오류_문자_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("1,일,3,4,5,6".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(inputView::getWinningNumbers);
    }

    @Test
    void 당첨_번호_오류_짧은_길이_입력_테스트() {

        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("1,2,3,4,5".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getWinningNumbers);
    }

    @Test
    void 당첨_번호_오류_긴_길이_입력_테스트() {

        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6,7".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getWinningNumbers);
    }

    @Test
    void 당첨_번호_오류_범위_입력_테스트() {

        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("1,2,3,4,46, 6".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getWinningNumbers);
    }


    @Test
    void 보너스_번호_입력_테스트() {
        // given
        InputView inputView = new InputView();
        Integer expectedValues = 12;

        // when
        System.setIn(new ByteArrayInputStream("12".getBytes()));
        BonusNumber actualInput = inputView.getBonusNumber();

        // then
        assertThat(actualInput.value()).isEqualTo(expectedValues);
    }

    @Test
    void 보너스_번호_공백_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("\n".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getBonusNumber);
    }

    @Test
    void 보너스_번호_음수_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getBonusNumber);
    }

    @Test
    void 보너스_번호_문자_입력_테스트() {
        // given
        InputView inputView = new InputView();

        // when
        System.setIn(new ByteArrayInputStream("일".getBytes()));

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(inputView::getBonusNumber);
    }

    @Test
    void 번호_맞추기_당첨번호_테스트() {
        // given
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService(inputView, outputView);
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Integer expectedValues = 3;

        // when
        Integer actualValue = lottoService.countWinningNumber(winningNumbers, lotto);

        // then
        assertThat(actualValue).isEqualTo(expectedValues);
    }

    @Test
    void 번호_맞추기_보너스번호_테스트() {
        // given
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService(inputView, outputView);
        BonusNumber bonusNumber = new BonusNumber("7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 7));
        Integer expectedValues = 1;

        // when
        Integer actualValue = lottoService.countBonusNumber(bonusNumber.value(), lotto);

        // then
        assertThat(actualValue).isEqualTo(expectedValues);
    }

//    @Test
//    void 수익률_계산_테스트() {
//        // given
//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
//        LottoService lottoService = new LottoService(inputView, outputView);
//        Money money = new Money("1000");
//        String expectedValues = "500.0";
//
//        // when
//        String actualValue = lottoService.fge(money, Result.FIFTH);
//
//        // then
//        assertThat(actualValue).isEqualTo(expectedValues);
//    }



}
