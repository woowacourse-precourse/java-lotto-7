package lotto.parser;

import java.math.BigInteger;
import java.util.List;

public interface Parser {
	BigInteger purchaseAmount(String input);
	
	List<Integer>winningNumbers(String input);
	
	int bonusNumber(String input, List<Integer> winningNumbers);
}
