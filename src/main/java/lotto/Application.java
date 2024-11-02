package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해주세요.");
        String priceInput=Console.readLine();
        int price=Integer.parseInt(priceInput);

        //가격 정상 입력 테스트용
        System.out.println("price: "+price);
    }
}
