package lotto;

import static lotto.InputUtil.isClearedByNum;
import static lotto.InputUtil.isNumeric;
import static lotto.Lotto.LOTTO_BASIC_PRICE;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        // 구입 금액 입력 받고 유효성 검사
        int purchasesCount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.\n");
                String price = Console.readLine();

                isNumeric(price);
                isClearedByNum(price, LOTTO_BASIC_PRICE); // 구입금액이 1000원 단위인지 확인

                purchasesCount = Integer.parseInt(price) / LOTTO_BASIC_PRICE;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요\n 예외 메세지: " + e.getMessage());
            }
        }

        // 구매 개수 출력
        System.out.println(purchasesCount + "개를 구매했습니다.\n");
    }

}
