package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int getMoney() throws Exception {
        int money = 0;
        System.out.print("금액를 입력하세요 : ");
        money = Integer.parseInt(Console.readLine());
        if (money % 1000 != 0){
            throw new Exception();
        }
        return money;
    }

    public static void main(String[] args) {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        while (true){
            try{
                int money = getMoney();
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]");
            }
        }
    }
}
