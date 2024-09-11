********************
Java15 Forum
********************
1-Register Ol
2-Giriş Yap
3-Çıkış

1. Database adı: Java15ForumDB
2. Tablo adı: User
3. entity package içinde User(id,ad,soyad,username(Unique),password) adında bir class açalım.
2. register işlemi sırasında username'in daha önce alınıp alınmadığı kontrol edilmeli.
3. Adınızı giriniz: 
4. Soyadınızı giriniz: 
5. Username giriniz: 
6. Password giriniz:
7. UserRepository hazırlamalısınız. Temel crud işlemleri olmalı. 
8. Extra olarak;
     - ExistsByUserName(String username)
     - Optional<User> doLogin(String username, String password)
Giriş Yap:
     - username giriniz:
     - password giriniz:
     - Eğer giriş bilgileri doğru ise o zaman başka bir ekrana geçiş yapılır.

MainController

***************
Hoşgeldin, Ad Soyad
***************

-------Post Menüsü------
1- Postları Görüntüle
2- Post Paylaş
3- Kendi postlarını görüntüle
4- Kullanıcıları Listele(user-findAll)
5- Çıkış Yap

Yapılacaklar:
Entity kısmında Post(id, userId, baslik, icerik, paylasimTarihi)++
PostRepository(Crud İşlemleri- findAll, save- post paylaşma)++