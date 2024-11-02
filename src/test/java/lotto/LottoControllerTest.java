package lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoController;
import lotto.validator.BonusNumberValidator;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Controller 클래스 테스트")
public class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(
            new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator()),
            new BonusNumberValidator(new DefaultRangeValidator()), new InputView());
    }

    @Test
    void 구입금액이_1000원_단위가_아닐_때_예외가_발생한다() {
        int purchasePrice = 10500;
        assertThatThrownBy(() -> lottoController.validatePurchaseAmount(purchasePrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구입 금액은 1,000원 단위로만 가능합니다.");
    }

    @Test
    void 구매_금액을_1000으로_나누어_발행_횟수를_구한다() {
        //given
        int purchasePrice = 100000;

        //when
        int countOfPublish = lottoController.getCountOfPublish(purchasePrice);

        //then
        assertEquals(countOfPublish, 100);
    }

    @Test
    void 연속된_쉼표가_입력된_경우_예외가_발생한다() {
        String inputWinningNumber = "1,,2,3,4,5,6";
        assertThatThrownBy(() -> lottoController.validateInputWinnigNumber(inputWinningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력에 쉼표가 연속적으로 입력되었습니다.");
    }

    @Test
    void 입력_당첨_번호를_콤마로_분리한다() {
        List<String> expectedList = Arrays.asList("1", "2", "3", "4", "5", "6");
        String input = "1,2,3,4,5,6";
        List<String> winningNumbers = lottoController.splitByComma(input);
        assertEquals(expectedList, winningNumbers);
    }

    @Test
    void 문자열_리스트를_Integer_리스트로_변환한다() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> integerList = lottoController.stringListToIntList(stringList);
        assertEquals(expectedList, integerList);
    }

    @Test
    void 잘못된_입력_형식으로_예외가_발생한다() {
        String input = "1@2";
        assertThatThrownBy(() -> lottoController.parseInt(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 형식이 올바르지 않습니다.");
    }

    @Test
    void 구매_금액에_맞게_로또_발행하는지_확인() {
        // Given
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("3000\n1,2,3,4,5,6\n7\n".getBytes());
        System.setIn(in);

        //when
        lottoController.setUp();
        lottoController.publishLottoSetup();

        //then
        assertEquals(lottoController.getCountOfPublish(3000), lottoController.getPublishLottos().size());
    }

}
