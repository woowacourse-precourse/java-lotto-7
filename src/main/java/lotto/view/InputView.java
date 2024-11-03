package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.dto.WinningNumberRequestDto;

public class InputView {

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public WinningNumberRequestDto getEntireNumber() {
        return new WinningNumberRequestDto(getWinningNumbers(), getBonusNumber());
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
