package lotto;

public class LottoOutput {

	private int amount;
	private int lottoCount;

	public LottoOutput(int amount) {
		this.amount = amount;
		output();
	}

	private void output() {
		lottoCount();
		lottoCountOutput();
	}

	private void lottoCount() {
		this.lottoCount = amount / 1000;
	}

	private void lottoCountOutput() {
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

}
