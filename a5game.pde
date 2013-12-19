// a5game

//call image
PImage[] images;

//import minim
import ddf.minim.*;

//game over string
String gameOverText = "Game Over";

//set up sound variables
Minim minim;
AudioSnippet badBirdsHit;
AudioSnippet goodBirdsHit;
AudioSnippet greenPigsHit;

//create boolean for noises
boolean badBirdsNoise;
boolean goodBirdsNoise;
boolean greenPigsNoise;

//arays
Catcher catcher;
Bird[] goodBirds;
Bird[] badBirds;
greenPig[] pig;

final int messageBarHeight = 75;

ScoreBoard score;

//gamestart
boolean gameStart;


void setup() {
  size(500, 500 + messageBarHeight);
  smooth();

  //initialize sound
  minim = new Minim(this);
  badBirdsHit = minim.loadSnippet("cymbal4.wav");
  goodBirdsHit = minim.loadSnippet("distortedkick51.wav");
  greenPigsHit = minim.loadSnippet("explodeNoise.mp3");

  //bird noises
  badBirdsNoise = false;
  goodBirdsNoise = false;
  greenPigsNoise = false;

  // create the catcher
  catcher = new Catcher();

  // load the images
  images = new PImage[7];
  for (int i = 0; i < images.length; ++i) {
    images[i] = loadImage("birds64/pajarito" + (i + 1) + ".png");
  }

  // create the bad birds
  badBirds = new Bird[2];
  badBirds[0] = new Bird(images[3]);
  badBirds[1] = new Bird(images[6]);

  // create the good birds
  goodBirds = new Bird[5];
  goodBirds[0] = new Bird(images[0]);
  goodBirds[1] = new Bird(images[1]);
  goodBirds[2] = new Bird(images[2]);
  goodBirds[3] = new Bird(images[4]);
  goodBirds[4] = new Bird(images[5]);

  // create pigs
  pig = new greenPig[3];
  pig[0] = new greenPig();
  pig[1] = new greenPig();
  pig[2] = new greenPig();

  // create the score board
  score = new ScoreBoard();

  //gamestart
  gameStart = true;
}

void draw() {

  // draw background
  background(255);

  // draw game instructions
  if (gameStart == true) {
    putLabel ("Instructions", 65, 170, 65, color(30, 144, 255));
    
    putLabel ("*Control the paddle with your mouse", 100, 200, 15, color(0, 206, 209));
    putLabel ("*Catch the birds but NOT the RED ones", 100, 220, 15, color(0, 206, 209));
    putLabel ("*Green pigs = automatic death", 100, 240, 15, color(0, 206, 209));
    putLabel ("*Get an extra for every 100 points", 100, 260, 15, color(0, 206, 209));

    putLabel ("Press any key to begin", 100, 300, 25, color(30, 144, 255));
    return;
  }

  //draw birds
  for (int i = 0; i < goodBirds.length; ++i) {
    goodBirds[i].render();
  }

  for (int i = 0; i < badBirds.length; ++i) {
    badBirds[i].render();
  }

  //draw pigs
  for (int i = 0; i < pig.length; ++i) {
    pig[i].render();
  }

  // update birds 
  if (cheat_used || paused) {
    //nothing
  }
  else {
    for (int i = 0; i < goodBirds.length; ++i) {
      goodBirds[i].update();
    }

    for (int i = 0; i < badBirds.length; ++i) {
      badBirds[i].update();
    }

    for (int i = 0; i < pig.length; ++i) {
      pig[i].update();
    }
  }

  if (!cheat_used && paused) {
    //nothing
  }
  else {
    catcher.update();
  }

  catcher.render();

  //paused text
  if (paused) {
    putLabel ("Paused", 75, height / 2, 95, color(0, 255, 0));
  }
  else if (cheat_used) {
    putLabel ("Paused", 75, height / 2, 95, color(0, 255, 0));
  }

  // draw the message bar and score
  fill(200);
  rect(0, 500, 500, messageBarHeight);
  score.render();

  //draw game over
  if (score.num_lives == 0) {
    putLabel(gameOverText, 2, height / 2, 92, color(138, 43, 226));
    //return;
    noLoop();
  }

  // check for collisions
  checkForGoodBirdPaddleCollisions();
  checkForBadBirdPaddleCollisions();
  checkForPigPaddleCollisions();
  checkForGoodBirdEdgeCollisions();
  checkForBadBirdEdgeCollisions();
}

void checkForPigPaddleCollisions() {
  for (int i = 0; i < pig.length; ++i) {
    greenPig p = pig[i];
    if (catcher.contains(p.x + p.pig.width / 2, p.y + p.pig.height / 2)) {
      //caught it
      score.num_lives = 0;

      //make noise
      greenPigsNoise = true;
      greenPigsHit.play(0);
    }
  }
}


void checkForGoodBirdPaddleCollisions() {
  // good birds bounce up off the catcher
  for (int i = 0; i < goodBirds.length; ++i) {
    Bird b = goodBirds[i];
    if (catcher.contains(b.x + b.img.width / 2, b.y + b.img.height / 2)) {
      // caught it!
      score.good_bird_hit_count += 1;
      b.y = catcher.y - b.img.height / 2 - 1;
      b.dy *= -1;
      b.spinRate *= -1;
      //add 1 life for ever 100 points
      score.render();
      for (int j = 0; j<200; j++) {
        if (100*j == score.score) {
          score.num_lives += 1;
        }
      }
    }
  }
}

void checkForBadBirdPaddleCollisions() {
  // if a bad bird hits the catcher, then lose points and speed it up
  for (int i = 0; i < badBirds.length; ++i) {
    Bird b = badBirds[i];
    if (catcher.contains(b.x + b.img.width / 2, b.y + b.img.height / 2)) {
      score.bad_bird_hit_count += 1;
      score.num_lives -= 1;

      float speedUpFactor = random(1.1, 1.4);
      b.dx *= speedUpFactor;
      b.y = catcher.y - b.img.height / 2 - 1;
      b.dy *= -speedUpFactor;
      b.spinRate *= -speedUpFactor;
      
      //make noise
      badBirdsNoise = true;
      badBirdsHit.play(0);
    }
  }
}

void checkForGoodBirdEdgeCollisions() {
  // if a good bird has hit the bottom of the screen, lose points and speed up
  for (int i = 0; i < goodBirds.length; ++i) {
    Bird b = goodBirds[i];

    // lose points if a good bird hits the bottom of the screen; also
    // make the bird speed up
    if (b.y + b.img.height / 2 > 499) {
      score.good_bird_miss_count += 1;
      score.num_lives -= 1;

      float speedUpFactor = random(1.1, 1.4);
      b.dx *= speedUpFactor;
      b.y = 499 - b.img.height / 2;
      b.dy *= -speedUpFactor;
      b.spinRate *= -speedUpFactor;
      
      //make noise
      goodBirdsNoise = true;
      goodBirdsHit.play(0);
    }

    // bounce off the top of the screen
    if (b.y < 0) {
      b.y = 0;
      b.dy = -b.dy;
    }

    // bounce off the left side of the screen
    if (b.x < 0) {
      b.x = 0;
      b.dx = -b.dx;
    }

    // bounce off the right side of the screen
    if (b.x + b.img.width > 499) {
      b.x = 499 - b.img.width;
      b.dx = -b.dx;
    }
  }
}


void checkForBadBirdEdgeCollisions() { 
  // check if a bad bird has hit the bottom of the screen
  for (int i = 0; i < badBirds.length; ++i) {
    Bird b = badBirds[i];

    // good if bad birds hit the screen bottom: just make it bounce up off
    // the bottom
    if (b.y + b.img.height / 2 > 499) {
      score.bad_bird_hit_count += 1;
      b.y = 499 - b.img.height / 2;
      b.dy *= -1;
    }

    // bounce off the top of the screen
    if (b.y < 0) {
      b.y = 0;
      b.dy = -b.dy;
    }

    // bounce off the left side of the screen
    if (b.x < 0) {
      b.x = 0;
      b.dx = -b.dx;
    }

    // bounce off the right side of the screen
    if (b.x + b.img.width > 499) {
      b.x = 499 - b.img.width;
      b.dx = -b.dx;
    }
  }
}

boolean paused;
boolean cheat_used;

void keyPressed() {
  if (key == 'c' || key == 'C') {
    if (cheat_used == false); 
    {
      cheat_used = true;
    }
  }
  else
    if (key == ' ') {
      if (cheat_used == true) {
        cheat_used = false;
      }
      else {
        paused = !paused;
      }
    }
}

void keyReleased() {
  gameStart = false;
}

//stop sound
void stop() {
  badBirdsHit.close();
  goodBirdsHit.close();
  minim.stop();

  super.stop();
}

