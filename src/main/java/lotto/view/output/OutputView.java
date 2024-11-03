package lotto.view.output;

import java.util.Arrays;
import java.util.List;
import lotto.domain.User;
import lotto.exception.LottoException;

public class OutputView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayLottos(User user) {
        int lottosCount = user.getLottos().getLottoCount();
        System.out.printf(OutputMessage.PURCHASED_COUNT_MESSAGE.getOutputMessage(), lottosCount);

        user.getLottos().getLottos().forEach(lotto -> {
            List<Integer> sortedLotto = lotto.getNumbers().stream()
                    .sorted()
                    .toList();
            System.out.println(sortedLotto);
        });
    }

    public void displayStatistics(List<String> result) {
        List<OutputMessage> messages = Arrays.asList(
                OutputMessage.THREE_MATCHES,
                OutputMessage.FOUR_MATCHES,
                OutputMessage.FIVE_MATCHES,
                OutputMessage.FIVE_MATCHES_PLUS_BONUS,
                OutputMessage.SIX_MATCHES,
                OutputMessage.TOTAL_PROFIT
        );
        for (int i = 0; i < messages.size(); i++) {
            System.out.printf(messages.get(i).getOutputMessage(), result.get(i));
        }
    }

    public void displayErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }
}
