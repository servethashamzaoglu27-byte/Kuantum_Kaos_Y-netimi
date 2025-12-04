const readline = require("readline");

const VeriPaketi = require("./VeriPaketi");
const KaranlikMadde = require("./KaranlikMadde");
const AntiMadde = require("./AntiMadde");
const KuantumCokusuException = require("./KuantumCokusuException");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

function soru(s) {
    return new Promise((resolve) => rl.question(s, resolve));
}

function rastgeleNesneUret() {
    const tip = Math.floor(Math.random() * 3);
    const ID = "N" + Math.floor(Math.random() * 9000 + 1000);
    const stabilite = Math.floor(Math.random() * 61) + 40;
    const tehlike = Math.floor(Math.random() * 10) + 1;

    if (tip === 0) {
        console.log(`Yeni VeriPaketi oluşturuldu: ${ID}`);
        return new VeriPaketi(ID, stabilite, tehlike);
    } else if (tip === 1) {
        console.log(`Yeni KaranlikMadde oluşturuldu: ${ID}`);
        return new KaranlikMadde(ID, stabilite, tehlike);
    } else {
        console.log(`Yeni AntiMadde oluşturuldu: ${ID}`);
        return new AntiMadde(ID, stabilite, tehlike);
    }
}

async function main() {
    let envanter = [];

    while (true) {
        try {
            console.log("\n===== KUANTUM AMBARI KONTROL PANELİ =====");
            console.log("1. Yeni Nesne Ekle");
            console.log("2. Tüm Envanteri Listele");
            console.log("3. Nesneyi Analiz Et");
            console.log("4. Acil Durum Soğutması Yap");
            console.log("5. Çıkış");

            const secim = await soru("Seçiminiz: ");

            if (secim === "1") {
                const nesne = rastgeleNesneUret();
                envanter.push(nesne);
            } else if (secim === "2") {
                console.log("\n--- ENVANTER ---");
                envanter.forEach((n) => console.log(n.durumBilgisi()));
            } else if (secim === "3") {
                const id = await soru("Analiz edilecek nesnenin ID'si: ");
                const hedef = envanter.find((n) => n.ID === id);

                if (!hedef) console.log("Nesne bulunamadı!");
                else {
                    hedef.analizEt();
                    if (hedef.getStabilite() <= 0)
                        throw new KuantumCokusuException(hedef.ID);
                }
            } else if (secim === "4") {
                const id = await soru("Soğutulacak nesnenin ID'si: ");
                const hedef = envanter.find((n) => n.ID === id);

                if (!hedef) console.log("Nesne bulunamadı!");
                else if (typeof hedef.acilDurumSogutmasi === "function")
                    hedef.acilDurumSogutmasi();
                else console.log("Bu nesne soğutulamaz!");
            } else if (secim === "5") {
                console.log("Programdan çıkılıyor...");
                rl.close();
                break;
            } else {
                console.log("Geçersiz seçim!");
            }
        } catch (err) {
            if (err instanceof KuantumCokusuException) {
                console.log("\n!!! SİSTEM ÇÖKTÜ! TAHLİYE BAŞLATILIYOR...");
                console.log(err.message);
                rl.close();
                break;
            } else {
                console.log("Beklenmeyen hata: ", err);
            }
        }
    }
}

main();
