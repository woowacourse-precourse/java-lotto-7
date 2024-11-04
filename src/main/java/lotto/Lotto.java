package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        countValidate(numbers);
        rangeValidate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void countValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private int countCalculator(String input) {
        int money = integerParser(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
        }

        return money / 1000;
    }

    private int integerParser(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다.");
        }
    }

    public void moneyInput() {
        printL("구입금액을 입력해 주세요.");
        int cnt = countCalculator(Console.readLine());
        newLottos(cnt);
    }

    public void numbersInput() {
        printL("당첨 번호를 입력해 주세요.");
        saveNumbers(Console.readLine());
    }

    public void bonusInput() {
        printL("보너스 번호를 입력해 주세요.");
        saveNumbers(Console.readLine());

    }

    public void saveNumbers(String input) {
        String[] numbersString = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbersString) {
            int numberInt = integerParser(number);
            winningNumbers.add(numberInt);
        }

        countValidate(winningNumbers);
        numbers.addAll(winningNumbers);
    }

    public void newLottos(int cnt) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            List<Integer> lotto = pickNewLotto();
            lottos.add(lotto);
        }

        printNewLotto(cnt, lottos);
        numbersInput();
        bonusInput();
    }



    public List<Integer> pickNewLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printNewLotto(int cnt, List<List<Integer>> lottos) {
        printL(cnt + "개를 구매했습니다.");
        for (List<Integer> lotto : lottos) {
            printLottoLine(lotto);
        }
    }

    public void printLottoLine(List<Integer> lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lotto.size(); i++) {
            sb.append(lotto.get(i));
            if (i < lotto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        printL(sb.toString());
    }

    public void printL(String message) {
        System.out.println(message);
    }
}
