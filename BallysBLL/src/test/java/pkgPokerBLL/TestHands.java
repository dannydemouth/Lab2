package pkgPokerBLL;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class TestHands {
//s
	@Test
	public void TestFullHouseA() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestFullHouseB() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.THREE, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FOUR, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.FullHouse.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.FOUR.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// LO hand better be 'Three'
		assertEquals(eRank.THREE.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}

	@Test
	public void HighCard() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TWO, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.THREE, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.FIVE, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.TEN, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.KING, eSuit.SPADES));
		h.EvaluateHand();

		// Hand better be a full house
		assertEquals(eHandStrength.HighCard.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		// HI hand better be 'Four'
		assertEquals(eRank.KING.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		// Full House has no kickers.
		assertEquals(4, h.getHandScore().getKickers().size());

	}

	@Test
	public void TestRoyalFlush() {

		Hand h = new Hand();
		h.AddCardToHand(new Card(eRank.TEN, eSuit.CLUBS));
		h.AddCardToHand(new Card(eRank.JACK, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.QUEEN, eSuit.SPADES));
		h.AddCardToHand(new Card(eRank.KING, eSuit.DIAMONDS));
		h.AddCardToHand(new Card(eRank.ACE, eSuit.SPADES));
		h.EvaluateHand();
		
		assertEquals(eHandStrength.RoyalFlush.getHandStrength(), h.getHandScore().getHandStrength().getHandStrength());

		
		assertEquals(eRank.ACE.getiRankNbr(), h.getHandScore().getHiHand().getiRankNbr());

		
		assertEquals(eRank.TEN.getiRankNbr(), h.getHandScore().getLoHand().getiRankNbr());

		//  has no kickers.
		assertEquals(0, h.getHandScore().getKickers().size());

	}
}
