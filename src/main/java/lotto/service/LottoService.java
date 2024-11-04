package lotto.service;


import lotto.domain.Lotto;
import lotto.model.LottoResult;
import lotto.policy.GenerateLottoPolicy;
import lotto.policy.RankingPolicy;
import lotto.util.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class LottoService {

    public static List<Lotto> generateLottoList(int lottoTickets) {
        GenerateLottoPolicy generatePolicy = GenerateLottoPolicy.getGeneratePolicy();
        return IntStream.range(0, lottoTickets)
                .mapToObj(i -> new Lotto(generatePolicy.getLottoList()))
                .peek(Printer::print)
                .collect(Collectors.toList());
    }

    public static void printResult(LottoResult lottoResult, int purchaseAmount) {
        Map<RankingPolicy, Integer> resultMap = lottoResult.calculateResults();
        int totalPrize = calculateTotalPrize(resultMap);
        Arrays.stream(RankingPolicy.values())
                .filter(policy -> policy != RankingPolicy.MATCH_NONE)
                .forEach(policy -> {
                    int count = resultMap.get(policy);
                    Printer.printResult(policy, count);
                });
        printBenefitRate(purchaseAmount, totalPrize);
    }

    private static int calculateTotalPrize(Map<RankingPolicy, Integer> resultMap) {
        return Arrays.stream(RankingPolicy.values())
                .filter(policy -> policy != RankingPolicy.MATCH_NONE)
                .mapToInt(policy -> policy.getPrize() * resultMap.get(policy))
                .sum();
    }


    private static void printBenefitRate(int purchaseAmount, int totalPrize) {
        double value = ((double) totalPrize / purchaseAmount) * 100;
        Printer.printBenefitResult(value);
    }
}

