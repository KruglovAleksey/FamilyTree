package ru.gb.family_tree.present;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.servis.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String gender, LocalDate birthDate, int mother, int father){
        service.addHuman(name, gender, birthDate, mother, father);
        printListTree();
    }

    public void printListTree() {
        String str = service.printListTree();
        view.print(str);
    }

    public void sortByName(){
        service.sortByName();
        printListTree();
    }

    public void sortByAge(){
        service.sortBeAge();
        printListTree();
    }

    public void save() {
        service.save();
    }

    public void load() {
        service.load();
    }

}
