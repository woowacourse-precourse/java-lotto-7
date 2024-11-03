package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int buy = Input.buyMoney(); // 구입 금액 입력 받기
        LottoPurchase purchase = new LottoPurchase(buy/1000); // 로또 번호 생성
        purchase.Print(); // 생성한 로또 번호 print

        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = Console.readLine(); // 당첨 번호

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine(); // 보너스 번호
    }
}
