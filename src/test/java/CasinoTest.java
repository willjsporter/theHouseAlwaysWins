import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CasinoTest {

    private Casino casino;
    private PlayerSession session1;
    private PlayerSession session2;
    private PlayerSession session3;
    private PlayerSession session4;
    private PlayerSession session5;

    @Before
    public void setup() {
        casino = new Casino();
        session1 = new PlayerSession(1,"Roulette", 1, 2, 1);
        session2 = new PlayerSession(1,"Poker", 2, 4, 1);
        session3 = new PlayerSession(2,"Roulette", 1, 6, 1);
        session4 = new PlayerSession(2,"Poker", 3, 8, 1);
        session5 = new PlayerSession(3,"Blackjack", 4, 10, 1);
    }

    @Test
    public void shouldBeAbleToGroupPlayerSessionsByPlayer() {
        assertThat(
                casino.groupByPlayers(List.of(session1, session2, session3, session4, session5)),
                equalTo(Map.of(
                        1, List.of(session1, session2),
                        2, List.of(session3, session4),
                        3, List.of(session5)
                        )
                )
        );
    }

    @Test
    public void shouldBeAbleToTakeAMapOfAllSessionsByPlayerAndReturnTheTotalProfitPerPlayer() {
        assertThat(casino.mapOfPlayersToProfits(
                Map.of(
                        1, List.of(session1, session2),
                        2, List.of(session3, session4),
                        3, List.of(session5)
                )),
                is(Map.of(
                        1, 8,
                        2, 18,
                        3, 13
                    ))
        );
    }



    @Test
    public void shouldBeAbleToTakeAListOfSessionsAndReturnAListOfPlayerIdsSortedByProfit() {
        Map<Integer, List<PlayerSession>> groupedByPlayer = casino.groupByPlayers(List.of(session1, session2, session3, session4, session5));
        Map<Integer, Integer> profitsPerPlayer = casino.mapOfPlayersToProfits(groupedByPlayer);

        assertThat(casino.listOfPlayerIdsSortedByProfits(profitsPerPlayer),
                is(List.of(2,3,1))
        );
    }


    @Test
    public void shouldBeAbleToTakeAListOfSessionsAndReturnTheUserIdsOfTheTop5PercentMostProfitablePlayers() {
        PlayerSession session6 = new PlayerSession(4,"Roulette", 1, 6, 1);
        PlayerSession session7 = new PlayerSession(5,"Poker", 3, 8, 1);
        PlayerSession session8 = new PlayerSession(6,"Blackjack", 4, 10, 1);
        PlayerSession session9 = new PlayerSession(7,"Roulette", 1, 2, 1);
        PlayerSession session10 = new PlayerSession(8,"Poker", 2, 4, 1);
        PlayerSession session11 = new PlayerSession(9,"Poker", 3, 8, 1);
        PlayerSession session12 = new PlayerSession(10,"Blackjack", 4, 10, 1);
        PlayerSession session13 = new PlayerSession(11,"Roulette", 1, 2, 1);
        PlayerSession session14 = new PlayerSession(12,"Poker", 2, 4, 1);
        PlayerSession session15 = new PlayerSession(13,"Poker", 2, 4, 1);
        PlayerSession session16 = new PlayerSession(14,"Poker", 2, 4, 1);
        PlayerSession session17 = new PlayerSession(15,"Poker", 3, 8, 1);
        PlayerSession session18 = new PlayerSession(16,"Blackjack", 4, 10, 1);
        PlayerSession session19 = new PlayerSession(17,"Roulette", 1, 2, 1);
        PlayerSession session20 = new PlayerSession(18,"Poker", 2, 4, 1);
        PlayerSession session21 = new PlayerSession(19,"Poker", 2, 4, 1);
        PlayerSession session22 = new PlayerSession(20,"Poker", 2, 4, 1);
        PlayerSession session23 = new PlayerSession(21,"Poker", 2, 4, 1);
        PlayerSession session24 = new PlayerSession(22,"Poker", 2, 4, 1);
        PlayerSession session25 = new PlayerSession(23,"Poker", 2, 4, 1);
        PlayerSession session26 = new PlayerSession(24,"Roulette", 1, 6, 1);
        PlayerSession session27 = new PlayerSession(25,"Poker", 3, 8, 1);
        PlayerSession session28 = new PlayerSession(26,"Blackjack", 4, 10, 1);
        PlayerSession session29 = new PlayerSession(27,"Roulette", 1, 2, 1);
        PlayerSession session30 = new PlayerSession(28,"Poker", 2, 4, 1);
        PlayerSession session31 = new PlayerSession(29,"Poker", 3, 8, 1);
        PlayerSession session32 = new PlayerSession(30,"Blackjack", 4, 10, 1);
        PlayerSession session33 = new PlayerSession(31,"Roulette", 1, 2, 1);
        PlayerSession session34 = new PlayerSession(32,"Poker", 2, 4, 1);
        PlayerSession session35 = new PlayerSession(33,"Poker", 2, 4, 1);
        PlayerSession session36 = new PlayerSession(34,"Poker", 2, 4, 1);
        PlayerSession session37 = new PlayerSession(35,"Poker", 3, 8, 1);
        PlayerSession session38 = new PlayerSession(36,"Blackjack", 4, 10, 1);
        PlayerSession session39 = new PlayerSession(37,"Roulette", 1, 2, 1);
        PlayerSession session40 = new PlayerSession(38,"Poker", 2, 4, 1);
        PlayerSession session41 = new PlayerSession(39,"Poker", 2, 4, 1);
        PlayerSession session42 = new PlayerSession(40,"Poker", 2, 4, 1);
        PlayerSession session43 = new PlayerSession(3,"Poker", 5, 24, 1);

        List<PlayerSession> testSessions = List.of(
                session1, session2, session3, session4, session5, session6, session7, session8, session9, session10,
                session11, session12, session13, session14, session15, session16, session17, session18, session19,
                session20, session21, session22, session23, session24, session25, session26, session27, session28,
                session29, session30, session31, session32, session33, session34, session35, session36, session37,
                session38, session39, session40, session41, session42, session43
        );

        assertThat(casino.getHighRollers(testSessions), is(List.of(3,2)));
    }

}