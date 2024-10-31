package lotto.core;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    public static final int MIN_LOTTERY_NUMBER = 1;
    public static final int MAX_LOTTERY_NUMBER = 45;
    public static final int LOTTERY_SIZE = 6;
    public static final String DELIMITER = ",";

    private String numberString;
    private List<Integer> numbers;
    private int bonusNumber;

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public WinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        this.numberString = Console.readLine();
        this.setWinningNumbers();
        this.setBonusNumber();
    }

    private void setWinningNumbers() {
        this.numbers = Arrays.stream(this.numberString.split(DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .toList();
    }

    private void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }
}
