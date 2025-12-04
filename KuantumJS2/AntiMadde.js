const KuantumNesnesi = require("./KuantumNesnesi");
const IKritik = require("./IKritik");

class AntiMadde extends KuantumNesnesi {
    constructor(ID, stabilite, tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    analizEt() {
        this.setStabilite(this.getStabilite() - 25);
        console.log("Evrenin dokusu titriyor...");
    }

    acilDurumSogutmasi() {
        this.setStabilite(this.getStabilite() + 50);
        console.log("Antimadde soğutuldu!");
    }
}

module.exports = AntiMadde;
