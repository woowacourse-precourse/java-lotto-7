package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersInput{
    public Lotto inputNumbers() {
        List<Integer> numbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String numberSet = Console.readLine();
                numbers = splitNumbers(numberSet); // 입력 받고 나누기 & 숫자로 변환
                checkNumbers(numbers);  // 범위 검사 & 중복 검사
                return new Lotto(numbers);
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자를 입력해주세요.");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> splitNumbers(String numberSet) {
        List<Integer> tempNumbers = new ArrayList<>();
        String[] numbersArray = numberSet.split(",");
        for (String number : numbersArray) {
            tempNumbers.add(Integer.parseInt(number.trim()));  // 공백 제거 후 숫자 변환해주기
        }
        return tempNumbers;
    }

    private void checkNumbers(List<Integer> numbers) {
        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[Error] 로또 번호는 1에서 45사이여야 합니다.");
            }
            if (checkNumbers.contains(number)) {
                throw new IllegalArgumentException("[Error] 앞의 숫자와 중복되지 않는 새로운 숫자를 입력하세요.");
            }
            checkNumbers.add(number);
        }
    }
}
