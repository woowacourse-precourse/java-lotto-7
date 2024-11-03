package lotto.io.output;

import java.util.List;
import java.util.StringJoiner;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputHandler {

	private static final String LOTTO_SIGN_DELIMITER = ", ";
	private static final String LOTTO_SIGN_PREFIX = "[";
	private static final String LOTTO_SIGN_SUFFIX = "]";
	private static final String PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요.";
	private static final String PURCHASED_LOTTO_COUNT_COMMENT = "개를 구매했습니다.";

	public void showPurchaseComment() {
		System.out.println(PURCHASE_AMOUNT_COMMENT);
	}

	public void showPurchasedLottos(Lottos lottos) {
		List<Lotto> lottosToShow = lottos.getLottos();
		System.out.println(lottosToShow.size() + PURCHASED_LOTTO_COUNT_COMMENT);

		for (Lotto lotto : lottosToShow) {
			String lottoSign = makeLottoSign(lotto);
			System.out.println(lottoSign);
		}
	}

	private String makeLottoSign(Lotto lotto) {
		StringJoiner stringJoiner = new StringJoiner(LOTTO_SIGN_DELIMITER, LOTTO_SIGN_PREFIX, LOTTO_SIGN_SUFFIX);

		List<Integer> lottoNumbers = lotto.getNumbers();

		for (Integer lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber));
		}

		return stringJoiner.toString();
	}

}
