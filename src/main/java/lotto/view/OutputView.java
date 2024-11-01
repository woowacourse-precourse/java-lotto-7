package lotto.view;

import java.util.List;

public class OutputView {
    private static final String DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String DISPLAY_LOTTO_NUMBER_MESSAGE_FORMAT = "[%s]";

    public void displayPurchasedLottoCount(int count) {
        System.out.println(String.format(DISPLAY_LOTTO_COUNT_MESSAGE_FORMAT, count));
    }

    public void displayPurchasedLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            String lottoView = formattingLottoNumbers(lottoTicket);
            System.out.println(lottoView);
        }
    }

    private String formattingLottoNumbers(List<Integer> lottoTicket) {
        List<String> numbers = lottoTicket.stream()
                .map(String::valueOf)
                .toList();

        String joinedNumbers = String.join(", ", numbers);
        return String.format(DISPLAY_LOTTO_NUMBER_MESSAGE_FORMAT, joinedNumbers);
    }
}
