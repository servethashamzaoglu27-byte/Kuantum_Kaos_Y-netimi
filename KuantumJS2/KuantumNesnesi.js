class KuantumNesnesi {
    constructor(ID, stabilite, tehlikeSeviyesi) {
        this.ID = ID;
        this._stabilite = 0;
        this.setStabilite(stabilite);
        this.tehlikeSeviyesi = tehlikeSeviyesi;
    }

    getStabilite() {
        return this._stabilite;
    }

    setStabilite(value) {
        if (value > 100) this._stabilite = 100;
        else if (value < 0) this._stabilite = 0;
        else this._stabilite = value;
    }

    analizEt() {
        throw new Error("analizEt() alt sınıf tarafından uygulanmalıdır!");
    }

    durumBilgisi() {
        return `ID: ${this.ID} | Stabilite: ${this._stabilite}`;
    }
}

module.exports = KuantumNesnesi;
