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
				sort(numbers);
				lottoNumbers.add(numbers);
			
		}
		return lottoNumbers;
	}

	public void sort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			bubbleSort(list, i);	
		}
	}

	private void bubbleSort(List<Integer> list, int passIndex) {
		for (int j = 0; j < list.size() - 1 - passIndex; j++) {
			if (list.get(j) > list.get(j + 1)) {
				swap(list, j, j + 1);
			}
		}
	}

	private void swap(List<Integer> list, int index1, int index2) {
		int temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
}
