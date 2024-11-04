package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoDomain;

public class Amount {


    public static int inputBuyPrice() {

        System.out.println("구매할 로또금액을 입력해주세요");
        String input = Console.readLine();

        isNumber(input);
        int num = Integer.parseInt(input);

        return  num/1000;
    }

    private static void isNumber( String input) {

        try {
            int price = Integer.parseInt(input); // 입력된 문자열을 정수로 변환
            isNumer(price);
            LottoDomain.setPrice(price); // 가격 설정
        } catch (NumberFormatException e) {
            //System.out.println(InputValidationMessage.MESSAGE_NUMBER.getMessage()); // 오류 메시지 출력
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_NUMBER.getMessage());
        }
    }

    private static void isNumer(int price) {

        if (!judgeNumber(price)) {
           // System.out.println(InputValidationMessage.MESSAGE_MODULAR.getMessage());
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_MODULAR.getMessage());
        }

    }

    private static boolean judgeNumber(int price) {

        return price % 1000 == 0 && price >= 1000;

    }



}
