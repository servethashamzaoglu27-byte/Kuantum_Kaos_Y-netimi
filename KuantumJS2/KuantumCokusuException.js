class KuantumCokusuException extends Error {
    constructor(nesneID) {
        super(`Kuantum Çöküşü! Patlayan nesne ID: ${nesneID}`);
        this.name = "KuantumCokusuException";
        this.nesneID = nesneID;
    }
}

module.exports = KuantumCokusuException;
