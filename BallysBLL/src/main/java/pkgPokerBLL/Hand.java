package pkgPokerBLL;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import pkgPokerEnum.eCardNo;
import pkgPokerEnum.eHandStrength;



public class Hand {

	private UUID HandID;
	private boolean bIsScored;
	private HandScore HS;
	private ArrayList<Card> CardsInHand = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public void AddCardToHand(Card c)
	{
		CardsInHand.add(c);
	}

	public ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}
	
	public HandScore getHandScore()
	{
		return HS;
	}
	
	public Hand EvaluateHand()
	{
		Hand h = Hand.EvaluateHand(this);
		return h;
	}
	
	private static Hand EvaluateHand(Hand h)  {

		Collections.sort(h.getCardsInHand());
		
		//	Another way to sort
		//	Collections.sort(h.getCardsInHand(), Card.CardRank);
		
		HandScore hs = new HandScore();
		try {
			Class<?> c = Class.forName("pkgPokerBLL.Hand");

			for (eHandStrength hstr : eHandStrength.values()) {
				Class[] cArg = new Class[2];
				cArg[0] = pkgPokerBLL.Hand.class;
				cArg[1] = pkgPokerBLL.HandScore.class;

				Method meth = c.getMethod(hstr.getEvalMethod(), cArg);
				Object o = meth.invoke(null, new Object[] { h, hs });

				// If o = true, that means the hand evaluated- skip the rest of
				// the evaluations
				if ((Boolean) o) {
					break;
				}
			}

			h.bIsScored = true;
			h.HS = hs;

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	
	
	
	
	
	
	
	
	
	
	//TODO: Implement This Method
	public static boolean isHandRoyalFlush(Hand h, HandScore hs)
	{
		
		return false;
	}
	
	//TODO: Implement This Method
	public static boolean isHandStraightFlush(Hand h, HandScore hs)
	{
		return false;
	}	
	//TODO: Implement This Method
	public static boolean isHandFourOfAKind(Hand h, HandScore hs)
	{
		boolean isFourOfAKind = false;
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()))
		{
			
			isFourOfAKind = true;
			hs.setHandStrength(eHandStrength.FourOfAKind);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
			return isFourOfAKind;
			
		}
		else if ((h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()))
		{
			isFourOfAKind = true;
			hs.setHandStrength(eHandStrength.FourOfAKind);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank());
			return isFourOfAKind;
		}
		else{
			return isFourOfAKind = false;
		}
	}	
	
	//TODO: Implement This Method
	public static boolean isHandFlush(Hand h, HandScore hs)
	{
		return true;
	}		
	
	//TODO: Implement This Method
	public static boolean isHandStraight(Hand h, HandScore hs)
	{
		return false;
	}	
	
	//TODO: Implement This Method
	public static boolean isHandThreeOfAKind(Hand h, HandScore hs)
	{
		boolean isThreeOfAKind = false;
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()))
		{
			
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
			return isThreeOfAKind;
			
		}
		else if ((h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()))
		{
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank());
			return isThreeOfAKind;
		}
		else if((h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()))
		{
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank());
			return isThreeOfAKind;
		}
		else{
			return isThreeOfAKind = false;
		}
	}		
	
	//TODO: Implement This Method
	public static boolean isHandTwoPair(Hand h, HandScore hs)
	{
		boolean is2Pair = false;
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank()) && 
				((h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) || 
				(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank())))
		{
			
			is2Pair = true;
			hs.setHandStrength(eHandStrength.TwoPair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank()); //high is first
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank());
			return is2Pair;
			
		}
		else if ((h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank())&&
				(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()))
		{
			is2Pair = true;
			hs.setHandStrength(eHandStrength.TwoPair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank());
			return is2Pair;
		}
		
		else{
			return is2Pair = false;
		}

	}	
	
	//TODO: Implement This Method
	public static boolean isHandPair(Hand h, HandScore hs)
	{
		boolean isPair = false;
		if((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank()))
		{
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
			return isPair;
		}
		else if((h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()))
		{
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank());
			return isPair;
		}
		else if((h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()))
		{
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank());
			return isPair;
		}
		else if((h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()))
		{
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank());
			return isPair;
		}
		else{
			
		
		return false;
		}
	}	
	
	//TODO: Implement This Method
	public static boolean isHandHighCard(Hand h, HandScore hs)
	{
		return false;
	}	
	
	//TODO: Implement This Method
	public static boolean isAcesAndEights(Hand h, HandScore hs)
	{
		return false;
	}	
	
	
	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean isFullHouse = false;
		
		ArrayList<Card> kickers = new ArrayList<Card>();
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank())
				&& (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank());
		} else if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank())
				&& (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank())) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse);
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank());
		}

		return isFullHouse;

	}
}
