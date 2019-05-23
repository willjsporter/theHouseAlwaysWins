import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Casino {

    private Map<String, Integer> anteValues = Map.of(
            "Poker", 2,
            "Blackjack", 1,
            "Roulette", 0
    );

    public List<Integer> getHighRollers(List<PlayerSession> playerSessions) {
        Map<Integer, Integer> playersAndProfits = mapOfPlayersToProfits(groupByPlayers(playerSessions));
        int numberOfHighRollers = (playersAndProfits.size()) / 20;

        return listOfPlayerIdsSortedByProfits(playersAndProfits).subList(0, numberOfHighRollers);
    }

    List<Integer> listOfPlayerIdsSortedByProfits(Map<Integer, Integer> playersWithProfits) {
        return playersWithProfits.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    Map<Integer, Integer> mapOfPlayersToProfits(Map<Integer, List<PlayerSession>> players) {
        return players.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        player -> getTotalEarningsForSeveralSessions(player.getValue())
                        )
                );
    }

    Map<Integer, List<PlayerSession>> groupByPlayers(List<PlayerSession> playerSessions) {
        return playerSessions.stream()
                .collect(Collectors.groupingBy(
                        PlayerSession::getPlayerId
                        )
                );
    }

    private int getTotalEarningsForSeveralSessions(List<PlayerSession> individualPlayerSessions) {
        return individualPlayerSessions.stream()
                .map(this::getSessionValue)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int getSessionValue(PlayerSession playerSession) {
        int anteProfit = anteValues.get(playerSession.getGameName()) * playerSession.getNumberOfGamesPlayed();
        int gameProfit = playerSession.getAmountWageredInPounds() - playerSession.getAmountWonInPounds();
        return anteProfit + gameProfit;
    }

}
