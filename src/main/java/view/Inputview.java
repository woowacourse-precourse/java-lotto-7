package view;
import camp.nextstep.edu.missionutils.Console;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Inputview {
    private Lotto lottoNumbers;



    public int Purchase()
    {
        String input = safeReadLine();
        int number=stringToInt(input);
        if(number<1000)
        {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT.getMessage());
        }


        return number;
    }

    public Lotto winningNumbr()
    {
        String[] splitedNumber = splitByComma(safeReadLine());
        List<Integer> numbers = new ArrayList<>();

        for(String nums : splitedNumber)
            numbers.add(stringToInt(nums));

        this.lottoNumbers= new Lotto(numbers);
        return new Lotto(numbers);
    }


    public int bonusNumber()
    {
        int number=stringToInt(safeReadLine());
        validateNumberInRange(number);

        if(lottoNumbers.getNumbers().contains(number))
        {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }

        return number;
    }

    public String[] splitByComma(String number)
    {
        return number.split(",");
    }

    public void validateNumberInRange(int number)
    {
        if (number < 1 || number > 45)
        {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public String safeReadLine()
    {
        String input="";
        try
        {
            return input=Console.readLine();
        }
        catch (NoSuchElementException e)
        {
            throw new IllegalArgumentException(ErrorMessage.MISSING_INPUT.getMessage());
        }
    }

    public int stringToInt(String input)
    {
        int number =-1;
        try
        {
            return number = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
