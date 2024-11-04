package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("구입금액을 입력해주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");

            }
            LottoGame lottoGame = new LottoGame(purchaseAmount);
            lottoGame.printLottos();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
