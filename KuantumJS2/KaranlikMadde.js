const KuantumNesnesi = require("./KuantumNesnesi");
const IKritik = require("./IKritik");

class KaranlikMadde extends KuantumNesnesi {
    constructor(ID, stabilite, tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    analizEt() {
        this.setStabilite(this.getStabilite() - 15);
        console.log("Karanlık madde analiz edildi.");
    }

    acilDurumSogutmasi() {
        this.setStabilite(this.getStabilite() + 50);
        console.log("Karanlık madde soğutuldu!");
    }
}

module.exports = KaranlikMadde;
