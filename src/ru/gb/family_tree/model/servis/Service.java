package ru.gb.family_tree.model.servis;


import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.Writable;


import java.time.LocalDate;


public class Service {
    private Human human;
    private FamilyTree<Human> tree;
    private Writable writable;
    String filePath = "tree.txt";

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    public Service(FamilyTree<Human> tree) {
        this.tree = tree;
    }

    public Service() {
        tree = new FamilyTree<>();
    }
    public void save() {
        writable.save(tree, filePath);
    }

    public void load(){
        tree = (FamilyTree<Human>) writable.read(filePath);
    }

    public void addHuman(String name, String gender, LocalDate birthDate, int idMother, int idFather){
        Human mother = tree.getById(idMother);
        Human father = tree.getById(idFather);
        Human human = new Human(name, gender, birthDate, mother, father);
        tree.add(human);
        System.out.println("Новый человек добавлен в дерево");
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

    public void addChild(){

    }
}
