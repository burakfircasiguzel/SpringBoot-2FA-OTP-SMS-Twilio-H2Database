<h1 align="center" id="title">Springboot 2FA OTP SMS with Twilio</h1>

![SpringBoot-2FA-OTP-SMS-Twilio-H2Database](https://socialify.git.ci/burakfircasiguzel/SpringBoot-2FA-OTP-SMS-Twilio-H2Database/image?description=1&descriptionEditable=Two%20Factor%20Authentication%20Usage%20%26%20Sending%20OTP%20SMS%20Using%20Twilio&font=Raleway&language=1&name=1&owner=1&pattern=Charlie%20Brown&theme=Light)

<p id="description">Two Factor Authentication Usage &amp; Sending OTP SMS Using Twilio</p>

  
  
<h2>🧐 Features</h2>

Here're some of the project's best features:

*   Two Factor Authentication (2FA)
*   One Time Password (OTP)
*   Sending SMS
<br>

<h2>🛠️ Installation Steps:</h2>

<br>

<p>1. 1</p>

```yml
- Enter the API information you got from twilio.com into application.yml

twilio:
  account_sid: #your account sid
  auth_token: #your auth token
  trial_number: # your trial number
```

<p>1. 2</p>

```yml
- Run the application
```
<h2>🎈 Usage Steps:</h2>

<h4>1 - Register</h4>

- To register first, Make a POST request at "/user/register" like a

```java
{
    "username" : "burak",
    "password" : "123456",
    "telephoneNumber": "+905555555555"   
}
```
<br><br>
<h4>2 - Normal Login</h4>
- To normal login, Make a POST request at  "/user" like a

```java
{
    "username" : "burak",
    "password" : "123456"
}
```
- If the credentials are `correct` , an OTP code will be sent to the phone number registered via SMS.

<br><br>

<h4>3 - Login with OTP Code</h4>
- Add the code in the incoming SMS to the request
<br>
- To OTP login, Make a POST request at "/user/secret" like a

```java
{
    "username" : "burak",
    "code" : "148253"
}
```
- If the code is `correct`, it will return the message `"Welcome to the hidden page"`.
- That's it.


<br>

  
  
<h2>💻 Built with</h2>

Technologies used in the project:

*   Java
*   Springboot
*   H2 Database
*   Two Factor Authentication
*   One Time Password
