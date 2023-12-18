package ru.gb.family_tree.model.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> {
    int getId();
    void setId(int id);

    String getName();

    int getAge();

    List<T> getChildren();

    List<T> getParents();

    boolean addChild(T human);

    boolean addParent(T human);
}
