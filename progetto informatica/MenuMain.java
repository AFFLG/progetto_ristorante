// (bonus che dovrà dire il suo nome e il suo numero di telefono)
// primo (carbonara/ravioli a vapore/matriciana)
// secondo(sushi/insalata/bistecca)
// dessert(tiramisu/cake/morcji)
// bevanda(acqua naturale/cocacola/birra)
// import java.util.ArrayList;(forse)

import java.util.Scanner;
class MenuMain {

    @SuppressWarnings("resource") // Per levare avviso di Java 
    public static void main(String[] args) {

        
        // String glutine = "Glutine";
        // String uova = "Uova";
        // String latte = "Latte";
        // String soia = "Soia";
        // String salmone = "Salmone";
        // String maiale = "Maiale";
        // String noAllergeni = "Nessun allergene";
        // String frutta = "Frutta";

        
        Primo carbonara = new Primo("Carbonara", "Primo", 10.00, "glutine, uova, latte"); 
        Primo ravioli = new Primo("Ravioli", "Primo", 9.00, "glutine, uova, latte, soia"); //fatti di ricotta (latte) cinesi (soia)
        Primo matriciana = new Primo("Matriciana", "Primo", 11.00, "sussy nigga");

        Secondo sushi = new Secondo("Sushi", "Secondo", 15.00, false, "salmone, glutine"); 
        Secondo insalata = new Secondo("Insalata", "Secondo", 4.00, true, "noallergeni");
        Secondo bistecca = new Secondo("Bistecca", "Secondo", 15.00, false, "maiale"); // tipo di bistecca bistecca di maiale

        Dessert tirsamisu = new Dessert("Tiramisù", "Dessert", 5.00, "uova, latte, glutine");
        Dessert cheesecake = new Dessert("Cheesecake", "Dessert",  6.00, "glutine, latte");
        Dessert morcji = new Dessert("Morcji", "Dessert", 7.00, "frutta");

        Bevanda acquaNaturale = new Bevanda("Acqua naturale", "Bevanda", 1.00, "" ,false);
        Bevanda cocacola = new Bevanda("coca cola", "Bevanda", 2.00,"" , false);
        Bevanda birra = new Bevanda("birra grande", "Bevanda", 5.00, "" , true);


        // Scanner per input utente
        Scanner scanner = new Scanner(System.in);

        System.out.println("  ____                                  _        \r\n" + //
                        " | __ )  ___ _ ____   _____ _ __  _   _| |_ ___  \r\n" + //
                        " |  _ \\ / _ \\ '_ \\ \\ / / _ \\ '_ \\| | | | __/ _ \\ \r\n" + //
                        " | |_) |  __/ | | \\ V /  __/ | | | |_| | || (_) |\r\n" + //
                        " |____/ \\___|_| |_|\\_/ \\___|_| |_|\\__,_|\\__\\___/ \r\n" + //
                        "                                                 ");


        System.out.println("Questo è il menù del giorno");
        System.out.println("Vuoi effettuare un oridne? \nInserisci il tuo nome ");
        
        String nomeCliente  = scanner.nextLine();
        System.out.println("Inserisci il tuo numero di telefono:");
        String telefonoCliente  = scanner.nextLine();
    
        if (telefonoCliente.matches("[0-9]+") && telefonoCliente.length() >= 10) {
            System.out.println("Numero di telefono valido.");
        } 
        else {
            System.out.println("Numero di telefono non valido. Assicurati che contenga solo numeri e abbia almeno 10 cifre.");
            return;  // Uscita se il numero non è valido
        }

        // vado a creare l'ordine
        Ordine ordine = new Ordine(nomeCliente, telefonoCliente);
        // Menu per selezionare i piatti
        System.out.println("\n Scegli il tuo primo piatto:");
        System.out.println("1. Carbonara - 10 euro");
        System.out.println("2. Ravioli - 9 euro");
        System.out.println("3. Matriciana - 11  euro");
        int sceltaPrimo = scanner.nextInt();

        switch (sceltaPrimo) {
        case 1:
            ordine.aggiungiPrimo(carbonara);
            break;
        case 2:
            ordine.aggiungiPrimo(ravioli);
            break;
        case 3:
            ordine.aggiungiPrimo(matriciana);
            break;
        default:
            System.out.println("Scelta non valida.");
            return;
        }
        // Selezione secondo
        System.out.println("\n Scegli il tuo secondo piatto:");
        System.out.println("1. Sushi - 15 euro");
        System.out.println("2. Insalata - 4 euro");
        System.out.println("3. Bistecca - 15 euro");
        int sceltaSecondo = scanner.nextInt();

        switch (sceltaSecondo) {
            case 1:
                ordine.aggiungiSecondo(sushi);
                break;
            case 2:
                ordine.aggiungiSecondo(insalata);
                break;
            case 3:
                ordine.aggiungiSecondo(bistecca);
                break;
            default:
                System.out.println("Scelta non valida.");
                return;
        }

        // Selezione dessert
        System.out.println(" \n Scegli il tuo dessert:");
        System.out.println("1. Tiramisù - 5 euro");
        System.out.println("2. Cheesecake - 6 euro");
        System.out.println("3. Morcji - 7 euro");
        int sceltaDessert = scanner.nextInt();

        switch (sceltaDessert) {
            case 1:
                ordine.aggiungiDessert(tirsamisu);
                break; // interrompere lo switch
            case 2:
                ordine.aggiungiDessert(cheesecake);
                break;
            case 3:
                ordine.aggiungiDessert(morcji);
                break;
            default:
                System.out.println("Scelta non valida.");
                return;
        }

        // Selezione bevanda
        System.out.println("\n Scegli la tua bevanda:");
        System.out.println("1. Acqua naturale - 1 euro");
        System.out.println("2. Cocacola - 2 euro");
        System.out.println("3. Birra grande - 5 euro");
        int sceltaBevanda = scanner.nextInt();

        switch (sceltaBevanda) {
            case 1:
                ordine.aggiungiBevanda(acquaNaturale);
                break;
            case 2:
                ordine.aggiungiBevanda(cocacola);
                break;
            case 3:
                ordine.aggiungiBevanda(birra);
                break;
            default:
                System.out.println("Scelta non valida.");  // il cliente sceglie un numero che non è selezionato
                return;
        }
        System.out.println("\n Vuoi visualizzare gli allergeni ? (digitia 1 se SI digita 2 se NO) ");

        int visualizzaAllergeni = scanner.nextInt();
        switch (visualizzaAllergeni) {
            case 1:
                ordine.primo.stampaAllergeni();
                ordine.secondo.stampaAllergeni();
                ordine.dessert.stampaAllergeni();
                break;
            case 2:
                System.out.println("\nOk! a seguito ci sarà il totale dell'ordine ");
                break;
        }
        
          // Stampa ordine e totale
          ordine.stampaOrdine();
          // Chiudiamo l'input
          scanner.close();

     
    }

}
        
    
    
     
    
    

