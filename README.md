# 📬 Notifications Library (Java)

Una **librería de notificaciones en Java**, agnóstica a frameworks, diseñada para unificar el envío de notificaciones a través de múltiples canales (Email, SMS, Push Notification) y proveedores, siguiendo **principios SOLID**, **arquitectura extensible** y **estándares de calidad enterprise**.

> ⚠️ Esta es una **librería**, no una aplicación.  
> No depende de Spring, Quarkus u otros frameworks.  
> Toda la configuración se realiza **exclusivamente mediante código Java**.

---

## 🎯 Objetivo

Proveer una abstracción clara y extensible que permita:

- Enviar notificaciones sin acoplarse al canal o proveedor
- Cambiar proveedores (SendGrid, Twilio, Firebase, etc.) sin modificar el código cliente
- Extender fácilmente nuevos canales o proveedores
- Mantener un diseño limpio, testeable y orientado a dominio

---

## 🧱 Arquitectura General

La arquitectura se basa en una **separación estricta de responsabilidades**:

- **Core**: Dominio estable y contratos
- **Channels**: Lógica específica por canal (Email, SMS, Push)
- **Providers**: Implementaciones concretas de envío
- **Config**: Punto de entrada y configuración fluida
- **Async**: Extensión mediante patrón Decorator
- **Validation**: Validaciones específicas por canal

📌 El core **no conoce** implementaciones concretas ni frameworks.

---

## ⚙️ Instalación

### Maven

```xml
<dependency>
    <groupId>com.bank.notifications</groupId>
    <artifactId>notifications-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```
---

## 📬 Canales Soportados

**EMAL**:

- **Subject + Body**
- **Validación de formato email**
- **Proveedores**: SendGrid (simulado), Mailgun (extensible)

---

**SMS**:

- **Texto plano (máx. 160 caracteres)**
- **Validación E.164**
- **Proveedores**: Twilio (simulado)
---
**Push Notification**:

- **Title + Body**
- **Device token**
- **Proveedores**: Firebase Cloud Messaging (simulado)

---

## 🧪 Testing

**La librería incluye tests unitarios enfocados en:**:

- **Validaciones por canal**
- **Delegación correcta a providers**
- **Manejo de errores**
- **Envío asíncrono**

📌 No se realizan conexiones HTTP reales.
📌 Se utilizan mocks y simulaciones.

---

## ❌ Manejo de Errores

**La librería incluye tests unitarios enfocados en:**:

- **Errores de validación**: NotificationValidationException
- **Errores de envío**: NotificationResult con estado FAILED o RETRYABLE

---

## 🔐 Seguridad y Buenas Prácticas

**La Seguridad incluye:**:

- **Las credenciales se inyectan por constructor**
- **No se almacenan en archivos ni variables globales**
- **No se loguean datos sensibles**
- **Diseño compatible con Vault / Secrets Manager**

---

## ➕ Cómo agregar un nuevo canal

**La librería incluye tests unitarios enfocados en:**:

- **1.	Crear una implementación de NotificationChannel**
- **2.	Crear un NotificationValidator específico**
- **3.	Definir la interfaz del Provider**
- **4.	Integrar el canal en NotificationClientBuilder**

📌 No es necesario modificar código existente.



