package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> temp = new ArrayList<>(numbers);
        Collections.sort(temp);
        this.numbers = temp;
    }

    public Lotto(String[] numbers) {
        typeValidate(numbers);;
        List<Integer> number = new ArrayList<>();
        for (String s : numbers) {
            number.add(Integer.parseInt(s));
        }
        validate(number);
        Collections.sort(number);
        this.numbers = number;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        rangeValidate(numbers);
        dupValidate(numbers);
    }

    private void typeValidate(String[] numbers) {
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_NUMBER_TYPE.getErrorMessage());
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.INVALID_NUMBER_COUNT.getErrorMessage());
        }
    }

    private void rangeValidate(List<Integer> numbers) {
        for(int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Exception.INVALID_NUMBER_RANGE.getErrorMessage());
            }
        }
    }

    private void dupValidate(List<Integer> numbers) {
        List<Integer> dupCheck = new ArrayList<>();
        for (int number : numbers) {
            if (dupCheck.contains(number)) {
                throw new IllegalArgumentException(Exception.DUPLICATE_NUMBER.getErrorMessage());
            }
            dupCheck.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int sameNumCount(List<Integer> winNumbers) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean checkBonus(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
