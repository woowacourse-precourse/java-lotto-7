package lotto.application.model;

import java.util.EnumMap;
import java.util.List;

public class LottoResult implements Model{

    private List<Lotto> lottos;
    private int amount;
    private long totalPrize;
    private double marginRate;
    private EnumMap<WinningRanking, Integer> rankingMap;

}
