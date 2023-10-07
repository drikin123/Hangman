import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Pendu {

    static String[] ssfinal;
    static ArrayList<String> utilise=new ArrayList<>();

    public static void setUtilise(String s){
        int res=0;
        for(String ss : utilise){
            if(ss.toUpperCase().equals(s.toUpperCase())){
                res++;
            }
        }
        if(res==0){
            utilise.add(s);
        }
        System.out.print("( ");
        for(String str : utilise){
            System.out.print(str+" ");
        }
        System.out.print(")");
    }

    public static void setLettredecouvertes(String s, String[] d){
        String[] ss=s.split("");

        int res=0;

        for(int i=0;i<d.length;i++){
            res=0;
            for(String lettre : ss){
                if(lettre.equals(d[i].toUpperCase())){
                    res=0;
                }else{
                    res++;
                }
                if(res==ss.length){
                    Dessin.erreurs();
                }
            }
        }

    }

    public static void decouvert(String s, String[] d){
        String[] ss=s.split("");

        for(int i=0;i<ss.length;i++){
            for(int j=0;j<d.length;j++){
                if(ss[i].equals(d[j].toUpperCase())){
                    ssfinal[i]=d[j].toUpperCase();
                }
            }
        }

        for (String lettre : ssfinal){
            System.out.print(lettre);
        }
        System.out.println();


    }

    public static void recommence(){
        Dessin.compteur=0;
        ssfinal=new String[0];
        utilise=new ArrayList<>();
    }

    public static void jeu(String motChoisi){
        ssfinal=new String[motChoisi.split("").length];

        for(int k=0;k<ssfinal.length;k++){
            ssfinal[k]="_";
        }
        while(true) {

            if (Dessin.compteur == 7) {
                System.out.println("vous avez perdu, le mot était : "+motChoisi);
                break;
            }

            String chaine = String.join("", ssfinal);

            if(chaine.equals(motChoisi)){
                System.out.println("\uD83C\uDF89 \uD83C\uDF89 \uD83C\uDF89 C'est gagné! \uD83C\uDF89 \uD83C\uDF89 \uD83C\uDF89");
                break;
            }
            Scanner myObj = new Scanner(System.in);
            System.out.print("Donnes moi une lettre \uD83E\uDEF4");
            String nvlet = myObj.nextLine();
            setUtilise(nvlet);
            System.out.println();
            String[] queUn = nvlet.split("");
            if (queUn.length != 1) {
                throw new Error("Une seule lettre, fin de partie pour toi \uD83D\uDED1");
            }


            decouvert(motChoisi, queUn);
            setLettredecouvertes(motChoisi, queUn);

        }
    }

    public static void main(String[] args) {

        String cheminFichier = "./mots.txt";

        List<String> motsListe = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] mots = ligne.split("\n");
                for (String mot : mots) {
                    motsListe.add(mot);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        //System.out.println("Mot choisi : " + motChoisi);

        while(true){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Nouvelle partie ?");
            String nvlet = myObj.nextLine().toUpperCase();
            if(nvlet.equals("OUI")) {
                Random random = new Random();
                int r = random.nextInt(motsListe.size());
                String motChoisi = motsListe.get(r);
                recommence();
                jeu(motChoisi);
            }else{System.out.println("Le jeu s'arrete alors!");break;}
        }

    }
}
