package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public int readLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int lottoAmount = Integer.parseInt(readLine());

            if (lottoAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] ");
            }

            return lottoAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public List<Integer> readWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        try {
            String input = readLine();

            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해 주세요");
        }
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요");
        }
    }
}
