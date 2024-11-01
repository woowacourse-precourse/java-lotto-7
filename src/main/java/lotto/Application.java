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
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input) / 1000;
    }

    private static List<List<Integer>> generateLottoNumbers(int money) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        System.out.println("\n" + money + "개를 구매했습니다.");
        for (int i = 0; i < money; i++) {
            List<Integer> singleLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(singleLotto);
            lottoNumbers.add(singleLotto);
        }
        return lottoNumbers;
    }

    private static void printLotto(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

}
