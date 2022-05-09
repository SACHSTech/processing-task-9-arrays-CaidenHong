import processing.core.PApplet;

public class Sketch extends PApplet {

  float[] circleY = new float[50];
  float[] snowfall = new float[50];
  float[] mousePositionsX = new float[25];
  float[] mousePositionsY = new float[25];
  int snowSpeed = 3;
  int num = 25;
  int index = 0;
  float playerX = 50;
  float playerY = 750;
  
  public void settings() {
    size(800, 800);
  }

  public void setup() {
    background(0);
    for (int i = 0; i < 50; i++) {
      circleY[i] = random(0, 800);
    }
    for (int i = 0; i < 50; i++) {
      snowfall[i] = 5;
    }
  }

  public void draw() {

    background(0);

    // Drawing falling snow
    for (int circleX = 0; circleX < 50; circleX++) {
      ellipse(circleX*16, circleY[circleX], 12, 12);
    }
  
    for (int i = 0; i < 50; i++) {
      circleY[i] += snowSpeed;
      if (circleY[i] >= 800) {
        circleY[i] = 0;
        snowfall[i] += 5;
      }
    }

    ellipse(playerX, playerY, 30, 30);
  }
  public void keyPressed() {
    if (keyCode == UP) {
      snowSpeed = 1;
    }
    if (keyCode == DOWN) {
      snowSpeed = 5;
    }
  }

  public void keyReleased() {
    snowSpeed = 3;
  }

}