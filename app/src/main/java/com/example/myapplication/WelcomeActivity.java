// WelcomeActivity.java (Pantalla de Bienvenida)
package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    private TextView welcomeMessage;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeMessage = findViewById(R.id.textViewWelcome);
        logoutButton = findViewById(R.id.buttonLogout);

        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String userEmail = preferences.getString("email", "Usuario");
        welcomeMessage.setText("Bienvenido, " + userEmail);

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
