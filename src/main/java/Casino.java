import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Casino {

    public List<Integer> getHighRollers(List<PlayerSession> playerSessions) {
        return null;
    }


    Map<Integer, List<PlayerSession>> groupByPlayers(List<PlayerSession> playerSessions) {
        return playerSessions.stream()
                .collect(Collectors.groupingBy(
                        PlayerSession::getPlayerId
                        )
                );
    }

}
