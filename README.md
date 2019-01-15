# SSL experimentation in React Native

This project aims to show different cases of communication over SSL between your React Native application and your api.

Check branches for cases:

- Master branch without any SSL configuration. If you try to run application and press the button , you'll have this error : **`java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.`**
- Disable SSL verification :danger
- Add trusted anchor for certificate path
- Even more security with SSL pinning

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
