package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoRepository {
    public static List<Lotto> lottos = new ArrayList<Lotto>();
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static Integer bonus;
    public static long revenue = 0;
}