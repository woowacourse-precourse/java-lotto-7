package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.request.LottoBonusNumberRequest;
import lotto.dto.request.LottoMatchRequest;
import lotto.dto.request.LottoResultRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoMatchResponse;
import lotto.dto.response.LottoResultResponse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoModel {
    private final int LOTTO_PRICE = 1000;

    private int seedMoney = 0;
    private final ArrayList<List<Integer>> buyLotto = new ArrayList<>();

    public LottoBuyResponse buyLotto(String money) {
        int validateNumber = numberValidate(money);
        moneyValidate(validateNumber);
        seedMoney = validateNumber;

        int buyLottoNumber = seedMoney / LOTTO_PRICE;
        getLottoNumbers(buyLottoNumber);

        return new LottoBuyResponse(buyLottoResult(), buyLottoNumber);
    }

    public Lotto makeLotto(String winnerNumbers) {

        return new Lotto(getWinnerNumber(winnerNumbers));
    }

    public int getBonusNumber(LottoBonusNumberRequest lottoPrizeNumberRequest) {
        int validBonusNumber = lottoNumberValidate(numberValidate(lottoPrizeNumberRequest.bonusNumber()));

        lottoPrizeNumberRequest.lotto().bonusNumberValidate(validBonusNumber);

        return validBonusNumber;
    }

    public LottoResultResponse lottoResult(LottoResultRequest lottoPrizeNumberRequest) {
        Lotto lotto = lottoPrizeNumberRequest.lotto();
        int bonusNumber = lottoPrizeNumberRequest.bonusNumber();

        List<LottoMatchResponse> list = getLottoMatchResponseList(lotto, bonusNumber);
        Map<Rank, Integer> rankCounts = getRankCounts(list);
        String rate = calculatorRate(rankCounts);

        return new LottoResultResponse(rankCounts, rate);
    }

    private Map<Rank, Integer> getRankCounts(List<LottoMatchResponse> matchResponses) {
        Map<Rank, Integer> rankCounts = EnumSet.allOf(Rank.class).stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        matchResponses.stream()
                .map(l -> Rank.findRank(l.matchCount(), l.isBonusMatch()))
                .filter(rank -> rank != Rank.NONE)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .forEach((rank, count) -> rankCounts.merge(rank, count, Integer::sum));

        return rankCounts;
    }

    private List<LottoMatchResponse> getLottoMatchResponseList(Lotto lotto, int bonusNumber) {

        return buyLotto.stream()
                .map(l -> lotto.matchNumberCount(new LottoMatchRequest(l, bonusNumber)))
                .toList();
    }

    private List<Integer> getWinnerNumber(String numbers) {

        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(this::numberValidate)
                .map(this::lottoNumberValidate)
                .toList();
    }

    private String calculatorRate(Map<Rank, Integer> rankCounts) {
        double totalPrize = rankCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double rate = (totalPrize / seedMoney) * 100;

        return String.format("%.1f", rate);
    }

    private void getLottoNumbers(int buyLottoNumber) {
        Stream.generate(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .toList())
                .limit(buyLottoNumber)
                .forEach(buyLotto::add);
    }

    private String buyLottoResult() {

        return buyLotto.stream()
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining("\n", "", "\n"));
    }

    private int numberValidate(String number) {
        int parseNumber;

        try {
            parseNumber = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (parseNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력가능합니다.");
        }

        return parseNumber;
    }

    private void moneyValidate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력 가능합니다.");
        }

        if (money % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 입력 단위는 1000원 단위로 가능합니다.");
        }
    }

    private int lottoNumberValidate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.");
        }

        return number;
    }
}
