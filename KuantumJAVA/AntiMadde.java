public class AntiMadde extends KuantumNesnesi implements IKritik {

    public AntiMadde(String ID, double stabilite, int tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    @Override
    public void AnalizEt() {
        setStabilite(getStabilite() - 25);
        System.out.println("Evrenin dokusu titriyor...");
    }

    @Override
    public void AcilDurumSogutmasi() {
        setStabilite(getStabilite() + 50);
        System.out.println("Antimadde soğutuldu!");
    }
}

    

