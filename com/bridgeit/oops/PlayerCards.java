package com.bridgeit.oops;

import datastructures.PlayerQueue;
import datastructures.Queue;

public class PlayerCards extends DeckOfCards {

	public static void main(String[] args) {
		PlayerCards player = new PlayerCards();
		PlayerCards.getCards();
		player.shuffleCard();
		String playercard[][] = player.distribute(4, 9);
		Queue<Queue<String>> sortedcard = PlayerQueue.cardSort(playercard);
		String playername[] = { "Player 1", "Player 2", "Player 3", "Player 4" };
		int index = 0;
		while (!sortedcard.isEmpty()) {

			Queue<String> temp = sortedcard.deQueue();
			System.out.print(playername[index] + "--> ");
			while (!temp.isEmpty()) {
				System.out.print(temp.deQueue() + "\t  ");
			}
			System.out.println();
			index++;
		}
	}
}
