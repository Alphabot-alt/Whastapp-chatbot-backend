# 📲 WhatsApp Chatbot Backend

This is a Spring Boot backend service designed to interact with the [Meta WhatsApp Business API](https://developers.facebook.com/docs/whatsapp/) and Firebase for webhook verification, message processing, and automated replies.

---

## 🚀 Features

- ✅ Webhook verification for Meta API
- ✅ Handle incoming WhatsApp messages
- ✅ Send replies programmatically using WhatsApp API
- ✅ Firebase Admin SDK integration
- ✅ Spring Boot RESTful backend
- ✅ Deployable to Render or other cloud platforms

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.x
- Firebase Admin SDK
- WhatsApp Cloud API (v16.0)
- Maven

---

## 📂 Project Structure
src/
├── main/
│ ├── java/com/example/chatbot/
│ │ ├── ChatbotApplication.java
│ │ ├── controller/WhatsAppController.java
│ │ ├── service/WhatsAppService.java
│ │ ├── model/WebhookRequest.java
│ │ └── config/
│ │ ├── FirebaseConfig.java
│ │ └── RestTemplateConfig.java
│ └── resources/
│ ├── application.properties
│ └── serviceAccountKey.json (NOT INCLUDED)


---

## 🔐 Firebase Credentials

> ⚠️ **Note:**  
> The file `serviceAccountKey.json` is **not uploaded** for security reasons. It contains private credentials for Firebase Admin SDK access.

**To run locally:**
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create/open a project → `Project Settings > Service Accounts`
3. Generate a private key → Download the JSON
4. Rename it to `serviceAccountKey.json`
5. Place it in: `src/main/resources/`

---
| Method | Endpoint   | Description                 |
| ------ | ---------- | --------------------------- |
| GET    | `/webhook` | Webhook verification (Meta) |
| POST   | `/webhook` | Handles incoming messages   |

☁️ Deployment (Render)
Build Command: mvn package

Start Command: java -jar target/chatbot-0.0.1-SNAPSHOT.jar

Environment: Java 17

Required: Add a serviceAccountKey.json at runtime (Render Secret Storage or mount manually)

👨‍💻 Author
Made with ❤️ by Yash Pande



## ⚙️ Configuration

### 🧾 `application.properties`


# Server port
server.port=8080

# WhatsApp Cloud API
whatsapp.api.base-url=https://graph.facebook.com/v16.0/
whatsapp.api.phone-number-id=YOUR_PHONE_NUMBER_ID
whatsapp.api.token=YOUR_WHATSAPP_ACCESS_TOKEN

# Firebase Admin SDK
firebase.service-account-key-path=classpath:serviceAccountKey.json



-🛡️ License
This project is open-source and free to use under the MIT License.


---

Let me know if you also want:
- A badge section (build status, license, etc.)
- `.env` alternative setup
- Render deployment screenshot or instructions with image  
- Sample Postman collection JSON

I'm happy to help!


