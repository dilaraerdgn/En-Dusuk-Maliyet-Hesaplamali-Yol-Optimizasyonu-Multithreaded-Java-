# En-Dusuk-Maliyet-Hesaplamali-Yol-Optimizasyonu-Multithreaded-Java-
Belirli coğrafi kısıtlar altında (nehir genişliği, yol mesafesi vb.) en düşük maliyetli rotayı hesaplayan bir optimizasyon aracıdır. Proje, hesaplama hızını artırmak amacıyla Java Multithreading teknolojisini kullanmakta ve sonuçları JFreeChart kütüphanesi ile görselleştirerek optimum noktayı analiz etmektedir.

# EcoBridge

Bu proje, Java programlama dili kullanılarak geliştirilmiş, belirli coğrafi ve maliyet kısıtları altında **en düşük maliyetli** köprü ve yol rotasını hesaplayan bir **mühendislik optimizasyon aracıdır**.

Uygulama, karmaşık matematiksel hesaplamaların performansını artırmak amacıyla **Java Multithreading** teknolojisini kullanmakta ve elde edilen sonuçları **JFreeChart** kütüphanesi ile görselleştirmektedir.

---

## Temel Özellikler

- **Maliyet Optimizasyonu:** Nehir genişliği, yatay mesafe ve birim maliyetler (yol/köprü) dikkate alınarak toplam maliyeti minimize eden optimum x (yatay uzaklık) noktasını hesaplar.
- **Yüksek Performans (Multithreading):** Arama uzayı (0'dan yatay mesafeye kadar) 4 farklı iş parçacığına (thread) bölünerek hesaplama süresi optimize edilmiştir.
- **Veri Görselleştirme:** Hesaplanan tüm maliyet eğrisini ve tespit edilen optimum noktayı interaktif bir grafik üzerinde sunar.

---

## Teknik Detaylar

### Kullanılan Teknolojiler & Kütüphaneler

* **Dil:** Java
* **Paralel Programlama:** `java.lang.Thread` (Join-Fork Modeli)
* **Grafik Kütüphanesi:** JFreeChart

### Problem Tanımı

Proje, aşağıdaki sabit değişkenlere göre çalışmaktadır:
- **Nehir Genişliği:** 600m
- **Yatay Mesafe:** 800m
- **Yol Maliyeti:** 20,000 $ / 100m
- **Köprü Maliyeti:** 40,000 $ / 100m

Program, $Cost(x) = f(\sqrt{w^2 + x^2}, d-x)$ fonksiyonunu minimize etmeyi hedefler.

---

## Analiz ve Sonuçlar

### Optimizasyon Grafiği

Aşağıdaki grafik, köprü konumuna (x) bağlı olarak toplam maliyetin değişimini göstermektedir. **Kırmızı nokta**, multithreading ile tespit edilen en düşük maliyetli (optimum) konumu temsil eder.

Maliyet Grafiği **En Dusuk Maliyet Hesaplamali Yol Optimizasyonu Proje Raporu.pdf** içerisinde yer verilmiştir.

### Proje Raporu ve Detaylı Yorumlama

Bu projenin matematiksel arka planı, Single-Thread vs Multi-Thread performans karşılaştırması ve yukarıdaki grafiğin detaylı analizi için hazırladığım proje raporunu inceleyebilirsiniz.

📄 **[Proje Detaylı Analiz Raporu.pdf](En Dusuk Maliyet Hesaplamali Yol Optimizasyonu Proje Raporu.pdf)**

---

## Nasıl Çalıştırılır?

1.  Bu depoyu klonlayın.
2.  Projenize `JFreeChart` kütüphanesini (`jfreechart.jar` ve `jcommon.jar`) ekleyin.
3.  `MultiThread.java` dosyasını IDE'nizde çalıştırın.

