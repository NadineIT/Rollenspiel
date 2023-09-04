import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
public class Mensch extends Spielfigur {

    public Mensch(String n, boolean sp, boolean nebenwaffe) {

        super(n, "Mensch", sp, nebenwaffe, 50, 25, -25, 6, 2, 6,
                -3, 1, 0, 5,3,0,0);
        waffen = new ArrayList<>();
        ruestung = new ArrayList<>();
        items = new ArrayList<>();
    }
    public Mensch(String n, String klasse, boolean sp, boolean nebenwaffe, int klleben, int klenergie, int klmana, int klstaerke,
                  int klgeschicklichkeit, int klkonstitution, int klintelligenz, int klweisheit, int klcharisma,
                  int klangriff, int klabwehr, int klmgangriff, int klmgabwehr) {

        super(n, "Mensch", klasse, sp, nebenwaffe, 50+klleben, 25+klenergie, -25+klmana,
                6+klstaerke, 2+klgeschicklichkeit, 6+klkonstitution,-3+klintelligenz,
                1+klweisheit, 0+klcharisma, 5+klangriff,3+klabwehr,0+klmgangriff,0+klmgabwehr);
        waffen = new ArrayList<>();
        ruestung = new ArrayList<>();
        items = new ArrayList<>();
    }

    @Override
    public void maleDich() {
        System.out.println("Name:  " + name );
        System.out.println("Rasse: " + rasse + " || Klasse: " + klasse);
        System.out.println("----------------------------------------------");
        System.out.println("HP:   " + leben +"/"+ maxleben + " || AP:   " + energie+"/"+ maxenergie);
        System.out.println("MP:   " + mana+"/"+ maxmana);
        System.out.println("----------------------------------------------");
        System.out.println("Angriff:        " +angriff+ " || Abwehr:        "+abwehr);
        System.out.println("Magieangriff:   " +magieangriff+ " || Magieabwehr:   "+magieabwehr);
        System.out.println("----------------------------------------------");
        System.out.println("Str: " + staerke + " || Ges: "  + geschicklichkeit);
        System.out.println("Kon: " + konstitution + " || Int: " + intelligenz);
        System.out.println("Wei: " + weisheit + " || Cha: " + charisma);
        System.out.println("----------------------------------------------");
        System.out.println("Waffe: "+haupthand + " || Zweit: "+nebenhand);
        System.out.println("Kopf:  " + helm + " || Brust: " + oberkoerper);
        System.out.println("Beine: " + unterkoerper + " || Füße:  " + fuesse);
        System.out.println("----------------------------------------------");
        System.out.println("Inventar");
        System.out.println("Waffen: ");
        System.out.println(waffen);
        System.out.println("Rüstung: ");
        System.out.println(ruestung);
        System.out.println("Items: ");
        System.out.println(items);
        System.out.println("----------------------------------------------");
        System.out.println("Gold: " + geldbeutel);
    }
    @Override
    public void setHaupthand(Waffen waffe) {
        haupthand = waffe;
    }
    public Waffen getHaupthand(){
        return haupthand;
    }
    public void setNebenhand(Waffen waffe) {
        nebenhand = waffe;
    }
    public Waffen getNebenhand(){
        return nebenhand;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void resetItems(){
        items.clear();
    }
    public ArrayList<Waffen> getWaffen() {
        return waffen;
    }
    public void resetWaffen(){
        waffen.clear();
    }
    public ArrayList<Ruestung> getRuestung() {
        return ruestung;
    }
    public void resetRuestung(){
        ruestung.clear();
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevelNPC(int level) {
        int istLevel = getLevel();
        while (istLevel<level){
            istLevel++;
            if (istLevel%5 == 0){
                this.maxleben = this.maxleben + 50;
                this.staerke = this.staerke + 1;
                this.geschicklichkeit = this.geschicklichkeit + 1;
                this.konstitution = this.konstitution + 1;
                this.intelligenz = this.intelligenz + 1;
                this.weisheit = this.weisheit + 1;
                this.charisma = this.charisma + 1;
            } else if (istLevel%4 == 0) {
                this.maxleben = this.maxleben + 10;
                this.staerke = this.staerke + 1;
                this.geschicklichkeit = this.geschicklichkeit + 1;
            } else if (istLevel%3 == 0){
                this.maxleben = this.maxleben + 10;
                this.staerke = this.staerke + 1;
                this.geschicklichkeit = this.geschicklichkeit + 1;
                this.konstitution = this.konstitution + 1;
            } else if (istLevel%2 == 0) {
                this.maxleben = this.maxleben + 10;
                this.staerke = this.staerke + 1;
                this.konstitution = this.konstitution + 1;
            }else{
                this.maxleben = this.maxleben + 10;
                this.staerke = this.staerke + 1;
            }
        }
        this.level = level;
    }

    @Override
    public void setLevelPC(int level) {
        //TODO
    }

    @Override
    public void addCharisma(int charisma) {
        this.charisma=this.charisma+charisma;
    }

    public Waffen waehleWaffeAus() {
        Object[] options = waffen.toArray();
        Object ob = JOptionPane.showInputDialog(null, "Deine Waffen: " + waffen, "Wähle deine Waffe",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        Waffen waffe = (Waffen) ob;
        if (waffe != null){
            waffen.remove(waffe);
        }
        return waffe;
    }
    public void addWaffeStats(Waffen waffe){
        this.staerke = this.staerke + waffe.getStaerke();
        this.geschicklichkeit = this.geschicklichkeit + waffe.getGeschicklichkeit();
        this.konstitution = this.konstitution + waffe.getKonstitution();
        this.intelligenz = this.intelligenz + waffe.getIntelligenz();
        this.weisheit = this.weisheit + waffe.getWeisheit();
        this.charisma = this.charisma + waffe.getCharisma();
    }
    public void removeWaffeStats(Waffen waffe){
        this.staerke = this.staerke - waffe.getStaerke();
        this.geschicklichkeit = this.geschicklichkeit - waffe.getGeschicklichkeit();
        this.konstitution = this.konstitution - waffe.getKonstitution();
        this.intelligenz = this.intelligenz - waffe.getIntelligenz();
        this.weisheit = this.weisheit - waffe.getWeisheit();
        this.charisma = this.charisma - waffe.getCharisma();
    }
    public void ruesteWaffeAus(Waffen waffe, String slot){
        if (slot == "Haupthand"){
            haupthand = waffe;
            addWaffeStats(waffe);
        } else if (slot == "Nebenhand") {
            nebenhand = waffe;
            addWaffeStats(waffe);
        }else {
            haupthand = waffe;
            nebenhand = waffe;
            addWaffeStats(waffe);
        }
    }
    public void legeAb(String slot) {
        if ((slot == "Nebenhand")){
            if (haupthand == nebenhand){
                haupthand = null;
            }
            Waffen waffe = nebenhand;
            nebenhand = null;
            if (waffe != null){
                waffen.add(waffe);
                removeWaffeStats(waffe);
            }
        } else if ((slot == "Haupthand")) {
            if (haupthand == nebenhand) {
                nebenhand = null;
            }
            Waffen waffe = haupthand;
            haupthand = null;
            if (waffe != null){
                waffen.add(waffe);
                removeWaffeStats(waffe);
            }
        } else {
            if ((haupthand != nebenhand) && (nebenhand != null)){
                Waffen waffe = nebenhand;
                nebenhand = null;
                waffen.add(waffe);
                removeWaffeStats(waffe);
            }
            nebenhand = null;
            Waffen waffe2 = haupthand;
            haupthand = null;
            if (waffe2 == null){
                waffen.add(waffe2);
                removeWaffeStats(waffe2);
            }
        }
    }
}
class Krieger extends Mensch{
    public Krieger(String n, boolean sp, boolean nebenwaffe) {
        super(n, sp, nebenwaffe);
    }
}

class Assassin extends Mensch{
    public Assassin(String n, boolean sp, boolean nebenwaffe) {
        super(n, sp, true);
    }
}

class Zauberer extends Mensch{
    public Zauberer(String n, boolean sp, boolean nebenwaffe) {
        super(n, sp, false);
    }
}

class Haendler extends Mensch{
    private String special;
    private ArrayList<Waffen> haendlerWaffen;
    private ArrayList<Ruestung> haendlerRuestung;
    private ArrayList<Item> haendlerItems;


    public Haendler(String n, String special) {
        super(n, "Haendler", false, true, 4850, 2375, 925, 24, 10, 24,
                3, 4, 10, 25, 50, 5, 50);
        this.special = special;
    }

        public Waffen zeigWaffen(){
        Object[] options = waffen.toArray();
        Object ob = JOptionPane.showInputDialog(null, "Verfügbar: " + waffen, "Wähle eine Waffe",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        Waffen waffe = (Waffen) ob;
        if (waffe != null){
            waffen.remove(waffe);
        }
        return waffe;
    }

    public Ruestung zeigRuestung(){
        Object[] options = ruestung.toArray();
        Object ob = JOptionPane.showInputDialog(null, "Verfügbar: " + ruestung, "Wähle ein Rüstungsteil",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        Ruestung ausruestung = (Ruestung) ob;
        if (ausruestung != null){
            ruestung.remove(ausruestung);
        }
        return ausruestung;
    }

    public Item zeigItems(){
        Object[] options = items.toArray();
        Object ob = JOptionPane.showInputDialog(null, "Verfügbar: " + items, "Wähle ein Item",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        Item item = (Item) ob;
        if (item != null){
            items.remove(item);
        }
        return item;
    }



}
