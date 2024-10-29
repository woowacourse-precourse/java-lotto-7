package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoOutput {

	private int amount;
	private int lottoCount;
	private List<Integer> randoms;

	public LottoOutput(int amount) {
		this.amount = amount;
		output();
	}

	private void output() {
		lottoCount();
		lottoCountOutput();
		for (int i = 0; i < lottoCount; i++) {
			lottoNumberRandoms();
			lottoNumberOutput();
		}
	}

	private void lottoCount() {
		this.lottoCount = amount / 1000;
	}

	private void lottoCountOutput() {
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	private void lottoNumberRandoms() {
		randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

	private void lottoNumberOutput() {
		System.out.println(randoms.toString());
		System.out.println();
	}

}
