# Get root certificate

As we are using mkcert to generate localhost certificates, we need to find where the root certificate is

```
mkcert -CAROOT
/Users/rmk/Library/Application Support/mkcert
```

Once we know where the root certificate file is, we copy it to **`@raw/trusted_roots`**

```
cat /Users/user/Library/Application\ Support/mkcert/rootCA.pem > android/app/src/main/res/raw/trusted_roots
```

## Custom Root certificate installed on the phone

You could discard all changes and install the root CA on the phone.

Follow the instructions on this [link](https://support.google.com/nexus/answer/2844832?hl=en)

:warning Be aware that you need to do this on all the phones where the application is intended to be used.
