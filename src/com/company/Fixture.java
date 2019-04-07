package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Fixture< T extends Match> implements Iterable<T>{

    private ArrayList<T> matchList;

    public Fixture() {
       this.resetMatchList();
    }

    public void addMatch(T match){
        this.matchList.add(match);
    }

    public void resetMatchList(){
        this.matchList = new ArrayList<>();
    }

    public ArrayList<T> getMatchList() {
        return this.matchList;
    }

    @Override
    public Iterator<T> iterator() {
        return this.matchList.iterator();
    }
}
