package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import logic.GameLogic;
import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;
import role.derived.Detective;
import role.derived.Mayor;
import role.derived.Mafia;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		int playerNumber = rand.nextInt(8);
		
		Player player = GameLogic.getInstance().getPlayerList().get(playerNumber);
		
		System.out.println("Your name is "+player.getPlayerName());
		
		if(player instanceof Detective) {
			player = (Detective)player;
			System.out.println("Your role is Detective");
		}
		else if (player instanceof Mayor) {
			player = (Mayor)player;
			System.out.println("Your role is Mayor");
		}
		else {
			player = (Mafia)player;
			System.out.println("Your role is Mafia");
		}
		
		
		
		while(!GameLogic.getInstance().isGameEnd()) {
			
			if(GameLogic.getInstance().isNightTime()) {
				System.out.println("the night has come.");
			}
			else {
				System.out.println("the day has come.");
			}
			
			System.out.println(GameLogic.getInstance().getPlayerList().size() + " players left.");
			//list of left players
			String leftPlayers = "[";
			
			for(int i = 0;i<GameLogic.getInstance().getPlayerList().size();i++) {
				leftPlayers += GameLogic.getInstance().getPlayerList().get(i).getPlayerName();
				if(i<GameLogic.getInstance().getPlayerList().size()-1) {
					leftPlayers += ", ";
				}
			}
			System.out.println(leftPlayers +"]");
			
			//target players of the actions
			ArrayList<Player> actionTargetList = new ArrayList<Player>();
			
			//target voted players
			ArrayList<Player> voteTargetList = new ArrayList<Player>();
			
			//for Player in player list randomly do dayAction
			for(int i = 0;i<GameLogic.getInstance().getPlayerList().size();i++) {
				//if Player == player insert input
				if(player.getPlayerName() == GameLogic.getInstance().getPlayerList().get(i).getPlayerName()) {
					String actionInput = "";
					boolean takeAction = false;
					if((GameLogic.getInstance().isNightTime()&&player instanceof NightActable)||(!GameLogic.getInstance().isNightTime()&&player instanceof DayActable)){
						System.out.println("type a player's name to take an action to him/her.");
						actionInput = sc.nextLine();
					}
					for(Player p:GameLogic.getInstance().getPlayerList()) {
						if(actionInput.equals(p.getPlayerName())) {
							actionTargetList.add(p);
							takeAction = true;
						}
					}
					if(!takeAction) {
						actionTargetList.add(new Player(""));
					}
					if(!GameLogic.getInstance().isNightTime()) {
						System.out.println("type a player's name to vote him/her.");
						String voteInput = sc.nextLine();
						for(Player p:GameLogic.getInstance().getPlayerList()) {
							if(voteInput.equals(p.getPlayerName())) {
								voteTargetList.add(p);
							}
						}
					}
				}
				else {
					//other players randomly take actions and vote
					int randActPlayer = rand.nextInt(GameLogic.getInstance().getPlayerList().size());	
					actionTargetList.add(GameLogic.getInstance().getPlayerList().get(randActPlayer));
					if(!GameLogic.getInstance().isNightTime()) {
						int randVotePlayer = rand.nextInt(GameLogic.getInstance().getPlayerList().size());	
						voteTargetList.add(GameLogic.getInstance().getPlayerList().get(randVotePlayer));
					}
				}
				
				
			}


			if(!GameLogic.getInstance().isNightTime()) {
				//take dayAction
				GameLogic.getInstance().doDayAction(actionTargetList);
				//voting
				GameLogic.getInstance().voting(voteTargetList);
				//removeVotedPlayer
				Player votedOutPlayer = GameLogic.getInstance().removeVotedPlayer();
				System.out.println(votedOutPlayer.getPlayerName() + " has been voted out.");	
			}
			else {
				GameLogic.getInstance().doNightAction(actionTargetList);
			}
			
			//Check that does game end
			GameLogic.getInstance().checkGameEnd();
			
			//reset voted score
			GameLogic.getInstance().resetAllVotes();
			
			//toggle Night and Day
			GameLogic.getInstance().setNightTime(!GameLogic.getInstance().isNightTime());
			

			System.out.println("================================================");
		}
	
	}
	
}
