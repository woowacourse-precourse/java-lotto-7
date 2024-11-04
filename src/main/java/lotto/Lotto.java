package lotto;

import java.util.*;

enum ERROR {
    COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    RANGE("[ERROR] 로또 번호의 숫자 범위는 1~45 입니다."),
    FORMAT("[ERROR] 입력 형식이 잘못되었습니다."),
    PARSE("[ERROR] 숫자만 입력할 수 있습니다."),
    UNIT("[ERROR] 1000 단위의 자연수만 입력할 수 있습니다."),
    DUPLICATE("[ERROR] 번호가 중복됩니다.");

    private final String message;

    ERROR(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

enum RANK {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FORTH(4, 50000),
    FIFTH(5, 5000),
    NONE(0, 0);

    private final int index;
    private final long prize;

    RANK(int index, long prize) {
        this.index = index;
        this.prize = prize;
    }

    public int getIndex() {
        return index;
    }

    public long getPrize() {
        return prize;
    }
}

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.COUNT.getMessage());
        }

        for (int number : numbers) {
            validateNumber(number);
        }
    }

    public static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR.RANGE.getMessage());
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public RANK checkWinning(boolean[] winningNumberFlags, int bonusNumber) {
        int count = 0;

        for (int number : numbers) {
            if (winningNumberFlags[number]) {
                count ++;
            }
        }

        if (count == 6) return RANK.FIRST;
        if (count == 5 && numbers.contains(bonusNumber)) return RANK.SECOND;
        if (count == 5) return RANK.THIRD;
        if (count == 4) return RANK.FORTH;
        if (count == 3) return RANK.FIFTH;
        return RANK.NONE;
    }
}
