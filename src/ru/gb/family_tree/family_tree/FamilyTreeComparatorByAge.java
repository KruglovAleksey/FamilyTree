package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        }else {
            return 0;
        }
    }
}
