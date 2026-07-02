package com.yourname.renderclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Button btnSingleplayer = findViewById(R.id.btn_singleplayer);
        btnSingleplayer.setOnClickListener(v -> {
            try {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.mojang.minecraftpe");
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Minecraft не найден", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Ошибка: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.btn_servers).setOnClickListener(v ->
            Toast.makeText(this, "Сервера (скоро)", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btn_settings).setOnClickListener(v ->
            Toast.makeText(this, "Настройки (скоро)", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btn_exit).setOnClickListener(v -> finish());
    }
}
