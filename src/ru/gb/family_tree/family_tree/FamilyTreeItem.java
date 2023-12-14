package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> {
    int getId();

    String getName();

    int getAge();

    List<T> getChildren();

    List<T> getParents();

    boolean addChild(T human);

    boolean addParent(T human);
}
