package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 잘못된 형식으로 입력되었습니다.");
        }
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 잘못된 형식으로 입력되었습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
