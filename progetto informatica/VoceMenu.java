//classe astratta VoceMenu, ristorante implementi gestione Menu e odrdini
//gestione di un ristorante descrizione:
//implementa un sistema per gestire il menu e gli ordini. 
//dettagli tecnici: Classe Astratta: VoceMenu con metodi come calcolaPrezzo(). 
//Sottoclassi: Primo, Secondo, Dessert, Bevanda. 
//polimorfismo: Diverse implementazioni per il calcolo del prezzo (es. con IVA o sconti).
//Gestione errori: Controlla che il prezzo sia sempre positivo.
// nel main arry
// lui possa fare un ordine dove può scegliere il primo, il secondo, il dessert e la bevanda ognuno avrà 
// una scelta di massimo 3 cose 
// (bonus che dovrà dire il suo nome e il suo numero di telefono)
// primo (carbonara/ravioli a vapore/matriciana)
// secondo(sushi/insalata/bistecca)
// dessert(tiramisu/cake/morcji)
// bevanda(acqua naturale/cocacola/birra)
//aggiungere lista allergeni

//progetto Teodora Li e Alessandra Logli

public class VoceMenu{
 
    protected String nome;  // nome del piatto
    protected double prezzoBase;
    protected boolean disponibile;
    protected String allergeni;
    protected String tipologia;

    

    public VoceMenu(String nome, String tipo, double prezzoBase, String allergeni) {
        this.nome = nome;
        this.allergeni = allergeni;
        this.tipologia = tipo;
        // controllo che il prezzo non sia negativo
        if(prezzoBase < 0){
            this.prezzoBase = 0;
            // System.out.println("ERRORE: il prezzo non può essere negativo. Sarà impostato a 0.");
        }else{
            this.prezzoBase = prezzoBase;
        }
    }


    public void stampaNome(){
        System.out.println(tipologia  + " : " +  nome);
    }    

    public void stampaAllergeni(){
        System.out.println("Lista allergeni:  per " + nome + ": " + allergeni);
    }

    public double getPrezzo(){
        return prezzoBase;
    }

    }
    // Sottoclassi per ogni tipo di voce del menu
    //mettiamo un IVA del %10
    class Primo extends VoceMenu {
        public Primo(String nome, String tipo, double prezzo, String allergeni) {
        super(nome, tipo, prezzo, allergeni);
    }


    public void Preparazione(){
        System.out.println("Il primo" + nome + " è in preparazione");
        try {
            Thread.sleep(1000);
            System.out.println("Il piatto è stato preparato");
        } catch (Exception e){
        }
    }

    @Override
    public double getPrezzo(){
        return prezzoBase + (prezzoBase * 0.10);
    }

}


class Secondo extends VoceMenu {
    public boolean vegetariano;

    public Secondo(String nome, String tipo, double prezzo, boolean vegetariano, String allergeni) {
       super(nome, tipo, prezzo, allergeni);
       this.vegetariano = vegetariano;
    }
    
    public void Preparazione(){
        System.out.println("Il secondo:" + nome + " è in preparazione");
        try {
            Thread.sleep(2000);
            System.out.println("Il piatto è stato preparato");
        } catch (Exception e) {
            
        }
    }

    public double getPrezzo(){
        return prezzoBase + (prezzoBase * 0.10);
    }
}


class Dessert extends VoceMenu {
    public Dessert(String nome, String tipo, double prezzo, String allergeni) {
        super(nome, tipo, prezzo, allergeni);
    }
    
    public void Preparazione(){
        System.out.println("Il dessert" + nome + " è in preparazione");
        try {
            Thread.sleep(1000);
            System.out.println("Il piatto è stato preparato");
        } catch (Exception e) {
           
        }
    }

    public double getPrezzo(){
        return prezzoBase + (prezzoBase * 0.22);
    }
}


class Bevanda extends VoceMenu {
    public boolean alcolico;

    public Bevanda(String nome, String tipo, double prezzo, String allergeni, boolean alcolico) {
        super(nome, tipo, prezzo, allergeni);
        this.alcolico = alcolico;
    }

    public double getPrezzo(){
        return prezzoBase + (prezzoBase * 0.22);
    }

}

// Classe per gestire l'ordine
class Ordine {
    String nomeCliente;
    String numeroTelefono;
    Primo primo;
    Secondo secondo;
    Dessert dessert;
    Bevanda bevanda;


public Ordine(String nomeCliente, String numeroTelefono) {
    this.nomeCliente = nomeCliente;
    if (numeroTelefono.matches("[0-9]+") && numeroTelefono.length() >= 10) { // confronto stringa//qualsiasi numero da 0 a 9
        this.numeroTelefono = numeroTelefono;                                     // length restituisce il valore della stringa(numeri dei caratteri che contiene)
    } else {                                                                     // >= massimo 10 caratteri 
        System.out.println("Errore: numero telefonico non valido.");
        this.numeroTelefono = "Numero valido";
    }
}
 

// aggiunta all'ordine fatto dal cliente
public void aggiungiPrimo(Primo primo) {
    this.primo = primo;
}
public void aggiungiSecondo(Secondo Secondo) {
    this.secondo = Secondo;
}
public void aggiungiDessert(Dessert Dessert) {
    this.dessert = Dessert;
}
public void aggiungiBevanda(Bevanda Bevanda) {
    this.bevanda = Bevanda;
}

// un totale manca il prezzo a quelli sopra 
public double calcoloTotale(){
    double totaleOrdine = 0;
    totaleOrdine = primo.getPrezzo() + secondo.getPrezzo() + dessert.getPrezzo() + bevanda.getPrezzo();
    System.out.println("Il totale è: " + totaleOrdine );
    return totaleOrdine;

}


// Stampa dell'ordine
//stampa dello socntrino
      public void stampaOrdine() {
        System.out.println("\n");
        System.out.println("Ordine per: " + nomeCliente);
        System.out.println("Telefono: " + numeroTelefono);
        primo.stampaNome();
        secondo.stampaNome();
        dessert.stampaNome();
        bevanda.stampaNome();
        System.out.println("Prezzo totale: " + calcoloTotale() + "euro");
    }
}