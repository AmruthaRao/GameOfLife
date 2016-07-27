import org.junit.Assert;
import org.junit.Test;
import tw.gol.assignment.GameOfLife;

public class GameOfLifeTest {
  @Test
  public void singleLiveCellShouldHaveSingleCellInNextGen() {
    boolean[][] input = new boolean[1][1];
    boolean[][] expectedOutput = new boolean[2][2];

    input[0][0] = true;
    Assert.assertArrayEquals(new GameOfLife().nextGeneration(input), expectedOutput);
  }

  @Test
  public void inputCellsResultingInStillLife() {
    boolean[][] input = new boolean[2][2];
    boolean[][] expectedOutput = new boolean[3][3];

    input[0][0] = true;
    input[0][1] = true;
    input[1][0] = true;
    input[1][1] = true;

    expectedOutput[0][0] = true;
    expectedOutput[0][1] = true;
    expectedOutput[1][0] = true;
    expectedOutput[1][1] = true;

    Assert.assertArrayEquals(new GameOfLife().nextGeneration(input), expectedOutput);
  }
  @Test
  public void cellsGivingStillLife() {
    boolean[][] input = new boolean[3][3];
    boolean[][] expectedOutput = new boolean[4][4];

    input[0][1] = true;
    input[1][0] = true;
    input[2][1] = true;
    input[0][2] = true;
    input[1][2] = true;

    expectedOutput[0][1] = true;
    expectedOutput[1][0] = true;
    expectedOutput[2][1] = true;
    expectedOutput[0][2] = true;
    expectedOutput[1][2] = true;

    Assert.assertArrayEquals(new GameOfLife().nextGeneration(input), expectedOutput);
  }
  @Test
  public void inputCellsShouldResultInOscillatingPattern() {
    boolean[][] input = new boolean[2][3];
    boolean[][] expectedOutput = new boolean[3][4];

    input[1][1] = true;
    input[1][0] = true;
    input[1][2] = true;


    expectedOutput[1][1] = true;
    expectedOutput[0][1] = true;
    expectedOutput[2][1] = true;

    Assert.assertArrayEquals(new GameOfLife().nextGeneration(input), expectedOutput);
  }
  @Test
  public void inputCellsShouldResultInTwoPhaseOscillatorPattern(){
    boolean[][] input = new boolean[5][5];
    boolean[][] expectedOutput = new boolean[6][6];

    input[1][1] = true;
    input[1][2] = true;
    input[1][3] = true;
    input[2][2] = true;
    input[2][3] = true;
    input[2][4] = true;

    expectedOutput[0][2] = true;
    expectedOutput[1][1] = true;
    expectedOutput[1][4] = true;
    expectedOutput[2][1] = true;
    expectedOutput[2][4] = true;
    expectedOutput[3][3] = true;

    Assert.assertArrayEquals(new GameOfLife().nextGeneration(input), expectedOutput);
  }
}
