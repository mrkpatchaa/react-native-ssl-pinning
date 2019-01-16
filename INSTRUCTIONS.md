# Get root certificate

As we are using mkcert to generate localhost certificates, we need to find where the root certificate is

```
mkcert -CAROOT
/Users/user/Library/Application Support/mkcert
```

Once we know where the root certificate file is, we copy it to **`@raw/trusted_roots`**

```
cat /Users/user/Library/Application\ Support/mkcert/rootCA.pem > android/app/src/main/res/raw/trusted_roots
```

## Get pin hash from certificate

```
python get_pin_from_certificate.py server/localhost.pem
...
CERTIFICATE INFO
----------------
b'subject= /O=mkcert development certificate/OU=user@MacBook-Pro-user\nissuer= /O=mkcert development CA/OU=user@MacBook-Pro-user/CN=mkcert user@MacBook-Pro-user\nSHA1 Fingerprint=A3:A5:8C:87:11:11:D4:BC:E2:9F:41:16:FF:70:E2:BE:09:D3:6E:77\n'

TRUSTKIT CONFIGURATION
----------------------
kTSKPublicKeyHashes: @[@"b'miRL3esL3Vrr1eKLS1k57h1nZQ0HRGW05zhfUoccP78='"] // You will also need to configure a backup pin
```

The hash is **`miRL3esL3Vrr1eKLS1k57h1nZQ0HRGW05zhfUoccP78=`**

Change values in `android/app/src/main/res/xml/network_security_config.xml`

## Custom Root certificate installed on the phone

You could discard all changes and install the root CA on the phone.

Follow the instructions on this [link](https://support.google.com/nexus/answer/2844832?hl=en)

:warning Be aware that you need to do this on all the phones where the application is intended to be used.
