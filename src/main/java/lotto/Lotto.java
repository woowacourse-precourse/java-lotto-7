package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto 
{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers()
    {
    	return numbers;
    }
    
    public static List<Integer> makeRandomNumbers() 
    {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    
    private boolean checkNumber(int check)
    {
    	for (Integer num : numbers)
    	{
    		if (num.intValue() == check)
    			return true;
    	}
    	return false;
    }
    public int checkNumbers(Lotto checks)
    {
    	int containCount = 0;
    	for (Integer num : checks.getNumbers())
    	{
    		if (checkNumber(num) == true)
    		{
    			containCount = containCount + 1;
    		}
    	}
    	return containCount;
    }
}
