# Mir Pay Wallet for Wear OS

<img src="https://github.com/the-dise/Mir-Pay-Wallet/blob/main/images/preview.png?raw=true" width="512">

## Description

[Читать на русском](README.ru.md)

Mir Pay Wallet is an Android application designed to enhance the Mir Pay experience on Wear OS devices. This companion app addresses a specific issue where the screen goes out during a payment transaction, preventing the payment from being completed. Mir Pay Wallet app ensures that the screen remains on until the end of the timer, thereby facilitating successful payments when using Mir Pay on Wear OS watches.

## Features

- Automatic closing of the app when the timer expires.
- 24 different map designs to suit your taste;
- Vibration at startup and end of timer for feedback during blind startup;
- The app includes **Complication**.
- Automatic nfc activation (see point **Nfc**)

## Cards Design

You can familiarize yourself with all possible designs here [CARDS.md](https://github.com/the-dise/Mir-Pay-Wallet/blob/main/CARDS.md)

## Installation

- **Download**:
  - Download the latest release of Mir Pay Wallet APK from the [Releases](https://github.com/the-dise/Mir-Pay-Wallet/releases) section.
- **Enable Developer Options**:
   - On your Android device, go to Settings.
   - Scroll down and find "About phone" or "About device".
   - Look for "Build number" and tap it multiple times (usually 7 times) until you see a message indicating that Developer Options are enabled.
- **Enable Wireless Debugging**:
   - Still in Settings, go back to the main Settings screen.
   - Find and tap on "Developer Options".
   - Scroll down and find "Wireless debugging" or "ADB over network".
   - Enable it. You may be prompted to confirm your device's security PIN or pattern.
- **Connect via ADB**:
   - On your computer, open a terminal or command prompt.
   - Enter the following command: `adb connect <device_ip_address>` (replace `<device_ip_address>` with the IP address of your Android device).
- **Install APK:**
  - Use the command `adb install <path_to_apk>` in the terminal or command prompt
- **[Optional] Setting up automatic nfc activation (see point **Nfc**):**
  - Use the command `adb shell pm grant me.thedise.mirpayinvoke android.permission.WRITE_SECURE_SETTINGS` in the terminal or command line.
  - If you change your mind, you can revoke the permissions with the command `adb shell pm revoke me.thedise.mirpayinvoke android.permission.WRITE_SECURE_SETTINGS`.

Ensure ADB is installed on your computer and your network allows communication between the devices.

## Usage

- Open Mir Pay Wallet on your Wear OS device.
- Perform Mir Pay transactions without the screen turning off.
- After the timer expires, the application will be automatically closed

## Nfc

There is also a way to automatically turn on the NFC module when opening the application, however, special permissions must be granted for this.

The fact is that nfc activation/deactivation is part of the system API, which, for security reasons, is not available to ordinary developers.

This is well explained in the project [nfc-quick-settings](https://github.com/pcolby/nfc-quick-settings/tree/main?tab=readme-ov-file#advanced-mode).

_If you do not set up automatic NFC activation, the application will work normally._

### Additional functions

- Automatic NFC activation when opening the application.
- Automatic deactivation of NFC when closing the application*.
- Checking the active nfc during the timer operation.

_*If NFC was activated before logging into the application (in advance), then after its completion, it will not be deactivated._

## Contributing

If you encounter any issues or have suggestions for improvement, please feel free to open an [issue](https://github.com/the-dise/Mir-Pay-Wallet/issues) or submit a [pull request](https://github.com/the-dise/Mir-Pay-Wallet/pulls).

## License

Mir Pay Wallet is licensed under the [GPL-3.0 License](https://github.com/the-dise/Mir-Pay-Wallet/blob/main/LICENSE).

## Acknowledgments

- Gorban - original idea;
- [s44khin](https://github.com/s44khin) and his [MirPayTimer](https://github.com/s44khin/MirPayTimer)
- [AndroidX Core-KTX](https://developer.android.com/kotlin/ktx)
- [AndroidX Wear](https://developer.android.com/jetpack/androidx/releases/wear)
- [AndroidX Wear Compose Foundation](https://developer.android.com/jetpack/androidx/releases/wear)
- [Horologist by Google](https://github.com/google/horologist)

## Star History

<a href="https://star-history.com/#the-dise/Mir-Pay-Wallet&Date">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://api.star-history.com/svg?repos=the-dise/Mir-Pay-Wallet&type=Date&theme=dark" />
    <source media="(prefers-color-scheme: light)" srcset="https://api.star-history.com/svg?repos=the-dise/Mir-Pay-Wallet&type=Date" />
    <img alt="Star History Chart" src="https://api.star-history.com/svg?repos=the-dise/Mir-Pay-Wallet&type=Date" />
  </picture>
</a>

---

<p align="center"><b>Made with ❤️ by Dise</b></p>
