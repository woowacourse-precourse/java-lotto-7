package view;
import camp.nextstep.edu.missionutils.Console;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Inputview {
    private final int purchaseNumber;
    private final Lotto lottoNumbers;
    private final int bonus;

    public Inputview()
    {
        this.purchaseNumber = Purchase(safeReadLine());
        this.lottoNumbers = winningNumbr(safeReadLine());
        this.bonus = bonusNumber(safeReadLine());
    }

    public int Purchase(String num)
    {
        int number=stringToInt(num);
        if(number<1000)
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 작습니다.");

        return number;
    }

    public Lotto winningNumbr(String num)
    {
        String[] splitedNumber = splitByComma(num);
        List<Integer> numbers = new ArrayList<>();

        for(String nums : splitedNumber)
            numbers.add(stringToInt(nums));

        return new Lotto(numbers);
    }


    public int bonusNumber(String num)
    {
        int number=stringToInt(num);
        validateNumberInRange(number);

        if(lottoNumbers.getNumbers().contains(number))
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복됩니다.");
        return number;
    }

    public String[] splitByComma(String number)
    {
        return number.split(",");
    }

    public void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public String safeReadLine()
    {
        String input="";
        try
        {
            input=Console.readLine();
        }
        catch (NoSuchElementException e)
        {
            throw new IllegalArgumentException("[ERROR] 입력을 받지 못하였습니다.");
        }
        return input;
    }

    public int stringToInt(String input)
    {
        int number =-1;
        try
        {
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환하지 못하였습니다.");
        }
        return number;
    }
}
