package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        playLotto();
    }

    private static void playLotto() {
        int money = inputMoney();
        List<List<Integer>> lottoNumbers = generateLottoNumbers(money);
        printLotto(lottoNumbers);
    }

    public static int inputMoney() {
        printMoneyInputMessage();
        String input = Console.readLine();
        return parseToInt(input) / 1000;
    }

    private static int parseToInt(String input) {
        int intValue;
        try {
            intValue = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return intValue;
    }

    private static void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static List<List<Integer>> generateLottoNumbers(int money) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        printPurchaseCountInputMessage(money);
        for (int i = 0; i < money; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(singleLotto);
            lottoNumbers.add(singleLotto);
        }
        return lottoNumbers;
    }

    private static void printPurchaseCountInputMessage(int money) {
        System.out.printf("\n%d개를 구매했습니다.\n", money);
    }

    private static void printLotto(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

}
