package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.oracle.svm.core.annotate.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Long money = inputMoney();
        Long countLotto = availableLotto(money);
        List<List<Integer>> lottoList = lottoRandom(countLotto);
        haveLotto(lottoList);
        Lotto lotto = new Lotto(prizeNumbers());
        int bonusNumber = inputBonus();
        lotto.addNumber(bonusNumber);
    }

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Long money = Long.parseLong(Console.readLine());
        if (validateMoney(money)) {
            return money;
        }
        return inputMoney();
    }

    public static boolean validateMoney(Long money) {
        return money % 1000 == 0;
    }

    public static List prizeNumbers() {
        List<Integer> finalList = new ArrayList<>();

        while (true) {
            List<Integer> numberList = new ArrayList<>();
            boolean validate = inputNumber(numberList);
            if (validate) {
                finalList = numberList;
                break;
            }
        }

        return finalList;
    }

    public static boolean inputNumber(List<Integer> NumberList) {
        System.out.println("당첨번호를 입력해주세요.");
        String winNumbers = Console.readLine();

        for (String num : winNumbers.split(",", -1)) {
            if (!validateNumber(num)) {
                return false;
            }
            NumberList.add(Integer.parseInt(num));
        }
        return true;
    }

    public static int inputBonus() {
        System.out.println("보너스 번호를 입력해주세요.");
        String number = Console.readLine();

        if (!validateNumber(number)) {
            return inputBonus();
        }
        return Integer.parseInt(number);
    }

    public static boolean validateNumber(String num) {
        if (num.isBlank()) {
            return false;
        }

        if (!Pattern.matches("^[0-9]*$", num)) {
            return false;
        }

        if (Integer.parseInt(num) < 1) {
            return false;
        }

        if (45 < Integer.parseInt(num)) {
            return false;
        }

        return true;
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
