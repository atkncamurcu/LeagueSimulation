package com.company;

import java.util.*;

public class TeamGenerator<T extends Team> implements Generator<T> {

    private ArrayList<T> teams;
    private boolean generated;

    public TeamGenerator(){
        teams = new ArrayList<>();
    }

    public void generate(){
        teams.add((T)new Team("Arsenal",3));
        teams.add((T)new Team("Chelsea",4));
        teams.add((T)new Team("Everton",2));
        teams.add((T)new Team("WestHam",1));

        this.generated = true;
    }

    public ArrayList<T> getTeams(){
        return teams;
    }

    @Override
    public boolean isGenerated() {
        return this.generated;
    }

    @Override
    public Iterator<T> iterator() {
        return this.teams.iterator();
    }
}
