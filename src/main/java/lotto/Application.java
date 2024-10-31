package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.service.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        final int purchaseAmount = getPurchaseAmount();
        final int lottoCount = purchaseAmount / LottoConstants.LOTTO_PRICE.getValue();

        System.out.println(lottoCount+"개를 구매했습니다.");

        List<Lotto> lottoTickets = purchaseLottos(lottoCount);
        lottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));

    }

    private static int getPurchaseAmount() {
        int amount;

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                amount = validateAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        return amount;
    }

    private static int validateAmount(final String input) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        if (amount <= 0 || amount % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }

        return amount;
    }

    private static List<Lotto> purchaseLottos(final int lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = Lotto.generateLottoNumber();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }
}
