package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        System.out.println("구입금액을 입력해 주세요.");
        amountToPurchase = readAmountToPurchase();

        numOfLotto = calcNumOfLottos();
    }

    private static int readAmountToPurchase(){
        String input = Console.readLine();
        return (Integer.parseInt(input) / 1000) * 1000;
    }

    private static int calcNumOfLottos(){
        return numOfLotto = amountToPurchase / 1000;
    }

}
