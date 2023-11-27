package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree{
    private List<Human> listTree;

    public FamilyTree() {
        listTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        if(!listTree.contains(human)) {
            listTree.add(human);
            System.out.println("Человек добавлен");
        }
    }
}
