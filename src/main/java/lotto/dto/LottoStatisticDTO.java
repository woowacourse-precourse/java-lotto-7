package lotto.dto;
import java.util.Map;

public record LottoStatisticDTO(Map<String, Integer> statistics, double yield, int amount, int quantity) {}
