package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.view.ClientInput;
import lotto.view.ClientOutput;

public class LottoService {

    public int enterPrice() {
        ClientInput clientInput = new ClientInput();
        return clientInput.enterPurchaseAmount();
    }

    public int purchaseTicket(int price) {
        LottoPrice lottoPrice = new LottoPrice(price);
        return lottoPrice.getTicketQuantity();
    }

    public List<List<Integer>> generateLottoNumbers(int ticketQuantity) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        ClientOutput clientOutput = new ClientOutput();
        for (int ticket = 0; ticket < ticketQuantity; ticket++) {
            Lotto ticketNumbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTickets.add(ticketNumbers.getNumbers());
        }
        clientOutput.lottoPurchaseMessageOutput(ticketQuantity, lottoTickets);

        return lottoTickets;
    }

    public List<String> generateWinningNumber() {
        ClientInput clientInput = new ClientInput();
        String winningNumber = clientInput.enterWinningNumber();
        String bonusNumber = clientInput.enterBonusNumber();
        String string = winningNumber + "," + bonusNumber;
        String[] split = string.split(",");
        return new ArrayList<>(Arrays.asList(split));
    }

    public void generateLottoWinners(int lottoPrice, List<List<Integer>> lottoTicket, List<String> lottoWinningNumber) {
        List<String> checkList = generateNumCheckList(lottoTicket, lottoWinningNumber);
        generateLottoWinningStatistics(lottoPrice, checkList);
    }

    private List<String> generateNumCheckList(List<List<Integer>> lottoTicket, List<String> lottoWinningNumber) {
        List<String> numberCheckList = new ArrayList<>();
        for (List<Integer> ticket : lottoTicket) {
            int count = 0;
            for (int numberIndex = 0; numberIndex < lottoWinningNumber.size() - 1; numberIndex++) {
                if (ticket.contains(Integer.parseInt(lottoWinningNumber.get(numberIndex)))) {
                    count++;
                }
            }

            if (ticket.contains(Integer.parseInt(lottoWinningNumber.getLast()))) {
                numberCheckList.add(count + "+");
            } else {
                numberCheckList.add(String.valueOf(count));
            }
        }
        return numberCheckList;
    }

    private void generateLottoWinningStatistics(int lottoPrice, List<String> numberCheckList) {
        int totalPrice = 0;
        System.out.println("\n당첨 통계\n---");
        if (numberCheckList.contains("2+") || numberCheckList.contains("3")) {
            List<String> valuesToCheck = Arrays.asList("2+", "3");
            int frequency = 0;
            for (String value : valuesToCheck) {
                frequency = Collections.frequency(numberCheckList, value);
            }
            totalPrice += totalPrice + frequency * 5000;
            System.out.println("3개 일치 (5,000원) - " + frequency + "개");
        } else {
            System.out.println("3개 일치 (5,000원) - 0개");
        }

        if (numberCheckList.contains("3+") || numberCheckList.contains("4")) {
            List<String> valuesToCheck = Arrays.asList("3+", "4");
            int frequency = 0;
            for (String value : valuesToCheck) {
                frequency = Collections.frequency(numberCheckList, value);
            }
            totalPrice += totalPrice + frequency * 5000;
            System.out.println("4개 일치 (50,000원) - " + frequency + "개");
        } else {
            System.out.println("4개 일치 (50,000원) - 0개");
        }

        if (numberCheckList.contains("4+")) {
            int frequency = Collections.frequency(numberCheckList, "4+");
            totalPrice += totalPrice + frequency * 5000;
            System.out.println("5개 일치 (1,500,000원) - " + frequency + "개");
        } else {
            System.out.println("5개 일치 (1,500,000원) - 0개");
        }

        if (numberCheckList.contains("5")) {
            int frequency = Collections.frequency(numberCheckList, "5");
            totalPrice += totalPrice + frequency * 5000;
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + frequency + "개");
        } else {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        }

        if (numberCheckList.contains("5+") || numberCheckList.contains("6")) {
            List<String> valuesToCheck = Arrays.asList("3+", "4");
            int frequency = 0;
            for (String value : valuesToCheck) {
                frequency = Collections.frequency(numberCheckList, value);
            }
            totalPrice += totalPrice + frequency * 5000;
            System.out.println("6개 일치 (2,000,000,000원) - " + frequency + "개");
        } else {
            System.out.println("6개 일치 (2,000,000,000원) - 0개");
        }
        double percentage = ((double) totalPrice / lottoPrice) * 100;
        // 소수점 둘째 자리까지 표시
        String formattedNumber = String.format("%.1f", percentage);

        System.out.println("총 수익률은 " + formattedNumber + "%입니다.");
    }
}
