package lotto.View.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int InputPaymoney() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int Paymoney = Integer.parseInt(Console.readLine());
                return MoneyValidation(Paymoney);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int MoneyValidation(int Paymoney) {
        if (Paymoney % 1000 == 0) {
            return Paymoney;
        } throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.");
    }

    public List<Integer> InputNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String NumberList = Console.readLine();
                List<Integer> numbers = Numbers(NumberList);
                return NumberValidation(numbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> Numbers(String NumberList) {
        String[] NumbersArray = NumberList.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : NumbersArray) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        return numbers;
    }

    public static List<Integer> NumberValidation(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호는 1 이상 45 이하의 숫자이어야 합니다.");
            }
        }
        return numbers;
    }
}
