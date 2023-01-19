import java.util.Comparator;
import java.util.Objects;

public class Mitarbeiter implements Comparable<Mitarbeiter> {
    private int mnr;
    private String name;
    private String abteilung;

    public static class AbteilungsComparator implements Comparator<Mitarbeiter> {

        // Wie funktioniert compare(a,b) ?
        // Rückgabe > 0 wenn  a > b
        //          = 0 wenn  a = b
        //          < 0 wenn  a < b
        @Override
        public int compare(Mitarbeiter a, Mitarbeiter b) {
            if (a.abteilung.equals(b.abteilung)) {
                // 2. Ordnung
                if (a.name.equals(b.name)) {
                    // 3. Ordnung = natürliche Ordnnug
                    return a.compareTo(b);
                }
                return a.name.compareTo(b.name);
            }
            return a.abteilung.compareTo(b.abteilung);
        }
    }


    public Mitarbeiter(int mnr, String name, String abteilung) {
        this.mnr = mnr;
        this.name = name;
        this.abteilung = abteilung;
    }

    public int getMnr() {
        return mnr;
    }

    public void setMnr(int mnr) {
        this.mnr = mnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    // Wie funktioniert compareTo ?
    // Rückgabe > 0 wenn this > that
    //          = 0 wenn this = that
    //          < 0 wenn this < that
    @Override
    public int compareTo(Mitarbeiter that) {
        // wenn "natürliche Ordnung" über Mitarbeiternummer definiert wird
        return this.mnr - that.mnr;
//        if (this.mnr > that.mnr)  return 1;
//        if (this.mnr == that.mnr) return 0;
//        if (this.mnr < that.mnr)  return -1;
        // wenn "nO" über Mitarbeitername definiert wird
        //return this.name.compareTo(that.name);
        // wenn "nO" über Mitarbeitername eine totale Ordnung sein soll
//        if (this.name.equals(that.name)) {
//            // Sortierung nach 2. Ordnung
//            return this.mnr - that.mnr;
//        }
//        else
//            // Sortierung nach 1. Ordnung
//            return this.name.compareTo(that.name);
    }

    @Override
    public String toString() {
        return mnr + ":" + name + "(" + abteilung + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mitarbeiter that = (Mitarbeiter) o;
        return mnr == that.mnr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnr, name, abteilung);
    }
}
