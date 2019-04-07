package com.company;

import java.util.Iterator;

public class FixtureGenerator<T2 extends Team, T extends Match> implements Generator<T> {
    private Fixture fixture;
    private Generator teamGenerator;
    private boolean generated = false;

    public FixtureGenerator(Fixture fixture, Generator<T2> teamGenerator) {
        this.fixture = fixture;
        this.teamGenerator = teamGenerator;
    }

    public void generate() throws Exception {
        if (!this.teamGenerator.isGenerated())
            this.teamGenerator.generate();

        for (Iterator<T2> home = teamGenerator.iterator(); home.hasNext(); ) {
            T2 homeTeam = home.next();
            for (Iterator<T2> away = teamGenerator.iterator(); away.hasNext(); ) {
                T2 awayTeam = away.next();
                if (!homeTeam.getTeamName().equals(awayTeam.getTeamName())) {
                    fixture.addMatch(new Match(homeTeam, awayTeam));
                }
            }
            this.generated = true;
        }
    }

    @Override
    public boolean isGenerated() {
        return this.generated;
    }

    @Override
    public Iterator<T> iterator() {
        return fixture.iterator();
    }
}

