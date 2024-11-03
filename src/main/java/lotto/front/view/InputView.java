package lotto.front.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.front.parser.LottoBonusNumberParser;
import lotto.front.parser.LottoNumbersParser;
import lotto.front.parser.LottoPriceParser;
import lotto.global.dto.request.LottoDrawRequestDTO;
import lotto.global.dto.request.LottoMatchRequestDTO;
import lotto.global.dto.request.LottoPurchaseRequestDTO;
import lotto.global.enums.InputMessage;

public class InputView {
    public LottoPurchaseRequestDTO readLottoPrice() {
        System.out.println(InputMessage.LOTTO_PRICE.getMessage());
        String input = Console.readLine();
        System.out.println();
        Integer lottoPrice = LottoPriceParser.parse(input);
        return new LottoPurchaseRequestDTO(lottoPrice);
    }

    public LottoDrawRequestDTO readDrawnNumbers() {
        System.out.println(InputMessage.LOTTO_DRAWN_NUMBERS.getMessage());
        String input = Console.readLine();
        System.out.println();
        List<Integer> DrawnNumbers = LottoNumbersParser.parse(input);
        return new LottoDrawRequestDTO(DrawnNumbers);
    }

    public LottoMatchRequestDTO readBonusNumber() {
        System.out.println(InputMessage.LOTTO_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        Integer bonusNumber = LottoBonusNumberParser.parse(input);
        return new LottoMatchRequestDTO(bonusNumber);
    }
}
