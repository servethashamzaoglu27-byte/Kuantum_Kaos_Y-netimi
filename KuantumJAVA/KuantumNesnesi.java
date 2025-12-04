public abstract class KuantumNesnesi {

    private String ID;
    private double stabilite;   // 0 - 100 arası
    private int tehlikeSeviyesi;  // 1 - 10 arası

    public KuantumNesnesi(String ID, double stabilite, int tehlikeSeviyesi) {
        this.ID = ID;
        setStabilite(stabilite);  // kapsülleme ile kontrol edilecek
        this.tehlikeSeviyesi = tehlikeSeviyesi;
    }

    public String getID() {
        return ID;
    }

    public double getStabilite() {
        return stabilite;
    }

    // KAPSÜLLEME
    public void setStabilite(double stabilite) {
        if (stabilite > 100) {
            this.stabilite = 100;
        } else if (stabilite < 0) {
            this.stabilite = 0;
        } else {
            this.stabilite = stabilite;
        }
    }

    public int getTehlikeSeviyesi() {
        return tehlikeSeviyesi;
    }

    // Abstract metot — çocuk sınıflar dolduracak
    public abstract void AnalizEt();

    // Tüm nesnelerde ortak
    public String DurumBilgisi() {
        return "ID: " + ID + " | Stabilite: " + stabilite;
    }
}

    

