package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Human {
    private static final AtomicInteger count = new AtomicInteger(1);
    private Integer id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother, father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = count.getAndIncrement();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setGender(Gender gender) {this.gender = gender;}
    public Gender getGender() {return gender;}
    public Human getMother() {return mother;}
    public void setMother(Human mother) {this.mother = mother;}
    public Human getFather() {return father;}
    public void setFather(Human father) {this.father = father;}
    public List<Human> getChildren(){return children;}
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if(deathDate == null){
            return getAge(birthDate, LocalDate.now());
        } else {
            return getAge(birthDate, deathDate);
        }
    }
    private int getAge(LocalDate birthDate, LocalDate deathDate){
        Period period = Period.between(birthDate, deathDate);
        return period.getYears();
    }

    public boolean addChildren(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }else return false;
    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Female)){
            setMother(parent);
            return true;
        }else if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
            return true;
        }
        return false;
    }
    private String printMother(){
        Human mother = getMother();
        String str = ", Мать: ";
        if(mother != null){
            str = str + mother.getName();
        }else str += "Неизвестно";
        return str;
    }
    private String printFather() {
        Human father = getFather();
        String str = ", Отец: ";
        if(father != null){
            str = str + father.getName();
        }else str += "Неизвестно";
        return str;
    }
    private String printChildren(){
        StringBuilder sb = new StringBuilder();
        sb.append(", Дети: ");
        if(!children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(" ");
                sb.append(children.get(i).getName());
            }
        }else sb.append("нет");
        return sb.toString();
    }

    public String printFamily(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(id);
        stringBuilder.append(", Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Пол: ");
        stringBuilder.append(getGender());
        stringBuilder.append(", ");
        stringBuilder.append(getAge());
        stringBuilder.append(" лет");
        stringBuilder.append(printMother());
        stringBuilder.append(printFather());
        stringBuilder.append(printChildren());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return printFamily();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){return true;}
        if(!(obj instanceof Human)){return false;}
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}


