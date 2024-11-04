package lotto;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		try {
			Input input = new Input();
			Output output = new Output();
			LottoGame lottoGame = new LottoGame();

			output.init();
			int payment = input.getPayment();

			int lottoCount = lottoGame.getLottoCount(payment);
			output.printLottoCount(lottoCount);

			List<Lotto> lottos = lottoGame.getLotto(lottoCount);
			output.printLottos(lottos);

			output.printLuckyNumber();
			List<Integer> luckyNumbers = input.getLuckyNumber();

			output.printBonusNumber();
			int bonusNumber = input.getBonusNumber(luckyNumbers);

			output.printResult(lottos, luckyNumbers, bonusNumber);

			long total = lottoGame.calculateTotalEarningRate(lottos, luckyNumbers, bonusNumber);
			double earningRate = lottoGame.calculateEarningRate(total, payment);

			output.printEarningRate(earningRate);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
}
