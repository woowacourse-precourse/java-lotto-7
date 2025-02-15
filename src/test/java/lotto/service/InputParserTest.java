package lotto.service;

import java.io.ByteArrayInputStream;
import lotto.common.Constants;
import lotto.view.InputView;
import lotto.dto.LottoPurchaseDTO;
import lotto.util.Validator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    public void setUp() {
        Validator validator = new Validator();
        InputView inputView = new InputView();
        inputParser = new InputParser(inputView, validator);
    }

    @Test
    public void testParsePrice() {
        String simulatedInput = "10000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        int price = inputParser.parsePrice();
        assertEquals(10000, price);
    }

    @Test
    public void testParseLottoNumbers() {
        String simulatedInput = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        List<Integer> lottoNumbers = inputParser.parseLottoNumbers();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lottoNumbers);
    }

    @Test
    public void testParseBonusNumber() {
        String simulatedInput = "7";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = inputParser.parseBonusNumber(lottoNumbers);
        assertEquals(7, bonusNumber);
    }

    @Test
    public void testLottoPurchaseDTO() {
        String simulatedInput = "10000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        LottoPurchaseDTO purchaseDTO = inputParser.lottoPurchaseDTO();
        assertEquals(10000, purchaseDTO.getPrice());
        assertEquals(10000 / Constants.LOTTO_PRICE, purchaseDTO.getLottoCount());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), purchaseDTO.getLottoNumbers());
        assertEquals(7, purchaseDTO.getBonusNumber());
    }

}
