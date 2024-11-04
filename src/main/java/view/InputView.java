package view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputView {

    private final static int LOTTO_COST = 1_000;
    private final static int MAX_INPUT_NUMBER = 10_000;

    private List<Integer> inputNumber;

    // TODO: 구조가 비슷한 함수 있음, 합치기 고려
    public int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        while (!validateMoney(money)) {
            System.out.println("옳바른 구입금액을 입력해 주세요.");
            money = readLine();
        }
        return parseInt(money);
    }

    public List<Integer> getInputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String number = readLine();

        while (!validateNumber(number)) {
            System.out.println("옳바른 당첨 번호를 입력해 주세요.");
            number = readLine();
        }

        inputNumber = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .toList();

        return inputNumber;
    }

    public int getInputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = readLine();

        while (!validateBonus(bonus)) {
            System.out.println("옳바른 보너스 번호를 입력해 주세요.");
            bonus = readLine();
        }
        return parseInt(bonus);
    }

    public void closeScanner() {
        close();
    }

    private boolean validateMoney(String money) {
        try {
            if (parseInt(money) % LOTTO_COST != 0 || parseInt(money) == 0 || parseInt(money) >= MAX_INPUT_NUMBER) {
                System.out.println("[ERROR] 구입금액은 1,000원 단위 10,000원 이하입니다.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위 10,000원 이하입니다.");
            return false;
        }
    }

    private boolean validateNumber(String number) {
        try {
            List<Integer> numbers = Arrays.stream(number.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            return numbers.size() == 6 &&
                    numbers.stream().allMatch(num -> num >= 1 && num <= 45) &&
                    new HashSet<>(numbers).size() == 6;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨번호는 1부터 45까지의 수 중 6개를 선택해야합니다.");
            return false;
        }
    }

    private boolean validateBonus(String bonus) {
        try {
            if (parseInt(bonus) >= 1 && parseInt(bonus) <= 45 && !inputNumber.contains(parseInt(bonus))) {
                return true;
            }
            System.out.println("[ERROR] 보너스번호는 1부터 45까지의 수 중 1개를 선택해야합니다.");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스번호는 1부터 45까지의 수 중 1개를 선택해야합니다.");
            return false;
        }
    }

}

