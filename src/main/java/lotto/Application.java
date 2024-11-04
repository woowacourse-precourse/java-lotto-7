package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int totalLotto = Integer.parseInt(Console.readLine());
        if(totalLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }
}
