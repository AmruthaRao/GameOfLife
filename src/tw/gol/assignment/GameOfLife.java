package tw.gol.assignment;

import java.util.*;

public class GameOfLife {

  HashMap<Set<Integer>,Boolean> map=new HashMap<>();

  GameOfLife(HashMap<Set<Integer>,Boolean> map){
    this.map = map;
  }

  public HashMap<Set<Integer>,Boolean> getNextGeneration() {
    int counter;
    for (Set key : new ArrayList<Set>(map.keySet())) {
      counter=getLiveNeighbourCount(key);
      if(counter>3||counter<2){
        map.remove(key);
      }
    }
    return map;
  }

  private int getLiveNeighbourCount(Set key) {
    Set<Integer> tempSet = new HashSet<>();
    TreeSet sortedSet = new TreeSet<Integer>(key);
    int counter=0,i=(Integer)sortedSet.first(),j=(Integer)sortedSet.last();

    for(int p=(i-1);p<=(i+1);p++){
     for(int q=(j-1);q<=(j+1);q++){
       if(p!=i||q!=j){
         tempSet=newSet(tempSet,p,q);
         if(map.containsKey(tempSet)){
           counter++;
         }
       }
     }
   }
   return counter;
  }

  private Set<Integer> newSet(Set<Integer> tempSet, int p, int q) {
    tempSet.clear();
    tempSet.add(p);
    tempSet.add(q);
    return tempSet;
  }

}
