package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.PositiveNumber;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public PositiveNumber getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        long price = Long.parseLong(Console.readLine());
        inputValidator.isDivisibleByThousand(price);
        return new PositiveNumber(price);
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

    private Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
