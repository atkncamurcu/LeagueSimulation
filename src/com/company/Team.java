package com.company;

public class Team {
    private String teamName;
    private int power;
    private int win;            // number of win
    private int lose;           // number of lose
    private int draw;           // number of draw
    private int goal;           // number of score a goal
    private int opponentGoal;   // number of ship a goal
    private int playedMatch;    // number of match

    private Team() {
        this.resetStats();
    }

    public Team(String teamName, int teamPower) {
        super();
        this.teamName = teamName;
        this.power = teamPower;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPower() {
        return power;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public int getGoal() {
        return goal;
    }

    public int getOpponentGoal() {
        return opponentGoal;
    }

    public void increaseWin() {
        this.win++;
    }

    public void increaseLose() {
        this.lose++;
    }

    public void increaseDraw() {
        this.draw++;
    }

    public void increaseGoals(int goal) throws Exception {
        if (goal < 0)
            throw new Exception("Goal must be bigger than 0");
        this.goal += goal;
    }

    public void increaseOpponentGoals(int goal) throws Exception {
        if (goal < 0)
            throw new Exception("Goal must be bigger than 0");
        this.opponentGoal += goal;
    }

    public void resetStats() {
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
        this.goal = 0;
        this.opponentGoal = 0;
    }

    public int getTeamPoints() {
        return this.win * 3 + this.draw;
    }

    public int getAvarage() {
        return this.goal - this.opponentGoal;
    }

    public int getPlayedMatch(){
        return this.win + this.lose + this.draw;
    }

    @Override
    public String toString() {
        return teamName + "      " + getPlayedMatch() + "   " + getWin() + "   " +getDraw() + "   " + getLose() + "   " +getAvarage() + "   " + getTeamPoints() ;
    }
}







