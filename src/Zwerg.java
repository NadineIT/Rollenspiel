import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Zwerg extends Spielfigur{

    protected ArrayList<Waffen> waffen;
    protected ArrayList<Ruestung> ruestung;
    protected ArrayList<Item> items;
    protected Waffen haupthand;
    protected Waffen nebenhand;
    protected Ruestung helm;
    protected Ruestung oberkoerper;
    protected Ruestung unterkoerper;
    protected Ruestung fuesse;


    @Override
    public void addCharisma(int charisma) {

    }

    @Override
    public void maleDich() {
        System.out.println("Name:  " + name );
        System.out.println("Rasse: " + rasse);
        System.out.println("----------------------------------------------");
        System.out.println("HP:   " + leben +"/"+ maxleben);
        System.out.println("AP:   " + energie+"/"+ maxenergie);
        System.out.println("MP:   " + mana+"/"+ maxmana);
        System.out.println();
        System.out.println("Str: " + staerke + " || Ges: "  + geschicklichkeit);
        System.out.println("Kon: " + konstitution + " || Int: " + intelligenz);
        System.out.println("Wei: " + weisheit + " || Cha: " + charisma);
        System.out.println("----------------------------------------------");
        System.out.println("Waffe: "+haupthand+" || Zweit: "+nebenhand);
        System.out.println("Kopf: " + helm + " || Brust: " + oberkoerper);
        System.out.println("Beine: " + unterkoerper + "|| Füße: " + fuesse);
        System.out.println("----------------------------------------------");
        System.out.println("Inventar");
        System.out.println("Waffen: ");
        System.out.println(waffen);
        System.out.println("Rüstung: ");
        System.out.println(ruestung);
        System.out.println("Items: ");
        System.out.println(items);
    }
    public Zwerg(String name, boolean sp) {

        super(name, "Zwerg", sp, false, 50, 50, -50, 5, 2, 4,
                3, 2, 1, 0, 0, 0, 0);
        waffen = new ArrayList<>();
        ruestung = new ArrayList<>();
        items = new ArrayList<>();
    }

    @Override
    public void setHaupthand(Waffen waffe) {
        haupthand = waffe;
    }
    public Waffen getHaupthand(){
        return haupthand;
    }
    @Override
    public void setNebenhand(Waffen waffe) {
        nebenhand = waffe;
    }
    public Gegenstand getNebenhand(){
        return nebenhand;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevelNPC(int level) {

    }

    @Override
    public void setLevelPC(int level) {

    }

    public void addWaffe(Waffen waffe) {
        waffen.add(waffe);
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
                if (waffe != null){
                    waffen.add(waffe);
                    removeWaffeStats(waffe);
                }
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

