package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = Integer.parseInt(Console.readLine());

        int lottoCount = lottoPrice / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }
}
