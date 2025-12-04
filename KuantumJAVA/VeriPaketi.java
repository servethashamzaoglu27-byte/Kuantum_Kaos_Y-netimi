public class VeriPaketi extends KuantumNesnesi {

    public VeriPaketi(String ID, double stabilite, int tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    @Override
    public void AnalizEt() {
        // Stabilite 5 düşecek
        setStabilite(getStabilite() - 5);
        System.out.println("Veri içeriği okundu.");
    }
}

    

