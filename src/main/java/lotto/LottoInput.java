package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    public int PurchaseInput(){
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(Console.readLine());
        return purchasePrice;
    }
}
