# 🌀 Kuantum Kaos Yönetimi – Çok Dilli Programlama Ödevi

Bu proje, “Kuantum Veri Ambarı” senaryosunun dört farklı programlama dilinde uygulanması amacıyla hazırlanmıştır.  
Her dilde aynı oyun mekaniği, OOP prensipleri ve hata yönetimi kuralları takip edilmiştir.

---

## 📌 Proje Amacı
Kullanıcıya bir kontrol paneli sunarak kuantum maddelerini yönetmek, analiz etmek ve stabilite değerlerini takip ederek **kuantum çöküşünü engellemeyi** amaçlayan bir mini simülasyon geliştirmek.

Simülasyon boyunca:
- Yeni nesne üretme
- Nesneleri analiz etme
- Tehlikeli nesneleri soğutma
- Envanteri listeleme  
gibi işlemler yapılabilmektedir.

---

## 🧬 Uygulanan Teknik Gereksinimler

### ✔ **1. OOP Prensipleri**
- **Abstract Class:** `KuantumNesnesi`
- **Encapsulation:** Stabilite değeri (0–100 arası kontrol)
- **Inheritance:** VeriPaketi, KaranlikMadde, AntiMadde
- **Polymorphism:** AnalizEt() metotlarının farklı çalışması
- **Interface (IKritik):** Tehlikeli nesneler için AcilDurumSogutmasi()

### ✔ **2. Özel Hata Yönetimi**
- `KuantumCokusuException`  
Herhangi bir nesnenin stabilitesi ≤ 0 olduğunda fırlatılır.

### ✔ **3. Main Döngüsü**
Kullanıcıya şu menü sunulur:

1. Yeni Nesne Ekle  
2. Envanteri Listele  
3. Nesneyi Analiz Et  
4. Acil Durum Soğutması  
5. Çıkış  

Her işlem try-catch bloklarıyla korunmuştur.

---

## 🖥 Kullanılan Diller ve Klasör Yapısı
Kuantum_Kaos_Yonetimi/
│── KuantumCS/ → C# sürümü
│── KuantumJAVA/ → Java sürümü
│── KuantumJS2/ → JavaScript sürümü
│── KuantumPYTHON/ → Python sürümü

