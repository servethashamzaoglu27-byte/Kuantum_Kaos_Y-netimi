const KuantumNesnesi = require("./KuantumNesnesi");

class VeriPaketi extends KuantumNesnesi {
    constructor(ID, stabilite, tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    analizEt() {
        this.setStabilite(this.getStabilite() - 5);
        console.log("Veri içeriği okundu.");
    }
}

module.exports = VeriPaketi;
