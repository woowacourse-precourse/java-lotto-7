package lotto.view;

import java.util.stream.Collectors;

import lotto.model.domain.LottoBundle;

public class OutputView {

	public static void promptPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static void promptPurchaseCount(int lottoCount) {
		System.out.println("\n" + lottoCount + "개를 구매했습니다.");
	}

	public static void promptLottoNumbers(LottoBundle lottoBundle) {
		lottoBundle.getLottoBundle().forEach(lotto -> {
			String formattedNumbers = lotto.getNumbers().stream()
				.sorted()
				.map(String::valueOf)
				.collect(Collectors.joining(", ", "[", "]"));

			System.out.println(formattedNumbers);
		});
	}
}
