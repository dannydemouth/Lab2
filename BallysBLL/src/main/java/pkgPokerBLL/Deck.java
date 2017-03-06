package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck()
	{
		//TODO: Implement This Constructor (no-arg Deck should build up a deck with 52 cards)
		
		//	This method will do a for/each, returning each rank in the enum.
		for (eRank Rank : eRank.values()) {
			System.out.println(Rank.getiRankNbr());
		}
		Collections.shuffle(DeckCards);
		Collections.sort(DeckCards);
		Collections.sort(DeckCards,Card.CardRank);
		
	}
	public Deck(int iNbrOfJokers)
{
	//
	this();
	
}
	public Deck(int iNbrOfJokers, ArrayList<Card> Wilds)
	{
		this(iNbrOfJokers); //this or super must be first statement in the constructor.
	}
	
	public Card DrawCard()
	{
		//	TODO: Implement this method... should draw a card from the deck.
		
		return null;
	}
}
