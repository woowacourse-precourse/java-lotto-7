package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.dto.WinningNumberRequestDto;

public class InputView {

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다");
        }

        if (price < 0) {
            throw new IllegalArgumentException("음이 아닌 정수여야 합니다");
        }
        
        return price;
    }

    public WinningNumberRequestDto getEntireNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        return new WinningNumberRequestDto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
            .map(Integer::parseInt)
            .toList();
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
