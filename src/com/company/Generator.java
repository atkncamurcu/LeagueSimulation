package com.company;

import java.util.Iterator;

public interface Generator<T extends Object> extends Iterable {
    void generate() throws Exception;
    boolean isGenerated();
    Iterator<T> iterator();
}
