package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String price() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
//        int price;
//        try {
//            price = Integer.parseInt(inputPrice);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("[ERROR] 문자열은 입력 불가합니다.");
//        }
//        if (price <= 0) {
//            throw new IllegalArgumentException("0 이하의 수는 입력할 수 없습니다.");
//        }
//        if (price % 1000 != 0) {
//            throw new IllegalArgumentException("가격은 1000원 단위로 입력 가능합니다.");
//        }
    }

    public String winningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
