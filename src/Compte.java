import java.util.ArrayList;

public class Compte {
    private double solde;
    private ArrayList<String> operations;
    private ArrayList<String> intitule;

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getOperations() {
        StringBuilder operationsString = new StringBuilder();

        if (this.operations.isEmpty() || this.operations == null || this.intitule.isEmpty() || this.intitule == null) {
            operationsString.append("Aucune operation");
        } else {
            for (int i = 0; i < operations.size(); i++) {
                operationsString.append("(").append(intitule.get(i)).append(" / ").append(operations.get(i)).append(")\n");
            }
        }

        return operationsString.toString();
    }


    public void setOperations(String intitule,String operation) {
        this.intitule.add(intitule);
        this.operations.add(operation);
    }

    public String toString(){
        System.out.println("Votre solde est de : "+getSolde()+"€");
        System.out.println("Les operations effectuées sont les suivantes : ");
        System.out.println(getOperations());
        return "";
    }

    public Compte(){
        this.solde=0;
        this.operations=new ArrayList<>();
        this.intitule=new ArrayList<>();
    }
    
    public void soldeUp(String intitule, double s){
        this.solde+=s;
        String operation = "+" + Double.toString(s)+"€";
        setOperations(intitule, operation);
    }

    public void soldeDown(String intitule, double s){
        this.solde-=s;
        String operation = "-" + Double.toString(s)+"€";
        setOperations(intitule, operation);
    }
    
    public boolean isNegativ(){
        return this.solde<0;
    }
    
    
    
}
