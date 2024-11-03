package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Selling selling = new Selling();
        Benefit benefit = new Benefit();

        try{
            System.out.println("구입 금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            Lotto[] userLottos = selling.purchaseLottos(amount);

        }
    }
}
