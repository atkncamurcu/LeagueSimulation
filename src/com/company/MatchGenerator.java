package com.company;

import java.util.Iterator;
import java.util.Random;

public class MatchGenerator<T extends Team, T2 extends Match> implements Generator {

    private boolean generated = false;
    private Generator<T2> fixtureGenerator;
    private Random rand;

    public MatchGenerator(Generator<T2> fixtureGenerator) {
        this.fixtureGenerator = fixtureGenerator;
        this.rand = new Random();
    }


    @Override
    public void generate() throws Exception {
        if(!fixtureGenerator.isGenerated())
            fixtureGenerator.generate();

        for(Iterator<T2> matchI = fixtureGenerator.iterator(); matchI.hasNext();)
        {
            T2 match = matchI.next();
            T home = (T)match.getHome();
            T away = (T)match.getAway();
            match.setStatus(MatchStatus.Playing);
            int homeGoal = rand.nextInt(home.getPower());
            int awayGoal = rand.nextInt(away.getPower());
            if(homeGoal>awayGoal){
                match.increaseHomeGoals(homeGoal);
                match.increaseAwayGoals(awayGoal);
                home.increaseWin();
                away.increaseLose();
            } else if(homeGoal == awayGoal){
                away.increaseDraw();
                home.increaseDraw();
            }else{
                match.increaseAwayGoals(awayGoal);
                match.increaseHomeGoals(homeGoal);
                away.increaseWin();
                home.increaseLose();
            }
            match.setStatus(MatchStatus.Played);
        }
        this.generated = true;
    }

    @Override
    public boolean isGenerated() {
        return this.generated;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
