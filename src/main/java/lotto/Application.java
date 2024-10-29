package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.*;

public class Application {
    public static void main(String[] args) {
        int lottoTickets = inputPayment();
        List<Lotto> lottos = drawLottos(lottoTickets);
    }

    public static int inputPayment(){
        System.out.println(PAYMENT_MASSAGE);
        int payment = Integer.parseInt(Console.readLine());
        validatePayment(payment);
        return payment/LOTTOPRICE;
    }

    public static void validatePayment(int payment){
        if(payment % LOTTOPRICE != 0) {
            throw new IllegalArgumentException(PAYMENT_ERROR);
        }
    }

    public static List<Lotto> drawLottos(int lottoTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .collect(Collectors.toList())));
        }
        return lottos;
    }
}
