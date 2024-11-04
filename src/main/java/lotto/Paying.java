package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Paying {
	private List<List<Integer>> lottoNumbers;
	private int total;
	public int getTotal() {
		return total;
	}

	public List<List<Integer>> getLottoNumbers(){
		return lottoNumbers;
	}
	public String payment() {
			System.out.println("구입금액을 입력해 주세요.");
			payInput();
		return "";
	}

	public void payInput() {
		try {
			String input = Console.readLine();
			System.out.println();
			paymentExcception(input);
			payTotal(input);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			payInput();
		}
	}

	public void paymentExcception(String input) {
		if (!input.matches("\\d+")) { // 숫자가 아닌 경우
			throw new IllegalArgumentException("[ERROR] : 숫자만 입력해 주세요.");
		}
		if (Integer.parseInt(input) % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] : 1000원 단위로 입력해주새요.");
		}
	}
	
	public void payTotal(String input) {
	    int total = Integer.parseInt(input) / 1000; 	
	    this.total = total;
	    System.out.printf("%d개를 구매했습니다.%n", total);
	    MakeNumber make = new MakeNumber();
	    this.lottoNumbers = make.randomNumber(total); //여기서 복권을 구매한 만큼의 List<List>를 받아옴
	}

}
