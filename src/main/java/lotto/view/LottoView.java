package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;


public class LottoView {
   public static BigInteger inputPurchaseAmount() {
       System.out.println("구입금액을 입력해 주세요.");
       try {
           return new BigInteger(Console.readLine());
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
       }
   }


   public static void printPurchaseResult(BigInteger numberOfLottos) {
       System.out.println(numberOfLottos + "개를 구매했습니다.");
   }
}
