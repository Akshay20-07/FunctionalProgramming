package com.sample.java.streams;

public class Lambda {
	
	public static void main(String[] args) {
		
		//Imperative Way
		Game football=new Game() {
			
			@Override
			public void play() {
				System.out.println("I am playing FootBall");
				
			}
		};
		football.play();
		
		Game basketBall= new Game() {
			
			@Override
			public void play() {
				System.out.println("I am playing BasketBall");
				
			}
		};
		basketBall.play();
		
		//Functional Way
		Game footBallLambda= ()-> System.out.println("I am playing FootBallLambda");
		footBallLambda.play();
		
		Game basketBallLambda= () -> System.out.println("I am playing BasketBalllambda");
		basketBallLambda.play();
	}

	interface Game{
		void play();
	}
}
