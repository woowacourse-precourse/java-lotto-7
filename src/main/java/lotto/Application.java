package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoPriceString = Console.readLine();
        Integer lottoPrice;

        try {
            lottoPrice = Integer.parseInt(lottoPriceString);
            if(lottoPrice <= 0 || lottoPrice%1000 != 0){
                throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }
}
