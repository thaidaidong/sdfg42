# S7 LocalOnlyHotspot prototype (Android 8, API 26+)

This is a **prototype source project**, not a built/tested APK. Open with Android Studio, JDK 17, and build debug APK. Uses AGP 8.5.2 (Gradle wrapper not included; Android Studio may prompt for Gradle setup).

## Purpose
Try Android 8 WifiManager.startLocalOnlyHotspot on SM-G930S without SIM. Starts HTTP server on 0.0.0.0:8080, displays Bluetooth adapter state and paired devices. **No Bluetooth scanning, pairing, A2DP connection or web password** in this prototype. It is deliberately read-only. Do not expose port 8080 to the Internet.

## Steps
1. On S7, turn on Location in system Settings and grant Location permission to app. Turn on Wi-Fi if needed.
2. Launch app, tap Start. Watch `adb logcat -s S7Hotspot:I '*:S'` for SSID and password. These credentials are printed to ADB logcat: use only for private testing.
3. Join the generated SSID on iPhone. iPhone may say No Internet; stay connected.
4. Find the hotspot gateway address in iPhone Wi-Fi details under Router (often 192.168.43.1 but not guaranteed). Open `http://<router-address>:8080`.
5. If `onFailed` appears, firmware may disallow LocalOnlyHotspot; use a separate Wi-Fi router instead.

## Caveats
- Samsung firmware may require SIM even for LocalOnlyHotspot. Cannot guarantee success without testing.
- Service is foreground only after user starts it; **no boot receiver** is included. Android 8 may stop it under power management.
- Server is bound to all interfaces and has no authentication. Add authentication before real deployment.
- Do not remove phone display before verifying restart and recovery paths.
- Android's public A2DP APIs cannot force-connect an arbitrary paired speaker from an ordinary app.
