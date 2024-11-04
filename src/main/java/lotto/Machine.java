package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Machine {

    ResultCalculator resultCalculator;


    Machine() {
        resultCalculator = new ResultCalculator();

    }

    private void moneyValidator(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 원으로 나누어 떨어져야 합니다.");
        }
    }

    private void printLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            StringBuilder stringBuilder = new StringBuilder("[");
            lottoNumber.addNumberForStringBuilder(stringBuilder);
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("]");
            System.out.println(stringBuilder);
        }
    }

    private void validatorNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 수여야 합니다.");
            }
        }
    }

    private List<Integer> generator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validatorNumbers(numbers);

        return numbers;
    }

    private List<Integer> convertStringToInteger(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : strings) {
            numbers.add(Integer.parseInt(number));
        }

        validatorNumbers(numbers);

        return numbers;
    }

    private void validateBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        for (Integer number : winNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자와 중복이 되면 안됩니다.");
            }
        }
    }

    private void handleNumbers(List<Lotto> lottos) {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<String> numbers = Arrays.stream(Console.readLine().split(",")).toList();
        List<Integer> winNumbers = convertStringToInteger(numbers);
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(winNumbers, bonusNumber);
        resultCalculator.calculateResult(lottos, winNumbers, bonusNumber);
    }

    public List<Lotto> pickUpLotto(int round) {
        System.out.println(round + "개를 구매했습니다.");
        List<Lotto> lottoNumbers = new ArrayList<>();

        while (round > 0) {
            Lotto lotto = new Lotto(generator());
            lottoNumbers.add(lotto);
            round--;
        }
        printLottoNumber(lottoNumbers);

        return lottoNumbers;
    }

    public void init() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int money = Integer.parseInt(Console.readLine());

            moneyValidator(money);
            List<Lotto> lottos = pickUpLotto(money / 1000);
            handleNumbers(lottos);

        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
