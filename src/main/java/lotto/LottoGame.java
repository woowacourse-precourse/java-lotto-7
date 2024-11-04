package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame 
{
	public static int LOTTO_NUM = 6;
	
	private int playAmount = 0;
	private int playCount = 0;
	private int bonusNumber = 0;
	private Lottos lottos;
	private Lotto winningLotto;
	
	public LottoGame()
	{
		lottos = new Lottos();
	}
	
	public void play()
	{
		inputPlayAmount();
		lottos.makeLottos(playCount);
		lottos.printLottos();
		inputWinningNumbers();
		inputBonusNumber();
		checkLottoResult();
	}
	
	public void inputPlayAmount() throws IllegalArgumentException
	{
		playAmount = inputInteger(PrintMsg.INPUT_MSG.getMessage(), PrintMsg.ERROR_MSG.getMessage());
		calculatePlayCount();
	}
	
	public void inputWinningNumbers()
	{		
		List<Integer> integers = 
		 inputIntegers("\n"+ PrintMsg.WINNING_NUM_MSG.getMessage(),PrintMsg.ERROR_MSG.getMessage());
		winningLotto = new Lotto(integers);
	}
	
	public void inputBonusNumber()
	{
		bonusNumber = inputInteger("\n"+PrintMsg.BONUS_NUM_MSG.getMessage(), PrintMsg.ERROR_MSG.getMessage());
	}
	
	public void checkLottoResult()
	{
		for (Lotto lotto : lottos.getLottos())
		{
			int result = lotto.checkNumbers(winningLotto);
			System.out.println(winningLotto.getNumbers() + " - 일치갯수 = " + result);
			if (result == LottoGame.LOTTO_NUM)
			{
				System.out.println("당첨!!!" + winningLotto.getNumbers());
			}
		}
	}
	
	private int inputInteger(String promptMsg, String errMsg) 
	{
    	int num = 0;
        try 
        {
            System.out.println(promptMsg);
        	String str = Console.readLine();
        	num = Integer.parseInt(str);        	
        }
        catch(IllegalArgumentException e) 
        {
            throw new IllegalArgumentException(errMsg);
        }
        return num;
    }
	
	private void calculatePlayCount() throws IllegalArgumentException
	{
		if(playAmount % 1000 != 0)
		{
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
		playCount = playAmount / 1000;
	}
	
	private List<Integer> inputIntegers(String promptMsg, String errMsg)
	{
		System.out.println(promptMsg);
		String[] integers = Console.readLine().split(",");
		List<Integer> integerList = new ArrayList<Integer>();
		for (int i = 0; i < integers.length; i++)			
		{
			integerList.add(Integer.parseInt(integers[i]));
		}
		integerList.sort(Integer::compareTo);
		return integerList;
	}
}
