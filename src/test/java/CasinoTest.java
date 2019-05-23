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

}