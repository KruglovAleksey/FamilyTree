package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public TreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
