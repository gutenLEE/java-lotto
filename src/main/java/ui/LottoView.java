package ui;

import lotto.Lotto;
import lotto.LottoSummary;
import lotto.Lottos;
import lotto.Rank;

import java.util.stream.Collectors;

public class LottoView {

    public void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + getJoinedString(lotto) + "]");
        }
    }

    private String getJoinedString(Lotto lotto) {
        return lotto.getNumbers().getNumbers().stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public void printLottoSummary(LottoSummary summary) {
        System.out.println(String.format("3개 일치 (%s)- %d개", Rank.FORTH.getWinPrice(), summary.getForthRankCount()));
        System.out.println(String.format("4개 일치 (%s)- %d개", Rank.THIRD.getWinPrice(), summary.getForthRankCount()));
        System.out.println(String.format("5개 일치 (%s)- %d개", Rank.SECOND.getWinPrice(), summary.getSecondRankCount()));
        System.out.println(String.format("6개 일치 (%s)- %d개", Rank.FIRST.getWinPrice(), summary.getFirstRankCount()));
        System.out.println(String.format("총 수익률은 %s입니다", summary.getRateOfReturn().toString()));
    }
}
