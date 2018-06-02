package com.android.teaching.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.android.teaching.chatapp.model.MessageModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewMessageActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usernameEditText = findViewById(R.id.edit_text_username);
        messageEditText = findViewById(R.id.edit_text_message);
    }

    public void onClick(View view) {
        MessageModel model = new MessageModel();
        model.setUsername(usernameEditText.getText().toString());
        model.setText(messageEditText.getText().toString());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messages");
        String id = myRef.push().getKey();
        myRef.child(id).setValue(model);

        finish();
    }
}
