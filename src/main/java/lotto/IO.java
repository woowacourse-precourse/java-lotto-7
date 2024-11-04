package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IO {

    public int inputBuyLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int price = Integer.parseInt(input);

            if (price % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return price / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return inputBuyLottoPrice();
        }
    }

    public List<Integer> inputCorrectNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        String[] tmp = input.split(",");
        List<Integer> numbers;
        try {
            numbers = StringToIntegerList(tmp);
            validate(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCorrectNumbers();
        }
    }

    // Exception 처리를 private 함수로 분리함.
    private List<Integer> StringToIntegerList(String[] tmp) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (int i = 0; i < tmp.length; i++) {
                int num = Integer.parseInt(tmp[i]);
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식으로 입력되었습니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또는 1~45의 정수여야 합니다.");
            }
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 6 || set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    public int inputBonusNumber(List<Integer> numbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonus = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
            duplicateCheck(numbers, bonus);
            return bonus;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            return inputBonusNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(numbers);
        }
    }

    private void duplicateCheck(List<Integer> numbers, int bonusNum){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) == bonusNum){
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
            }
        }
    }
}
