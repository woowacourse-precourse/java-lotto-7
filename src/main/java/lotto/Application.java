package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int inputPrice = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }
}
