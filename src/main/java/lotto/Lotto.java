package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final static int LOW_NUMBER = 1;
    private final static int HIGH_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void validRange(int number){
        if(validNumberRange(number)){
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 " + LOW_NUMBER + "~" + HIGH_NUMBER + "사이의 숫자이어야 합니다.");
        }
    }

    private static boolean validNumberRange(int number) {
        return !(LOW_NUMBER <= number && number >= HIGH_NUMBER);
    }

    private void pickNumber(String regax) {
        String pickNumber = Console.readLine();

        String[] splitNum = pickNumber.split(regax);

        for (String number : splitNum) {
            numbers.add(Integer.parseInt(number));
        }
        duplicatedNumber();
    }

    private void duplicatedNumber(){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }
}
