package 
{
	//these three can be commented out after code is done, should run the same
	import flash.events.Event;
	import flash.display.MovieClip;								//use MovieClip instead of sprite
	import flash.events.MouseEvent;								//importing mouse events because this game requires clicking
	
	import flash.display.*;										//imports all classes and function in display 
	import flash.events.*; 										//imports everything under flash events
	import flash.net.*;											
	
	import flash.utils.getTimer;								//imports our method to get system time
	
	/**
	 * ...
	 * @author Renee Fung #301160997
	 */
	
	 public class Game extends MovieClip						//game class extending movieclip
	{
		
		public static const STATE_INIT:int = 10;
		public static const STATE_PLAY:int = 20;
		public static const STATE_GAMEOVER:int = 30;
		
		public static const MAX_CLICKS:int = 10;				//maximum clicks
		
		//GLOBAL VARIABLES 
		public var gameState:int = 0; 							//what state our game is in 
		public var clicks:int = 0;								//keep track of the number of clicks
		public var lastMouseClick:int = 0; 							//how much time has passed since the last time it has been clicked
	
		
		
		public function Game():void 							//constructor - builds the class or object when you make it
		{
			stage.addEventListener(Event.ENTER_FRAME, gameLoop);
			gameState = STATE_INIT; 							//starts the game in the init state
		}
		
		public function gameLoop(e:Event):void 					//game loop constructor - handles chosing which state to run 
		{
			switch(gameState)
			{
				case STATE_INIT : 								//runs if gameState == STATE_INIT
					initGame(); 								//calls function to handle initilization 
					break;										//break out of the state | exits the switch 
				case STATE_PLAY :
					playGame();									//calls function to handle game play 
					break;
				case STATE_GAMEOVER :
					gameOver(); 								//calls function to handle game over and restarting 
					break;
			}
				
		}
		
		public function initGame():void 						//setting up the program to start/reset a game 
		{
			stage.addEventListener(MouseEvent.CLICK, onMouseClickEvent);
			clicks = 0;											//set the clicks back to 0 when the game starts again
			gameState = STATE_PLAY; 							//moves on to run the playGame function
		}
		
		public function playGame():void 						//handles operation and check that need to happen during gameplay
		{
			if (clicks >= MAX_CLICKS)							//losing condition for the game 
			{
				gameState = STATE_GAMEOVER; 					//if the player click 10 or more times, the state will change to game over
			}
	
		}
		
		public function gameOver():void 						//handles cleaning up and end game actions, give player their score 
		{
			stage.removeEventListener(MouseEvent.CLICK, onMouseClickEvent);
			
			trace("game over : P ");							//check to see if the game is over 
			
			gameState = STATE_INIT;								//change the state to init and restart the whole game  
			
		}
		
		public function onMouseClickEvent(e:MouseEvent):void 	//handles processing the action we want to take when we click 
		{
			//clicks = clicks + 1; 								//increment click; whatever it was before plus one more 
			clicks++; 											//same as the top but shorter!
			//clicks += 5; 										//increments by 5
			
			var currentTime:int = getTimer(); 					//gets the current time in milliseconds
			var timeElapsed:int = currentTime - lastMouseClick; //get the time since it was last clicked 
			
			trace("# of clicks : " + clicks + " lasted clicked :  " + timeElapsed + " milliseconds ago.");
			
			lastMouseClick = currentTime; 						//the last mouse click will represent the current time during the game 
		}
		
	}
	
}


//green = document class, first class run at start up 
//change type class by right clicking and unchecking document class
//movieclip has timeline sprite is single image
//* means wild card, anything with a name, import it
//void = no return value 
// ** and // does not exist but *= and /= exists
//elapsed time = how much time has it been since the time it happened