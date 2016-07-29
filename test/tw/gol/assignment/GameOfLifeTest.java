package tw.gol.assignment;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameOfLifeTest {

  @Test
  public void nextGenerationOfAGenerationWithOneLiveCellIsNull(){
    HashMap<Set<Integer>,Boolean> inputMap = new HashMap<>();
    HashMap<Set<Integer>,Boolean> outputMap = new HashMap<>();
    inputMap=getFirstInput(inputMap);
    Assert.assertEquals(outputMap,new GameOfLife(inputMap).getNextGeneration());
  }

  @Test
  public void nextGenerationOfTheGivenGenerationShouldBeSame(){
    HashMap<Set<Integer>,Boolean> inputMap = new HashMap<>();
    HashMap<Set<Integer>,Boolean> outputMap = new HashMap<>();
    inputMap=getStillStateInput(inputMap);
    outputMap=inputMap;
    Assert.assertEquals(outputMap,new GameOfLife(inputMap).getNextGeneration());
  }
  @Test
  public void nextGenerationOfTheGivenGenerationShouldBeOscillating(){
    HashMap<Set<Integer>,Boolean> inputMap = new HashMap<>();
    HashMap<Set<Integer>,Boolean> outputMap = new HashMap<>();
    inputMap=getOscillationStateInput(inputMap);
    outputMap=getOscillationStateOutput(outputMap);
    Assert.assertEquals(outputMap,new GameOfLife(inputMap).getNextGeneration());
  }

  private HashMap<Set<Integer>,Boolean> getOscillationStateOutput(HashMap<Set<Integer>, Boolean> outputMap) {
    Set<Integer> set = new HashSet<>();
    outputMap.put(set,true);
    set= add(set,1,1);
    outputMap.put(set,true);
    set= add(set,0,1);
    outputMap.put(set,true);
    set= add(set,2,1);
    outputMap.put(set,true);
    return outputMap;
  }

  private HashMap<Set<Integer>,Boolean> getOscillationStateInput(HashMap<Set<Integer>, Boolean> inputMap) {
    Set<Integer> set = new HashSet<>();
    set= add(set,1,1);
    inputMap.put(set,true);
    set= add(set,1,0);
    inputMap.put(set,true);
    set= add(set,1,2);
    inputMap.put(set,true);
    return inputMap;
  }

  private HashMap<Set<Integer>, Boolean> getStillStateInput(HashMap<Set<Integer>, Boolean> inputMap) {
    Set<Integer> set = new HashSet<>();
    set= add(set,1,1);
    inputMap.put(set,true);
    set= add(set,1,2);
    inputMap.put(set,true);
    set= add(set,2,1);
    inputMap.put(set,true);
    set= add(set,2,2);
    inputMap.put(set,true);
    return inputMap;
  }

  private Set<Integer> add(Set<Integer> set,int a,int b) {
    set.clear();
    set.add(a);
    set.add(b);
    return set;
  }


  private HashMap<Set<Integer>, Boolean> getFirstInput(HashMap<Set<Integer>, Boolean> map) {
    Set<Integer> set = new HashSet<>();
    set=add(set,0,1);
    map.put(set,true);
  return map;
  }


}
