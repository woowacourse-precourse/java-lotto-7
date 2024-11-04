package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MakeNumber {

	public List<List<Integer>> randomNumber(int total) {
		List<List<Integer>> purchasedNumbers = generateLottoNumbers(total);
		for (List<Integer> purchasedNumber : purchasedNumbers)
			System.out.println(purchasedNumber);
		System.out.println();
		return purchasedNumbers;
	}

	public List<List<Integer>> generateLottoNumbers(int total) {
		List<List<Integer>> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
				lottoNumbers.add(numbers);
			
		}
		return lottoNumbers;
	}


}
