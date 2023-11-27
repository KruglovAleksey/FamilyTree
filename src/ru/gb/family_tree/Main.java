package ru.gb.family_tree;


import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human ira = new Human("Ира", Gender.Female, LocalDate.of(1964, 6,7));
        Human vadim = new Human("Вадим", Gender.Male, LocalDate.of(1966, 8,29));
        Human aleksey = new Human("Алексей", Gender.Male, LocalDate.of(1990, 4, 19));
        System.out.println(aleksey);
        aleksey.addParent(ira);
        aleksey.addParent(vadim);
        ira.addChildren(aleksey);
        vadim.addChildren(aleksey);
        System.out.println(aleksey);
        System.out.println(vadim);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(aleksey);

    }
}
