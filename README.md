# ClockView

![SampleScreenshot](https://38.media.tumblr.com/100b0ad24fa7869af91ef1be8babce98/tumblr_nhsujcSRmf1u4as5ao1_r3_1280.png)

## How to

Download ClockView and import it to your workspace and add this as a module.

## XML Usage
>```xml
><com.plusquare.clockview.ClockView 
>    xmlns:app="http://schemas.android.com/apk/res-auto"
>    android:layout_width="96dp"
>    android:layout_height="96dp"
>    app:clockColor="[color]"
>    app:h="[HH]"
>    app:m="[mm]"/>
>```

## Java Usage
>```java
> clockview.setClockColor([color]); // Set clock color
> clockview.setHour([HH]); // Set clock hour
> clockview.setMinute([mm]); // Set clock minute
>```
