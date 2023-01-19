import java.util.*;

public class Main {

    public static <T extends Comparable<T>> T min(T a, T b) {
        if ( a.compareTo(b) > 0 ) return b;
        return a;
    }

    public static void main(String[] args) {
        Mitarbeiter m1 = new Mitarbeiter(1, "Müller", "Einkauf");
        Mitarbeiter m2 = new Mitarbeiter(2, "Schmitt", "Verkauf");
        Mitarbeiter m3 = new Mitarbeiter(3, "Fritz", "Einkauf");
        //Mitarbeiter m4 = new Mitarbeiter(4, "Fritz", "Einkauf");

        //System.out.println( min(m1, m2) );

        // ab jetzt nur noch das Interface (List) benutzen!
        List<Mitarbeiter> mitarbeiterList = new LinkedList<>();

        mitarbeiterList.add(m1);
        mitarbeiterList.add(m2);
        mitarbeiterList.add(m3);
        System.out.println(mitarbeiterList);
        System.out.println("Schmitt vorhanden? " +
                mitarbeiterList.contains( new Mitarbeiter(2, "Schmidt", "Einkauf") ));

        mitarbeiterList.sort( new Mitarbeiter.AbteilungsComparator() );
        System.out.println(mitarbeiterList);

        mitarbeiterList.sort(new Comparator<Mitarbeiter>() {
            @Override
            public int compare(Mitarbeiter a, Mitarbeiter b) {
                return b.getMnr() - a.getMnr();
            }
        });
        System.out.println(mitarbeiterList);

        mitarbeiterList.sort( (a, b) -> b.getName().compareTo(a.getName()) );
        System.out.println(mitarbeiterList);

        mitarbeiterList.sort(Comparator.comparingInt(Mitarbeiter::getMnr));
        System.out.println(mitarbeiterList);

        mitarbeiterList.sort( Comparator.reverseOrder() );
        System.out.println(mitarbeiterList);


//        // Dynamisches Array mit Strings
//        ArrayList<String> stringList = new ArrayList<>();
//
//        stringList.add( "Hallo" );
//        stringList.add( "Wie" );
//        stringList.add( "gehts" );
//        stringList.add( "denn?" );
//
//        System.out.println(stringList);
    }

}
