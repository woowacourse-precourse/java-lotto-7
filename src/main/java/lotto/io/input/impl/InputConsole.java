package lotto.io.input.impl;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoNumber;
import lotto.io.input.GameInput;

public class InputConsole implements GameInput {

    @Override
    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    @Override
    public List<LottoNumber> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseNumbers(input);
    }

    @Override
    public LottoNumber getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(Console.readLine()));
    }

    private List<LottoNumber> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(Collectors.toList());
    }
}
