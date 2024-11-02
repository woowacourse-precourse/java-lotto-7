package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int amountToPurchase;
    private static int numOfLotto;
    private static List<Lotto> lottos = new ArrayList<>();
    public static void main(String[] args) {
        readUserInput();
    }

    public static void readUserInput(){
        readAmountToPurchase();

    }

    public static void readAmountToPurchase(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        amountToPurchase = (Integer.parseInt(input) / 1000) * 1000;
    }

    public static void createLottos(){
        numOfLotto = amountToPurchase / 1000;

        System.out.println(numOfLotto + "개를 구매했습니다.");


    }

}
