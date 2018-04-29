import java.util.ArrayList;

public class BowlingGame {
    
    /*
     * Quelques règles : 
     * 10 * 2 Tirs par partie soit 20 tirs possibles au total
     * Si un joueur fait tomber toutes les quilles dès le premier lancer du carreau,
     * il réalise un strike et ne fait pas de deuxième lancer.*/
    
    private int score = 0;
    private int numeroTir = 1;
    private int numeroFrame = 1;
    public int indexFrame=0;
    private int scoreTotal = 0;
    private int nombreQuilles = 0;
    private int nombreQuillesSuiv1 = 0;
    private int nombreQuillesSuiv2 = 0;
    private int nombreQuillesSuiv3 = 0;
    private int nombreQuillesSuiv4 = 0;
    public ArrayList<Object> frame = new ArrayList<>();
    private int[] resultat = new int[21];
    
    
    //Regles du jeu -----------------------------------------------------------------
    
   private boolean unStrike() {
	if(numeroTir %2 == 1 && 
		nombreQuilles == 10) {
	    return true;
	}
	else {
	    return false;
	}
   }

   private boolean unSpare() {
	if(numeroTir %2 == 0 && 
		(nombreQuilles + nombreQuillesSuiv1 == 10)) {
	    return true;
	}
	else {
	    return false;
	}
   }
   private boolean unSpareUnStrike() {
	if((nombreQuilles + nombreQuillesSuiv1 == 10) && 
		(nombreQuillesSuiv2 == 10)) {
	    return true;
	}
	else {
	    return false;
	}
   }
	
   private boolean strikeFinal() {
        if(numeroTir == 20 && nombreQuilles == 10) {
            return true;
        }
        else {
            return false;
        }
   }
    
    
    //Calcul score -----------------------------------------------------------------
    public int calculScore() {
	//Strike - Toutes les quilles sont tombées dès le premier lancer
	if(unStrike() == true && numeroTir < 20) {
	    for(int numeroTir = 0; numeroTir < 20; numeroTir++) { 
		resultat[numeroTir] = nombreQuilles;
	    }
	    resultat[numeroTir +1] = nombreQuillesSuiv1;
	    resultat[numeroTir +2] = nombreQuillesSuiv2;
	    score = 10 + resultat[numeroTir + 1] + resultat[numeroTir + 2];
	}
	
	//Spare - Toutes les quilles sont tombées en deux lancer appartemant au meme frame
	else if(unSpare() == true){
	    	resultat[numeroTir] = nombreQuilles;
	    	resultat[numeroTir +1] = nombreQuillesSuiv1;
	    	resultat[numeroTir +2] = nombreQuillesSuiv2;
	 	score = 10 + resultat[numeroTir + 2] ;
	 	numeroTir+=1;
	 	return score;	
	 }
	
	//Spare et Strike
	else if (unSpareUnStrike() == true) {
	    	resultat[numeroTir] = nombreQuilles;
	    	resultat[numeroTir +1] = nombreQuillesSuiv1;
	    	resultat[numeroTir +2] = nombreQuillesSuiv2;
	    	resultat[numeroTir +3] = nombreQuillesSuiv3;
	    	resultat[numeroTir +4] = nombreQuillesSuiv4;
	 	score = (10 + resultat[numeroTir + 2]) + (10+ resultat[numeroTir +3] + resultat[numeroTir +4]);
	 	numeroTir+=2;
	 	return score;	
	    
	}
	
	//Si strike au dernier Tir
	else if(strikeFinal() == true){
		    resultat[20] = 10 + nombreQuillesSuiv1;
		    score = 10 + nombreQuillesSuiv1;
		    return score;
	}
	
	//Sinon on calcule simplement le nombre de quilles tombées
	else {
	 resultat[numeroTir] = nombreQuilles;
	 score = nombreQuilles;
	 numeroTir++;
	 System.out.println("Vous venez de marquer " + score + " points");
	 
	 
	}
	return score;
	
}

   
    //Affichage score -----------------------------------------------------------------
    public Object affichageScore() {
        for(int indexFrame=0;indexFrame<10; indexFrame++) {
            score = resultat[numeroTir] + resultat[numeroTir++];
        }
        return frame.set(indexFrame, getResultat());
}
	
     //Fin de la partie au 20eme lancer  ----------------------------------------------
    public int scoretotal() throws CoupInvalideException {
	if(numeroTir == 20 || (numeroTir ==20 && unStrike() == true)) {
	    System.out.println("La partie est terminée");
	}
	for (int i = 0; i<= resultat.length; i++) {
	scoreTotal = resultat[i] + resultat[i+1];
	}
	resultat[21] = scoreTotal;
   	return scoreTotal;
    }

  

    
   
    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotalt) {
        this.scoreTotal = scoreTotalt;
    }

    public int getNombreQuilles() {
        return nombreQuilles;
    }

    public void setNombreQuilles(int nombreQuilles) {
        this.nombreQuilles = nombreQuilles;
    }

    public int getNombreQuillesSuiv1() {
        return nombreQuillesSuiv1;
    }

    public void setNombreQuillesSuiv1(int nombreQuillesSuiv1) {
        this.nombreQuillesSuiv1 = nombreQuillesSuiv1;
    }

    public int getNombreQuillesSuiv2() {
        return nombreQuillesSuiv2;
    }

    public void setNombreQuillesSuiv2(int nombreQuillesSuiv2) {
        this.nombreQuillesSuiv2 = nombreQuillesSuiv2;
    }
    public int getNombreQuillesSuiv3() {
        return nombreQuillesSuiv3;
    }

    public void setNombreQuillesSuiv3(int nombreQuillesSuiv3) {
        this.nombreQuillesSuiv3 = nombreQuillesSuiv3;
    }

    public int getNombreQuillesSuiv4() {
        return nombreQuillesSuiv4;
    }

    public void setNombreQuillesSuiv4(int nombreQuillesSuiv4) {
        this.nombreQuillesSuiv4 = nombreQuillesSuiv4;
    }


     public int[] getResultat() {
        return resultat;
    }

    public void setResultat(int[] resultat) {
        this.resultat = resultat;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumeroTir() {
        return numeroTir;
    }

    public void setNumeroTir(int numeroTir) {
        this.numeroTir = numeroTir;
    }

    public int getNumeroFrame() {
        return numeroFrame;
    }

    public void setNumeroFrame(int numeroFrame) {
        this.numeroFrame = numeroFrame;
    }

    public int getIndexFrame() {
        return indexFrame;
    }

    public void setIndexFrame(int indexFrame) {
        this.indexFrame = indexFrame;
    }

    public ArrayList<Object> getFrame() {
        return frame;
    }

    public void setFrame(ArrayList<Object> frame) {
        this.frame = frame;
    }

    
    
}
