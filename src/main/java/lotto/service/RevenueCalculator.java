package lotto.service;

import java.math.BigDecimal;
import lotto.util.Ranks;

public interface RevenueCalculator {

    BigDecimal getRevenue(Ranks rank);
}
