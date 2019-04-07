package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {
        Fixture fixture = new Fixture();

        TeamGenerator<Team> teamGenerator = new TeamGenerator<Team>();
        Generator<Match> fixtureGenerator = new FixtureGenerator<Team,Match>(fixture,teamGenerator);
        Generator matchGenerator = new MatchGenerator<Team,Match>(fixtureGenerator);
        matchGenerator.generate();
        for (Iterator<Match> matchIterator= fixtureGenerator.iterator(); matchIterator.hasNext();){
            Match match = matchIterator.next();
            System.out.println(match);
        }

        ArrayList<Team> teams = teamGenerator.getTeams();
        Collections.sort(teams, Comparator.comparing(s -> -(s.getTeamPoints()*100 + s.getAvarage())));

        System.out.println("Team Name" + "    " + "OM" + "  " + "G" + "   " + "B" + "   " + "Y" + "   " + "Avj" + "  " + "P");
        for (Team team:teams){
            System.out.println(team);
        }

    }
}
