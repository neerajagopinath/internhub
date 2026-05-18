# Authentication API

## Base URL

```plaintext
http://localhost:8080
```

---

# Signup API

## Endpoint

```plaintext
POST /account/signup
```

---

## Request Body

```json
{
  "name": "Neeraja",
  "email": "test@gmail.com",
  "password": "password123"
}
```

---

## Success Response

```json
{
  "message": "Signup successful"
}
```

---

## Possible Errors

- Email already exists
- Invalid password
- Validation failure