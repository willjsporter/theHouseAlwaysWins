import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CasinoTest {

    private Casino casino;
    private PlayerSession session1;
    private PlayerSession session2;
    private PlayerSession session3;
    private PlayerSession session4;
    private PlayerSession session5;
    private PlayerSession session6;
    private PlayerSession session7;
    private PlayerSession session8;
    private PlayerSession session9;
    private PlayerSession session10;
    private PlayerSession session11;
    private PlayerSession session12;
    private PlayerSession session13;
    private PlayerSession session14;
    private PlayerSession session15;
    private PlayerSession session16;
    private PlayerSession session17;
    private PlayerSession session18;
    private PlayerSession session19;
    private PlayerSession session20;
    private PlayerSession session21;
    private PlayerSession session22;
    private PlayerSession session23;
    private PlayerSession session24;
    private PlayerSession session25;
    private PlayerSession session26;
    private PlayerSession session27;
    private PlayerSession session28;
    private PlayerSession session29;
    private PlayerSession session30;
    private PlayerSession session31;
    private PlayerSession session32;
    private PlayerSession session33;
    private PlayerSession session34;
    private PlayerSession session35;
    private PlayerSession session36;
    private PlayerSession session37;
    private PlayerSession session38;
    private PlayerSession session39;
    private PlayerSession session40;
    private PlayerSession session41;
    private PlayerSession session42;
    private PlayerSession session43;

    @Before
    public void setup() {
        casino = new Casino();
        session1 = new PlayerSession(1,"Roulette", 1, 2, 1);
        session2 = new PlayerSession(1,"Poker", 2, 4, 1);
        session3 = new PlayerSession(2,"Roulette", 1, 6, 1);
        session4 = new PlayerSession(2,"Poker", 3, 8, 1);
        session5 = new PlayerSession(3,"Blackjack", 4, 10, 1);
        session6 = new PlayerSession(3,"Poker", 5, 24, 1);
        session7 = new PlayerSession(4,"Roulette", 1, 6, 1);
        session8 = new PlayerSession(5,"Poker", 3, 8, 1);
        session9 = new PlayerSession(6,"Blackjack", 4, 10, 1);
        session10 = new PlayerSession(7,"Roulette", 1, 2, 1);
        session11 = new PlayerSession(8,"Poker", 2, 4, 1);
        session12 = new PlayerSession(9,"Poker", 3, 8, 1);
        session13 = new PlayerSession(10,"Blackjack", 4, 10, 1);
        session14 = new PlayerSession(11,"Roulette", 1, 2, 1);
        session15 = new PlayerSession(12,"Poker", 2, 4, 1);
        session16 = new PlayerSession(13,"Poker", 2, 4, 1);
        session17 = new PlayerSession(14,"Poker", 2, 4, 1);
        session18 = new PlayerSession(15,"Poker", 3, 8, 1);
        session19 = new PlayerSession(16,"Blackjack", 4, 10, 1);
        session20 = new PlayerSession(17,"Roulette", 1, 2, 1);
        session21 = new PlayerSession(18,"Poker", 2, 4, 1);
        session22 = new PlayerSession(19,"Poker", 2, 4, 1);
        session23 = new PlayerSession(20,"Poker", 2, 4, 1);
        session24 = new PlayerSession(21,"Poker", 2, 4, 1);
        session25 = new PlayerSession(22,"Poker", 2, 4, 1);
        session26 = new PlayerSession(23,"Poker", 2, 4, 1);
        session27 = new PlayerSession(24,"Roulette", 1, 6, 1);
        session28 = new PlayerSession(25,"Poker", 3, 8, 1);
        session29 = new PlayerSession(26,"Blackjack", 4, 10, 1);
        session30 = new PlayerSession(27,"Roulette", 1, 2, 1);
        session31 = new PlayerSession(28,"Poker", 2, 4, 1);
        session32 = new PlayerSession(29,"Poker", 3, 8, 1);
        session33 = new PlayerSession(30,"Blackjack", 4, 10, 1);
        session34 = new PlayerSession(31,"Roulette", 1, 2, 1);
        session35 = new PlayerSession(32,"Poker", 2, 4, 1);
        session36 = new PlayerSession(33,"Poker", 2, 4, 1);
        session37 = new PlayerSession(34,"Poker", 2, 4, 1);
        session38 = new PlayerSession(35,"Poker", 3, 8, 1);
        session39 = new PlayerSession(36,"Blackjack", 4, 10, 1);
        session40 = new PlayerSession(37,"Roulette", 1, 2, 1);
        session41 = new PlayerSession(38,"Poker", 2, 4, 1);
        session42 = new PlayerSession(39,"Poker", 2, 4, 1);
        session43 = new PlayerSession(40,"Poker", 2, 4, 1);
    }

    @Test
    public void shouldBeAbleToTakeAListOfSessionsAndReturnTheUserIdsOfTheTop5PercentMostProfitablePlayers() {

        List<PlayerSession> testSessionsAcross40players = List.of(
                session1, session2, session3, session4, session5, session6, session7, session8, session9, session10,
                session11, session12, session13, session14, session15, session16, session17, session18, session19,
                session20, session21, session22, session23, session24, session25, session26, session27, session28,
                session29, session30, session31, session32, session33, session34, session35, session36, session37,
                session38, session39, session40, session41, session42, session43
        );

        assertThat(casino.getHighRollers(testSessionsAcross40players), is(List.of(3,2)));
    }

    @Test
    public void ensureThat5PercentOfPlayersIsCalculatedBy_RoundingDownToTheNearestWholeNumberOfPlayers() {

        List<PlayerSession> testSessionsAcross39Players = List.of(
                session1, session2, session3, session4, session5, session6, session7, session8, session9, session10,
                session11, session12, session13, session14, session15, session16, session17, session18, session19,
                session20, session21, session22, session23, session24, session25, session26, session27, session28,
                session29, session30, session31, session32, session33, session34, session35, session36, session37,
                session38, session39, session40, session41, session42
        );

        assertThat(casino.getHighRollers(testSessionsAcross39Players), is(List.of(3)));
    }

}