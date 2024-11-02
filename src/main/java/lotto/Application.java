package lotto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 당첨 번호와 보너스 번호 입력받기
        System.out.println("당첨 번호를 입력하세요.(숫자는 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력하세요.");
        input = readLine();
        int bonusNum = Integer.parseInt(input);
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNum);
    }
}
