package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends  FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> listTree;

    public FamilyTree() {
        listTree = new ArrayList<>();
    }
    public FamilyTree(List<E> listTree) {this.listTree = listTree;}

    public boolean addHuman(E human){
        if(!listTree.contains(human)) {
            listTree.add(human);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }
    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private  void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> getByName(String name){
        List<E> humans = new ArrayList<>();
        for(E e: listTree){
            if(e.getName().equals(name)){
                humans.add(e);
            }
        }
        return humans;
    }

    private boolean checkId(int id){
        return id>=0;
    }
    public E getById(int id){
        if(checkId(id)){
            return null;
        }
        for(E e: listTree){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public String printListTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(listTree.size());
        sb.append(" людей: \n");
        for(E e: listTree){
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        listTree.sort(new FamilyTreeComparatorByName<>());
    }
    public void sortByAge(){
        listTree.sort(new FamilyTreeComparatorByAge<>());
    }

    @Override
    public String toString() {
        return printListTree();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(listTree);
    }
}
