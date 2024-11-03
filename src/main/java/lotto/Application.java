package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int price = getPrice();

        final int numOfLotto = price/1000;
        System.out.println(numOfLotto + "개를 구매했습니다.");

    }

    private static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        final String input = Console.readLine();
        try {
            int price = isNotNum(input);

            if (price % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
            }

            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrice();
        }
    }

    public static int isNotNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
