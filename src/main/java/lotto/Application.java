package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Long money = inputMoney();
        Long countLotto = availableLotto(money);
        List<List<Integer>> lottoList = lottoRandom(countLotto);
        haveLotto(lottoList);
    }

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Long money = Long.parseLong(Console.readLine());
        if (validMoney(money)) {
            return money;
        }
        return inputMoney();
    }

    public static boolean validMoney(Long money) {
        return money % 1000 == 0;
    }

    public static Long availableLotto(Long money) {
        Long countLotto = money / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");
        return countLotto;
    }

    public static List<List<Integer>> lottoRandom(Long countLotto) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for (long i = 0; i < countLotto; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(lottoNumbers);
        }
        return lottoList;
    }

    public static void haveLotto(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

}
