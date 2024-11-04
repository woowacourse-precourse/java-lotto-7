package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto
{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers)
    {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers()
    {
        return this.numbers;
    }

    private void validate(List<Integer> numbers)
    {
       isSix(numbers);
       hasDuplicates(numbers);
       for(int number:numbers)
           validateNumberInRange(number);
    }

    private void isSix(List<Integer> numbers)
    {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    private void validateNumberInRange(int number)
    {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void hasDuplicates(List<Integer> list)
    {
        Set<Integer> set = new HashSet<>(list);
        if(set.size() != list.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호의 중복이 발생하였습니다.");
    }
}
