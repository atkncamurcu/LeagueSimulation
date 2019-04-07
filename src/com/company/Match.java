package com.company;

public class Match < T extends Team>{
    private T home;
    private T away;

    private MatchStatus status;

    private int homeGoals;
    private int awayGoals;

    public Match(T home, T away){
        this.home = home;
        this.away = away;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.status = MatchStatus.Waiting;
    }

    private boolean checkIncreasing(int goal) throws Exception {
        if(this.status != MatchStatus.Playing)
            throw new Exception("Match did not start");
        if (goal < 0)
            throw new Exception("Goal must be bigger than 0");
        return true;
    }

    public void increaseHomeGoals(int goal) throws Exception {
        if(this.checkIncreasing(goal)){
            this.homeGoals += goal;
            this.home.increaseGoals(goal);
            this.away.increaseOpponentGoals(goal);
        }
    }

    public void increaseAwayGoals(int goal) throws Exception {
        if(this.checkIncreasing(goal)){
            this.awayGoals += goal;
            this.away.increaseGoals(goal);
            this.home.increaseOpponentGoals(goal);
        }
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public T getHome() {
        return home;
    }

    public T getAway() {
        return away;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    @Override
    public String toString() {
        return  home.getTeamName() +" "+ homeGoals+ " "+ "vs" +" "+awayGoals + " " + away.getTeamName() + "\n";
    }
}
