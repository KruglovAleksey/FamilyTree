package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> listTree;

    public FamilyTree() {
        listTree = new ArrayList<>();
    }
    public FamilyTree(List<Human> listTree) {this.listTree = listTree;}

    public boolean addHuman(Human human){
        if(!listTree.contains(human)) {
            listTree.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }
    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChildren(human);
        }
    }
    private  void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name){
        List<Human> humans = new ArrayList<>();
        for(Human human: listTree){
            if(human.getName().equals(name)){
                humans.add(human);
            }
        }
        return humans;
    }

    private boolean checkId(int id){
        return id>=0;
    }
    public Human getById(int id){
        if(checkId(id)){
            return null;
        }
        for(Human human: listTree){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String printListTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(listTree.size());
        sb.append(" людей: \n");
        for(Human human: listTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return printListTree();
    }

}
