package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoView {
    public int readPurchaseAmount() throws IllegalArgumentException{
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountRaw = Console.readLine();
            int amount = Integer.parseInt(purchaseAmountRaw);

            return amount;
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException("[Error] 입력하신 구입금액은 숫자가 아닙니다. 숫자만 입력해 주세요.");
        }
    }

    public void printIssuedLottos(int purchaseCount, List<Lotto> lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }
    
}
