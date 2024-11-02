package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        String inputPurchase = Console.readLine();

        // 구입금액 입력에 대한 예외 처리 및 구매 갯수 출력
        try {
            PurchaseCalculator pCalc = new PurchaseCalculator(inputPurchase);
            int lottoCount = pCalc.calculateLottoCount();
            System.out.println(lottoCount + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
