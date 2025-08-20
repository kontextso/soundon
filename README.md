# @kontextso/soundon

Tiny React Native module to detect if the device media volume is ON (greater than 0).

Works on iOS and Android. No permissions required.

---

## Installation

```bash
# with npm
npm install @kontextso/soundon

# with yarn
yarn add @kontextso/soundon
```

After installing, run platform-specific native installs:

- iOS: from your app's `ios/` directory

```bash
pod install
```

- Android: autolinking will register the module automatically (React Native >= 0.60).

### Expo

This package contains native code. In Expo you need to use a Custom Dev Client or the Bare workflow.

- For development: run `expo prebuild` and use `expo run:ios` / `expo run:android`, or build a custom dev client with EAS.
- Managed workflow without a custom client is not supported.

---

## Usage

```ts
import {isSoundOn} from '@kontextso/soundon';

async function checkVolume() {
  try {
    const on = await isSoundOn();
    console.log('Media volume is', on ? 'ON (> 0)' : 'OFF (0)');
  } catch (e) {
    // iOS may reject if the audio session cannot be activated
    console.warn('Failed to read output volume', e);
  }
}
```

---

## API

- `isSoundOn(): Promise<boolean>`
  - Resolves `true` if the current media/output volume is greater than 0, otherwise `false`.
  - On iOS, the promise can reject (error code: `soundon_error`) if the audio session cannot be activated.

---

## Platform details

- iOS
  - Uses `AVAudioSession.sharedInstance()` and reads `outputVolume`.
  - Temporarily sets the session category to `.ambient` with `.mixWithOthers` and activates the session to read volume.
  - Does not start playback and should not interrupt other audio.

- Android
  - Uses `AudioManager` and compares `STREAM_MUSIC` current volume to its max.

---

## Notes and limitations

- This checks media/output volume only.
- It does NOT account for:
  - iPhone ring/silent switch
  - Do Not Disturb / Focus modes
  - Per‑app volume or hardware controls on external devices
- The value is point-in-time. Call `isSoundOn()` again to refresh. The module does not emit change events.
