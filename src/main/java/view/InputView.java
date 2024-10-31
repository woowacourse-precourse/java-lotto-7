package view;

import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

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
        return Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void closeScanner() {
        close();
    }

    private boolean validateMoney(String money) {
        try {
            if (parseInt(money) % 1000 != 0 || parseInt(money) == 0) {
                System.out.println("[ERROR] 구입금액은 1,000원 단위입니다.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위입니다.");
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

}
