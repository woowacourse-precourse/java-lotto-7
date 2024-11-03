package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseNum;

        purchaseNum = getNum();

    }

    public static int getNum() {
        System.out.println("구입금액을 입력해 주세요.");
        int sum = Integer.parseInt(Console.readLine());

        if(sum % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.");
        }
        return sum / 1000;
    }

    public static int calculateLottoNum() {

    }
}
