public class Dessin {

    static int compteur=0;

    public static void incremente(){
        if(compteur<7){
            compteur++;
        }
    }

    public static void erreurs(){
        String[] s = new String[0];
        incremente();
        switch (compteur){
            case 1:s= new String[]{"   O"};break;
            case 2:s= new String[]{"   O"," /"};break;
            case 3:s= new String[]{"   O"," /   \""};break;
            case 4:s= new String[]{"   O"," / | \""};break;
            case 5:s= new String[]{"   O"," / | \"","   |"};break;
            case 6:s= new String[]{"   O"," / | \"","   |"," /    " };break;
            case 7:s= new String[]{"   O"," / | \"","   |"," /   \"" };break;
        }
        for (String lettre : s){
            System.out.println(lettre);
        }
    }

}