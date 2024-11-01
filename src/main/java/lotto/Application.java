package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int lottoPrice = 1000;
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();

        boolean isNumeric = inputPrice.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해 주세요.");
        }

        int userPrice = Integer.parseInt(inputPrice);
        if (userPrice % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + lottoPrice + "단위로 입력해 주세요.");
        }
    }
}
