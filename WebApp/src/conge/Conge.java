package conge;

/**
 * @author Walid Gaaloul
 *
 */
public class Conge {
	private static Conge instance = null;
    private Boolean jours [] ;
    
    /**
     * Constructeur privé
     */
    private Conge(){
    	jours = new Boolean [365];
        for (int i=0; i<jours.length; i++)
        	jours[i]=Boolean.TRUE;
    }
    
    /**
     * @return une instance de Conge
     */
    public static Conge instance() {
    	if(instance==null)
        	instance = new Conge();
        return instance;
    } 
    
    /**
     * @param jour du congé
     * @return vrai si le jour est dispo false si le jour est pris ou la valeur de jour n'est pas valide
     */
    public boolean verifierJour(int jour) {
    	if((jour<365) && (jour>=0))
    	    return jours[jour].booleanValue();
    	return Boolean.FALSE;
    }
    
    /**
     * @param jour du congé
     * la fonction permet de poser un jour de congé
     */
	public void poserJour(int jour){
		jours[jour]=Boolean.FALSE;
	}

}
