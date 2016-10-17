package com.david.gfire;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Camera camera = Camera.open();
    private Camera.Parameters parameters;
    private boolean islight = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)this.findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (islight) {
                    camera.startPreview();
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    islight = false
                    ;
                    button.setText("关");
                } else {
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    islight = true;
                    button.setText("开");
                }
            }
        });
    }
}
