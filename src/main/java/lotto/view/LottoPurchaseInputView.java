package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.LottoValidator;
import lotto.model.Lotto;

public class LottoPurchaseInputView {
    public int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            LottoValidator.validateStringInput(input);
            int lottoAmount = Integer.parseInt(input);
            LottoValidator.validatePurchase(lottoAmount);
            return lottoAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public int numberOfLotto(int lottoAmount) {
        int lottoTickets = lottoAmount / 1000;
        System.out.println(lottoTickets + "개를 구매했습니다.");
        return lottoTickets;
    }

    public void makeRandomLottos(int count) {
        List<Lotto> lottos = Lotto.makeRandomLottos(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
