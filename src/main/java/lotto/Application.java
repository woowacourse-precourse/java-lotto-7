package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        Integer totalPrice = Integer.parseInt(readLine());
        if(totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 정수를 입력해야 합니다.");
        }
    }
}
