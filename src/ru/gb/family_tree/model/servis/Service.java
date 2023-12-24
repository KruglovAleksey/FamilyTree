package ru.gb.family_tree.model.servis;


import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;


public class Service {
    private FamilyTree<Human> tree;

    public Service(FamilyTree<Human> tree) {
        this.tree = tree;
    }

    public Service() {
        tree = new FamilyTree<>();
    }
    public void save() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    public void load(){
        FileHandler fileHandler = new FileHandler();
        tree = (FamilyTree<Human>) fileHandler.read();
    }

    public void addHuman(String name, String gender, LocalDate birthDate, int idMother, int idFather){
        Human mother = tree.getById(idMother);
        Human father = tree.getById(idFather);
        Human human = new Human(name, gender, birthDate, mother, father);
        tree.add(human);
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortBeAge(){
        tree.sortByAge();
    }

    public String printListTree(){
        return tree.toString();
    }

}
