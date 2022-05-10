import processing.core.PApplet;
import processing.core.PImage;

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
  PImage heart;
  boolean live1 = true;
  boolean live2 = true;
  boolean live3 = true;  

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
      
     
    // Collision Detection
      if(circleX <= playerX && circleX >= playerX + 50 && circleY[circleX] == playerY) {
        if(live1 == false) {
          if(live2 == false){
            live3 = false;
          }
          else{
            live2 =false;
          }
        }
        else{
          live1 = false;
        } 
      }

    }
    
  
    for (int i = 0; i < 50; i++) {
      circleY[i] += snowSpeed;
      if (circleY[i] >= 800) {
        circleY[i] = 0;
        snowfall[i] += 5;
      }
    }

    // Make player blue
    fill(0,0,255);

    // Draw Player
    ellipse(playerX, playerY, 50, 50);

    // Make snow white
    fill(255, 255, 255);
    
    // Lives
    heart = loadImage("../heart.png");
    heart.resize(50,50);

    if(live1 == true) {
      image(heart, 735, 20);
    }
    
    if(live2 == true) {
      image(heart, 670, 20);
    }

    if(live3 == true) {
      image(heart, 605, 20);
    }

    // Collision Detection

    
    
    // Game Over
    if(live1 == false && live2 == false && live3 == false) {
      background(255, 255, 255);
    } 
  }

  public void keyPressed() {
    
    // Snowfall speed
    if (keyCode == UP) {
      snowSpeed = 1;
    }
    if (keyCode == DOWN) {
      snowSpeed = 5;
    }

    // Player movement
    if (key == 'w') {
      playerY -= 5;
    }

    if (key == 's') {
      playerY += 5;
    }

    if (key == 'a') {
      playerX -= 5;
    }

    if (key == 'd') {
      playerX += 5;
    }
  }

  public void keyReleased() {
    snowSpeed = 3;
  }

}