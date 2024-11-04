package lotto;

import java.util.List;

public class Output {
	public void init() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	public void printLottos(List<Lotto> lottos) {
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	public void printLuckyNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}
}