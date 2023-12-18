package ru.gb.family_tree.model.family_tree;

import java.util.Comparator;

public class FamilyTreeComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        }else {
            return 0;
        }
    }
}
