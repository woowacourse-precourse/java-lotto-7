package lotto.front.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.UUID;
import lotto.global.dto.request.LottoResultRequestDTO;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.front.util.LottoRequestParser;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;

public class LottoRequestView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String PRIZE_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해주세요.";

    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해주세요.";


    public static PurchaseLottoRequestDTO requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
        Integer purchasePrice = LottoRequestParser.parsePrice(Console.readLine());
        System.out.println();

        return new PurchaseLottoRequestDTO(purchasePrice);
    }

    public static SetPrizeLottoRequestDTO requestPrizeNumbers(UUID uuid) {
        System.out.println(PRIZE_NUMBERS_REQUEST_MESSAGE);
        List<Integer> prizeNumbers = LottoRequestParser.parsePrizeNumber(Console.readLine());
        System.out.println();

        return new SetPrizeLottoRequestDTO(uuid, prizeNumbers);
    }

    public static LottoResultRequestDTO requestBonusNumber(UUID uuid) {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
        Integer bonusNumber = LottoRequestParser.parseBonusNumber(Console.readLine());
        System.out.println();

        return new LottoResultRequestDTO(uuid, bonusNumber);
    }
}
