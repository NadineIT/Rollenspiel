import javax.swing.*;

public class Main{
    public static String slotwahl(Waffen waffe, Figuren figure) {
        if ((waffe.getEinhaendig()) && (figure.getNebenwaffe()) && (waffe.getHaupt())) {
            String[] options = {"Haupthand", "Nebenhand"};
            Object ob = JOptionPane.showInputDialog(null, "Wo möchtest du die Waffe ausrüsten?: ",
                    "Slotwahl", JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (ob == null) {
                ob = "Haupthand";
            }
            return (String) ob;
        } else if (waffe.getEinhaendig() && waffe.getHaupt()) {
            return "Haupthand";
        } else if (!waffe.getEinhaendig()) {
            return "Beide";
        } else {
            return "Nebenhand";
        }
    }
    public static void ausruestenWaffe(Spielfigur figure){
            Waffen waffe = figure.waehleWaffeAus();
            if (waffe == null){
                return;
            }
            String slot = slotwahl(waffe, figure);
            figure.legeAb(slot);
            figure.ruesteWaffeAus(waffe, slot);
    }
    public static void ablegenWaffe(Spielfigur figure){
        if ((figure.getHaupthand() != null) && (figure.getNebenhand() != null) && ((figure.getHaupthand()!=figure.getNebenhand()))){
            String[] options = {"Haupthand", "Nebenhand"};
            Object ob = JOptionPane.showInputDialog(null, "Von welchem Slot möchtest du die Waffe ablegen?: ",
                    "Slotwahl", JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (ob == null) {
                return;
            }
            String slot = (String) ob;
            figure.legeAb(slot);
        } else if ((figure.getHaupthand() == figure.getNebenhand()) || (figure.getHaupthand() != null)){
            figure.legeAb("Haupthand");
        }else {
            figure.legeAb("Nebenhand");
        }
    }
    public static Waffen[] convertToWaffenList (Waffen ... waffe){
        Waffen[] waffen = new Waffen[waffe.length];
        System.arraycopy(waffe, 0, waffen, 0, waffe.length);
        return waffen;
    }
    public static Ruestung[] convertToRuestungList (Ruestung ... ruestung){
        Ruestung[] ausruestung = new Ruestung[ruestung.length];
        System.arraycopy(ruestung, 0, ausruestung, 0, ruestung.length);
        return ausruestung;
    }
    public static Item[] convertToItemList (Item ... item){
        Item[] items = new Item[item.length];
        System.arraycopy(item, 0, items, 0, item.length);
        return items;
    }
    public static void resetInventar(Haendler haendler, Waffen[] waffen, Ruestung[] ruestung, Item[] items){
        haendler.resetWaffen();
        haendler.resetRuestung();
        haendler.resetItems();
        haendler.setGeldbeutel(500);
        for (Waffen value : waffen) {
            haendler.addWaffe(value);
        }
        for (Ruestung value : ruestung) {
            haendler.addRuestung(value);
        }
        for (Item item : items) {
            haendler.addItem(item);
        }
    }
    public static String kaufBestaetigung(Gegenstand gegenstand, int geld){
        String[] options = {"Kaufen", "Ich hab's mir anders überlegt"};
        Object ob = JOptionPane.showInputDialog(null, gegenstand+" kostet: "+gegenstand.getWert()*2+"Gold. || Du besitzt "+geld+" Gold",
                "Kaufbestätigung", JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (ob == "Kaufen") {
            return "Ja";
        }else {
            return "Nein";
        }
    }
    public static void bezahlen(Haendler haendler, Gegenstand gegenstand, Spielfigur kaeufer){
        int money = gegenstand.getWert()*2;
        kaeufer.addGeldbeutel(-money);
        haendler.addGeldbeutel(money);
    }
    public static void browseWares(Haendler haendler, Spielfigur figure){
        String[] options = {"Waffen", "Rüstung", "Items"};
        Object ob = JOptionPane.showInputDialog(null, "Welche Waren möchtest du ansehen?: ",
                "Slotwahl", JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (ob == null) {
            return;
        }
        if (ob == "Waffen"){
            Waffen waffe = haendler.zeigWaffen();
            if(waffe.getWert()*2 > figure.getGeldbeutel()){
                System.out.println("Du hast nicht genug Geld");
                haendler.addWaffe(waffe);
            }else {
                String wahl = kaufBestaetigung(waffe, figure.getGeldbeutel());
                if (wahl.equals("Ja")){
                    bezahlen(haendler, waffe, figure);
                    figure.addWaffe(waffe);
                }else {
                    haendler.addWaffe(waffe);
                }
            }
        } else if (ob == "Rüstung") {
            Ruestung ruestung = haendler.zeigRuestung();
            if(ruestung.getWert()*2 > figure.getGeldbeutel()){
                System.out.println("Du hast nicht genug Geld");
                haendler.addRuestung(ruestung);
            }else {
            String wahl = kaufBestaetigung(ruestung, figure.getGeldbeutel());
                if (wahl.equals("Ja")){
                    bezahlen(haendler, ruestung, figure);
                    figure.addRuestung(ruestung);
                }else {
                    haendler.addRuestung(ruestung);
                }
            }
        }else {
            Item item = haendler.zeigItems();
            if(item.getWert()*2 > figure.getGeldbeutel()){
                System.out.println("Du hast nicht genug Geld");
                haendler.addItem(item);
            }else {
                String wahl = kaufBestaetigung(item, figure.getGeldbeutel());
                if (wahl.equals("Ja")){
                    bezahlen(haendler, item, figure);
                    figure.addItem(item);
                }else {
                    haendler.addItem(item);
                }
            }
        }
    }
    public static void trenner() {
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }
    public static void main(String[] args) {

        System.out.println("Rollenspiel");

        // Objekt Material MUSS vor den Objekt Waffe erstellt werden

        Material holz = new Material("Holz", "Einfaches Holz", 1, 1,1);
        Material eisen = new Material("Eisen", 2, 2, 1);
        Mensch mensch1 = new Mensch("Harry", false, true);
        Drache drache1 = new Drache("Onyxia", false, "Feuer");
        Zwerg zwerg1 = new Zwerg("Fili", true);
        Ork ork1 = new Ork("Baldur", false);
        Mensch mensch2 = new Mensch("Peter", true, true);
        Waffen holzschwert = new Schwert("Trainingsschwert", holz);
        Schwert eisenschwert = new Schwert("Eisenschwert", eisen);
        Dolch holzdolch = new Dolch("Trainingsdolch", holz);
        Axt holzaxt = new Axt("Trainingsaxt", holz);
        Stab holzstab = new Stab("Novizenstab", holz);
        Haendler haendler1 = new Haendler("Mercury", "Waffen");
        Helme eisenhelm = new Helme("Eisenhelm", eisen);
        Item item = new Item("Heiltrank", 10, 10, "Leben");

        resetInventar(haendler1,
                convertToWaffenList(holzschwert, holzdolch, holzaxt, holzstab),
                convertToRuestungList(eisenhelm),
                convertToItemList(item));
        trenner();
        haendler1.maleDich();
        trenner();
        mensch1.maleDich();
        mensch1.setGeldbeutel(100);
        trenner();
        browseWares(haendler1, mensch1);
        trenner();
        haendler1.maleDich();
        trenner();
        mensch1.maleDich();
        /*
        mensch1.maleDich();
        trenner();
        mensch1.addWaffe(holzschwert);
        mensch1.addWaffe(eisenschwert);
        mensch1.maleDich();
        trenner();
        mensch1.setLevelNPC(15);
        mensch1.maleDich();
        trenner();
        ausruestenWaffe(mensch1);
        mensch1.maleDich();
        trenner();
        // mensch1.maleDich();
        // trenner();
        // ausruestenWaffe(mensch1);
        // mensch1.maleDich();
        // trenner();
        ablegenWaffe(mensch1);
        mensch1.maleDich();
        trenner();
        holzschwert.beschreibeDich();
        trenner();
        holzdolch.beschreibeDich();
        trenner();
        holzaxt.beschreibeDich();
        trenner();
        holzstab.beschreibeDich();
        */
    }
}