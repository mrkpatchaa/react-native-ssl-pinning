# Communicating over SSL in React Native

This project aims to show different cases of communication over SSL between your React Native application and your api.

Check branches for cases:

- Master branch without any SSL configuration. If you try to run application and press the button , you'll have this error : **`java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.`**
- Disable SSL verification :danger
- Add trusted anchor for certificate path
- Even more security with SSL pinning
- SSL pinning using [TrustKit](https://github.com/datatheorem/TrustKit-Android)

\***Notice:** I did not implement iOS versions. You can find how to do it [here](https://medium.com/@jaedmuva/react-native-ssl-pinning-is-back-ios-version-814dfce2400c) and [here](https://github.com/datatheorem/TrustKit/blob/master/docs/getting-started.md).

You can read more about SSL pinning (and security) in React Native with theses links:

- [https://medium.com/@jaedmuva/react-native-ssl-pinning-is-back-e317e6682642](https://medium.com/@jaedmuva/react-native-ssl-pinning-is-back-e317e6682642)
- [https://www.madebymany.com/stories/a-year-of-react-native-ssl-pinning](https://www.madebymany.com/stories/a-year-of-react-native-ssl-pinning)
- [http://tech.taskrabbit.com/blog/2016/06/17/enable-tls-android-with-react-native/](http://tech.taskrabbit.com/blog/2016/06/17/enable-tls-android-with-react-native/)
- [https://developer.android.com/training/articles/security-config](https://developer.android.com/training/articles/security-config)
- [https://www.owasp.org/index.php/Certificate_and_Public_Key_Pinning](https://www.owasp.org/index.php/Certificate_and_Public_Key_Pinning)

Reference and misc :

- [https://github.com/hawkup/react-native-ssl-pinning](https://github.com/hawkup/react-native-ssl-pinning)
- [https://github.com/localz/react-native-pinch](https://github.com/localz/react-native-pinch)
- [https://github.com/approov/react-native-cert-pinner](https://github.com/approov/react-native-cert-pinner)
- [https://github.com/wkh237/react-native-fetch-blob](https://github.com/wkh237/react-native-fetch-blob)
- [https://github.com/joltup/rn-fetch-blob](https://github.com/joltup/rn-fetch-blob)

## Installation

```
yarn
```

## Launch the server

```
yarn server
```

## Launch application

### iOS

```
yarn ios
```

### Android

```
yarn android
```

### Testing

You can view console in Chrome or in [React Native Debugger](https://github.com/jhen0409/react-native-debugger)

Launch application and press button to make api call.
