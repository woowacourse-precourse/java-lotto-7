package lotto.view;

import lotto.dto.BonusNumberRequest;
import lotto.dto.LottoNumbersRequest;
import lotto.dto.PurchaseRequest;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public PurchaseRequest getPurchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return new PurchaseRequest(input);
    }

    public LottoNumbersRequest getLottoNumbersRequest() {
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        return new LottoNumbersRequest(input);
    }

    public BonusNumberRequest getBonusNumberRequest() {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        return new BonusNumberRequest(input);
    }
}
