package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        Integer totalPrice = Integer.parseInt(readLine());
        if(totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 정수를 입력해야 합니다.");
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        String[] inputNumbers = input.split(",");

        Set<Integer> numbersInput = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if(numbersInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
        }

    }
}
