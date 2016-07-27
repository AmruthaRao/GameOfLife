package tw.gol.assignment;


public class GameOfLife {
  public int maxX;
  public int maxY;
  boolean expectedOutput[][];

  public boolean[][] nextGeneration(boolean[][] input) {
    maxX = (input.length);
    maxY = 0;
    int i, j;
    for (i = 0; i < maxX; i++) {
      if (input[i].length > maxY) {
        maxY = input[i].length;
      }
    }
    maxY++;
    maxX++;

    expectedOutput = new boolean[maxX][maxY];
    expectedOutput = updateLives(input);
    return expectedOutput;
  }

  public int numberOfLiveNeighbours(boolean input[][], int xCoordinate, int yCoordinate) {
    int counter = 0;
    for (int i = xCoordinate - 1; i <= xCoordinate + 1; i++) {
      for (int j = yCoordinate - 1; j <= yCoordinate + 1; j++) {
        if ((i >= 0) && (j >= 0) && (i < maxX - 1) && (j < maxY - 1)) {

          if (input[i][j] == true) {
            counter++;
          }
        }
      }
    }
    return counter;
  }

  public boolean[][] updateLives(boolean input[][]) {
    int n;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        n = numberOfLiveNeighbours(input, i, j);
        if (i == maxX - 1 || j == maxY - 1) {
          if (n == 3) {
            expectedOutput[i][j] = true;
          }
        } else {
          if (input[i][j] == true) {
            n--;
            if (n > 3 || n < 2) {
              expectedOutput[i][j] = false;
            }
            else
              expectedOutput[i][j] = true;

          } else if (input[i][j] == false && n == 3) {
            expectedOutput[i][j] = true;
          }
        }

      }
    }
    return expectedOutput;

  }
}
