package lotto.view;

import java.text.MessageFormat;
import java.util.List;

import lotto.domain.Lotto;

public class ResponseView {

	private static final ResponseView INSTANCE = new ResponseView();

	private static final String LOTTO_QUANTITY_MESSAGE_FORMAT = "{0}개를 구매했습니다.";

	private ResponseView() {
	}

	public static ResponseView getInstance() {
		return INSTANCE;
	}

	public void printBoughtLotto(List<Lotto> lotto) {
		StringBuilder message = new StringBuilder();
		message.append(MessageFormat.format(LOTTO_QUANTITY_MESSAGE_FORMAT, lotto.size())).append("\n");
		lotto.forEach(l -> message.append(l.toString()).append("\n"));
		System.out.println(message);
	}
}
