package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother, father;
    private List<Human> children;


    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.mother = null;
        this.father = null;
        children = new ArrayList<>();
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setGender(Gender gender) {this.gender = gender;}
    public Gender getGender() {return gender;}
    public Human getMother() {return mother;}
    public void setMother(Human mother) {this.mother = mother;}
    public Human getFather() {return father;}
    public void setFather(Human father) {this.father = father;}

    public void addChildren(Human child){
        if(!children.contains(child)){
            children.add(child);
            System.out.println("Ребенок добавлен");
        }else System.out.println("Такой ребенок уже есть");
    }

    public void addParent(Human parent){
        if(parent.getGender().equals(Gender.Female)){
            setMother(parent);
            System.out.println("Добавлен родитель Мать");
        }else if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
            System.out.println("Добавлен родитель Отец");
        }
    }
    private String printMother(){
        Human mother = getMother();
        String str = " Мать: ";
        if(mother != null){
            str = str + mother.getName();
        }else str = str + "xз";
        return str;
    }
    private String printFather() {
        Human father = getFather();
        String str = " Отец: ";
        if(father != null){
            str = str + father.getName();
        }else str = str + "xз";
        return str;
    }
    private String printChildren(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Дети: ");
        if(children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                sb.append(children.get(i).getName());
                sb.append(" ");
            }
        }else sb.append("нет");
        return sb.toString();
    }

    public String printFamily(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", Дата рождения: ");
        stringBuilder.append(birthDate);
        stringBuilder.append(", Дата смерти: ");
        stringBuilder.append(deathDate);
        stringBuilder.append(printMother());
        stringBuilder.append(printFather());
        stringBuilder.append(printChildren());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return printFamily();
    }
}


