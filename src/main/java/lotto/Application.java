package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        // 금액 입력받기
        System.out.print("금액을 입력하세요: ");
        int price = Integer.parseInt(Console.readLine());
        System.out.println("입력한 금액: " + price);

        // 당첨번호 6개 입력받기
        System.out.print("당첨번호 6개를 입력하세요(,키로 구분됩니다)");
        String inputNumbers = Console.readLine();
        // 입력된 문자열을 공백으로 나누어 List<Integer>로 변환
        List<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
        System.out.printf("입력한 당첨번호: %s%n", winningNumbers);

        // 보너스번호 입력받기
        System.out.print("보너스 번호 1개를 입력하세요: ");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println("입력한 보너스 번호: " + bonusNumber);

        new LottoPublish(price); // 금액 기반으로 구매한 로또 개수반환
        new Lotto(winningNumbers); // 생성한 로또 번호 반환

    }
}
