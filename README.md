# VariableHintEditText

Create a more interesting user experience by displaying different hints to the user for the same EditText every time they navigate to the same screen.

# Config

In your top-level build.gradle make sure you have jitpack listed as a repository:

```
allprojects {
    repositories {
        maven {
            url 'https://jitpack.io'
        }
        ...
    }
}
```

In your app-specific build.gradle:

```
implementation 'com.github.lewisjdeane:VariableHintEditText:1.0'
```

# Use

### Hints to display

In your strings.xml:

```
    <array name="hints">
        <item>Hint 1</item>
        <item>Hint 2</item>
        <item>Hint 3</item>
    </array>
```

In your layout XML:

```
    <com.lewisdeane.vhedittext.VariableHintEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:hints="@array/hints" />
```

### Include a prefix

To add a prefix to each hint in the array use the attribute `app:hints`:

```
    <com.lewisdeane.vhedittext.VariableHintEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:hints="@array/hints"
        app:hints_prefix="e.g." />
```

# License

Apache License 2.0
