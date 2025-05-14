#  TicketApp - Destek Talep ve Takip Sistemi

Bu proje, kullanıcıların destek taleplerini oluşturabildiği ve adminlerin bu talepleri yanıtlayıp yönetebildiği, JWT tabanlı kimlik doğrulama ile güvence altına alınmış tam özellikli bir destek talep ve takip sistemidir.
 
## 🧱 Proje Yapısı

### 🔧 Backend - Spring Boot

* **Spring Boot 3.2.5**
* **JWT Authentication & Authorization**
* **Spring Security**
* **Spring Data JPA**
* **H2 (dev ortamı için) veya MySQL (prod için)**
* **MapStruct ile DTO Mapping**
* **Swagger/OpenAPI ile API dokümantasyonu**

### 🖥️ Frontend - React

* **React 18**
* **Redux Toolkit & RTK Query**
* **React Router v6**
* **Material UI (MUI) ile kullanıcı dostu tasarım**
* **Vite ile hızlı geliştirme ve build süreci**

---

## 🚀 Kurulum

### Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

Veya IDE üzerinden `SupportAppApplication` sınıfını çalıştırarak başlatabilirsiniz.

### Frontend (React)

```bash
cd supportapp-front
npm install
npm run dev
```

---

## 🔐 Kimlik Doğrulama

Uygulama JWT token tabanlı kimlik doğrulama kullanır. Kullanıcı giriş yaptıktan sonra alınan `id_token` local storage'a kaydedilir ve tüm talepler için Authorization header'ına eklenir.

Yetkiler:

* `ROLE_USER`: Destek talebi oluşturabilir, kendi taleplerini görüntüleyebilir ve kapatabilir.
* `ROLE_ADMIN`: Tüm talepleri görebilir, yanıtlayabilir ve kapatabilir.

---

## 🌐 API Uç Noktaları (Örnekler)

### Genel

* `POST /api/authenticate` → Giriş
* `GET /api/account` → Oturum kontrolü ve kullanıcı bilgisi

### Kullanıcı

* `POST /api/user/tickets` → Talep oluşturma
* `GET /api/user/tickets` → Kendi taleplerini listeleme
* `PATCH /api/user/tickets/{id}/close` → Talep kapatma

### Admin

* `GET /api/admin/tickets` → Tüm talepleri listeleme (sayfalama, filtreleme)
* `PATCH /api/admin/tickets/{id}/reply` → Talebe yanıt verme
* `PATCH /api/admin/tickets/{id}/close` → Talep kapatma

---

## 📸 Ekran Görüntüleri

* Login Sayfası
* Kullanıcı Dashboard
* Yeni Talep Oluşturma
* Admin Paneli - Talep Listesi ve Detay

---

## ⚙️ Ortam Değişkenleri

Frontend `.env`:

```
VITE_API_BASE_URL=http://localhost:8080/api
```

Backend `application.yml` (örnek):

```yaml
security:
  authentication:
    jwt:
      base64-secret: <64-bit base64 key>
      token-validity-in-seconds: 86400
      token-validity-in-seconds-for-remember-me: 604800
```

---

## 📚 Teknolojiler

* **Backend:** Java 17, Spring Boot, Spring Security, JWT, JPA, H2/MySQL, MapStruct
* **Frontend:** React, Redux Toolkit, RTK Query, MUI, Vite

---

## 📄 Lisans

Bu proje MIT lisansı ile lisanslanmıştır.
