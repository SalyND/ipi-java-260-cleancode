import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

   @Test
    public void zeroQuilles() {
        game.setNombreQuilles(0);
        assertEquals(0, game.calculScore());
    }

    @Test
    public void uneSeuleQuille(){
        game.setNombreQuilles(1);
        assertEquals(1, game.calculScore());
    }
 
    //Trois Strikes consécutifs
    @Test
    public void bonusTroisStrikesConsecutifs(){
	game.setNumeroTir(1);
	game.setNombreQuilles(10);
	game.setNombreQuillesSuiv1(10);
	game.setNombreQuillesSuiv2(10);
	assertEquals(30, game.calculScore());
    }
    
  //Un spare
    @Test
    public void bonusSpare(){
	game.setNumeroTir(4);
	game.setNombreQuilles(8);
	game.setNombreQuillesSuiv1(2);
	game.setNombreQuillesSuiv2(4);
	assertEquals(14, game.calculScore());
    }
    
    
   @Test
    public void spareEtStrike(){
       	game.setNumeroTir(7);
        game.setNombreQuilles(8);
        game.setNombreQuillesSuiv1(2);//10+10
        game.setNombreQuillesSuiv2(10);//10 + 2 + 2
        game.setNombreQuillesSuiv3(2);
        game.setNombreQuillesSuiv4(2);
        assertEquals(34, game.calculScore());
    }
    
    
    @Test
    public void strikeFinal(){
	game.setNumeroTir(20);
        game.setNombreQuilles(10);
        game.setNombreQuillesSuiv1(1);
        assertEquals(11, game.calculScore());
    }

   @Test(expected = Exception.class)
    public void finPartie(){
        game.setNumeroTir(20);
        try {
	game.affichageScore();
	assertEquals(10,game.getIndexFrame());
    }catch (CoupInvalideException e) {
	
    	}
   }
    

  
}
