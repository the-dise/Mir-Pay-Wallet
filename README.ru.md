# Кошелек Mir Pay для Wear OS

<img src="https://github.com/the-dise/Mir-Pay-Wallet/blob/main/images/preview.png?raw=true" width="512" height="512">

## Описание

[Read in English](README.md)

Mir Pay Wallet - это приложение для Android, предназначенное для улучшения работы Mir Pay на устройствах Wear OS. Это приложение-компаньон решает конкретную проблему, когда экран гаснет во время платежной операции, не позволяя завершить платеж. Приложение Mir Pay Wallet гарантирует, что экран останется включенным до конца таймера, тем самым способствуя успешным платежам при использовании Mir Pay на часах Wear OS.

## Особенности

- Автоматическое закрытие приложения по истечении таймера.
- 24 различных дизайна карт на ваш вкус;
- Вибрация при запуске и окончанию таймера для обратной связи при запуске вслепую;
- Приложение включает в себя **Комплектацию**.

## Дизайн карт

![gallery](/images/cards-preview.png)

## Установка

- **Загрузка**:
  - Загрузите последнюю версию Mir Pay Wallet APK из раздела [Releases](https://github.com/the-dise/Mir-Pay-Wallet/releases).
- **Включите опции разработчика**:
   - На вашем Android-устройстве перейдите в "Настройки".
   - Прокрутите вниз и найдите "О телефоне" или "Об устройстве".
   - Найдите пункт "Номер сборки" и нажмите на него несколько раз (обычно 7 раз), пока не появится сообщение о том, что опции разработчика включены.
- **Включите беспроводную отладку**:
   - Все еще находясь в "Настройках", вернитесь на главный экран "Настройки".
   - Найдите и нажмите на "Параметры разработчика".
   - Прокрутите вниз и найдите пункт "Беспроводная отладка" или "ADB по сети".
   - Включите его. Вам может быть предложено подтвердить PIN-код или шаблон безопасности вашего устройства.
- **Подключение через ADB**:
   - На компьютере откройте терминал или командную строку.
   - Введите следующую команду: `adb connect <device_ip_address>` (замените `<device_ip_address>` на IP-адрес вашего Android-устройства).
- **Установка APK:**.
  - Используйте команду `adb install <путь_к_apk>` в терминале или командной строке.  

Убедитесь, что ADB установлен на вашем компьютере, а сеть разрешает связь между устройствами.

## Использование

- Откройте Mir Pay Wallet на своем устройстве под управлением Wear OS.
- Выполняйте операции Mir Pay без отключения экрана.
- По истечении таймера приложение будет автоматически закрыто.

## Contributing

Если вы столкнулись с какими-либо проблемами или у вас есть предложения по улучшению, пожалуйста, не стесняйтесь открыть [issue](https://github.com/the-dise/Mir-Pay-Wallet/issues) или отправить [pull request](https://github.com/the-dise/Mir-Pay-Wallet/pulls).

## License

Mir Pay Wallet лицензирован под [GPL-3.0 License](https://github.com/the-dise/Mir-Pay-Wallet/blob/main/LICENSE).

## Acknowledgments

- Gorban - оригинальная идея;
- [s44khin](https://github.com/s44khin) и его [MirPayTimer](https://github.com/s44khin/MirPayTimer)
- [AndroidX Core-KTX](https://developer.android.com/kotlin/ktx)
- [AndroidX Wear](https://developer.android.com/jetpack/androidx/releases/wear)
- [AndroidX Wear Compose Foundation](https://developer.android.com/jetpack/androidx/releases/wear)
- [Horologist by Google](https://github.com/google/horologist)

---

<p align="center"><b>Сделано с ❤️ от Дайса</b></p>
