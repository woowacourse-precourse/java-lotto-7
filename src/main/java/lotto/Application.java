package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static int amountToPurchase;
    private static int numOfLotto;
    private static List<Lotto> lottos;
    private static List<Integer> winningNumbers;
    public static void main(String[] args) {
        readUserInput();
    }

    public static void readUserInput(){
        System.out.println("구입금액을 입력해 주세요.");
        amountToPurchase = readAmountToPurchase();

        numOfLotto = calcNumOfLottos();
        System.out.println(numOfLotto + "개를 구매했습니다.");

        lottos = createLottos();
        lottos.forEach(System.out::println);

        System.out.println("당첨 번호를 입력해 주새요.");
        winningNumbers = readWinningNumbers();


    }

    private static int readAmountToPurchase(){
        String input = Console.readLine();
        return (Integer.parseInt(input) / 1000) * 1000;
    }

    private static int calcNumOfLottos(){
        return numOfLotto = amountToPurchase / 1000;
    }

    private static List<Lotto> createLottos(){
        lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    private static List<Integer> readWinningNumbers(){
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
