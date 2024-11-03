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
            // 숫자가 아닐경우 예외처리
            int price = isNotNum(input);

            // 1000원 단위가 아닐 경우 예외처리
            if (price % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위가 아닐 경우 예외 처리");
            }

            return price;
        } catch (IllegalArgumentException e) {
            return getPrice();
        }
    }

    public static int isNotNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닐경우 예외 처리");
        }
    }
}
