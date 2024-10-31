package lotto.view;

public class OutputView {

	public static void promptPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static void promptPurchaseCount(int lottoCount) {
		System.out.println("\n" + lottoCount + "개를 구매했습니다.");
	}
}
